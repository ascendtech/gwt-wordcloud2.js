package us.ascendtech.wordcloud2.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.SimplePanel;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;
import us.ascendtech.wordcloud2.shared.WordCloudClientBundle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This is a GWT Wrapper for wordcloud2.js (http://timdream.org/wordcloud2.js/)
 * Released under the MIT license
 * @author Payam Meyer (https://github.com/payammeyer)
 *
 */
public abstract class WordCloudChart extends SimplePanel {

	private static WordCloudClientBundle bundle = GWT.create(WordCloudClientBundle.class);
	private static final Map<String, WordCloudChart> instanceMap = new HashMap<>();

	private WordCloud2ChartOptions options;
	private String instanceId;

	static {
		ScriptInjector.fromString(bundle.wordcloud2js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		WordCloudChart.exportStaticMethod();
	}

	/**
	 * Creates random ID for this chart.
	 * @return randomId String
	 */
	protected static native String generateId() /*-{
        var CHARS = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
        //http://www.broofa.com/Tools/Math.uuid.js
        var chars = CHARS, uuid = new Array(36), rnd = 0, r;
        for (var i = 0; i < 36; i++) {
            if (i == 8 || i == 13 || i == 18 || i == 23) {
                uuid[i] = '-';
            } else if (i == 14) {
                uuid[i] = '4';
            } else {
                if (rnd <= 0x02) rnd = 0x2000000 + (Math.random() * 0x1000000) | 0;
                r = rnd & 0xf;
                rnd = rnd >> 4;
                uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
            }
        }
        return uuid.join('');
    }-*/;

	private static void clickedWord(String instanceId, String tag, int frequency) {
		instanceMap.get(instanceId).clickedWord(tag, frequency);
	}

	public static native void exportStaticMethod() /*-{
        $wnd.clickedWord =
            @us.ascendtech.wordcloud2.client.WordCloudChart::clickedWord(Ljava/lang/String;Ljava/lang/String;I);
    }-*/;

	/**
	 * Abstract method to be implemented by the user of the class to handle clicking on words on the word cloud
	 * @param tag
	 * @param frequency
	 */
	public abstract void clickedWord(String tag, int frequency);

	public WordCloudChart() {
		this.instanceId = generateId();
		instanceMap.put(this.instanceId, this);

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				draw();
			}
		});
	}

	/**
	 * Sets the chart data and options. Has to be set by the caller.
	 * @param data list of {@code WordCloudChartData}
	 * @param options wordcloud2.js options
	 */
	public void setChartDataAndOptions(List<WordCloudChartData> data, WordCloud2ChartOptions options) {
		if (data == null || options == null) {
			return;
		}

		this.options = options;

		JsArray<JavaScriptObject> jsonData = JsArray.createArray().cast();
		for (WordCloudChartData w : data) {
			JsArrayMixed word = JsArrayMixed.createArray().cast();
			word.push(w.getWord());
			word.push(w.getFrequency());
			jsonData.push(word);
		}

		this.options.setInstanceId(instanceId);
		this.options.setList(jsonData);
	}

	/**
	 * Draws the word cloud on canvas. This should be called after the container has been added to the DOM
	 */
	public void draw() {
		this.clear();

		Canvas canvas = Canvas.createIfSupported();
		canvas.getElement().setId("canvas");
		canvas.setPixelSize(Window.getClientWidth() - 200, 800);
		canvas.setCoordinateSpaceWidth(Window.getClientWidth() - 200);
		canvas.setCoordinateSpaceHeight(800);
		add(canvas);

		jsDraw2(canvas.getElement(), options);

	}

	private native void jsDraw2(Element wordCloudGraph, JavaScriptObject options) /*-{
        wordCloud = new $wnd.WordCloud(wordCloudGraph, options);
    }-*/;

}

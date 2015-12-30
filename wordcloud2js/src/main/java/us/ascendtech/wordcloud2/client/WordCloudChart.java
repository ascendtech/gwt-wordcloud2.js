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

public abstract class WordCloudChart extends SimplePanel {

	private static WordCloudClientBundle bundle = GWT.create(WordCloudClientBundle.class);
	private static final Map<String, WordCloudChart> instanceMap = new HashMap<>();

	private List<WordCloudChartData> wordCloudChartData;
	private String instanceId;

	static {
		ScriptInjector.fromString(bundle.wordcloud2js().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
		WordCloudChart.exportStaticMethod();
	}

	protected static final native String generateId() /*-{
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

	private static void clickedWord(String instanceId, String abbreviatedTag, int frequency, String tag) {
		instanceMap.get(instanceId).clickedWord(tag, abbreviatedTag, frequency);
	}

	public static native void exportStaticMethod() /*-{
        $wnd.clickedWord =
            @us.ascendtech.wordcloud2.client.WordCloudChart::clickedWord(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;);

    }-*/;

	public abstract void clickedWord(String tag, String abbreviatedTag, int frequency);

	public WordCloudChart() {
		this.instanceId = generateId();
		//addStyleName(UserController.userCss().wordCloudPadding());
		instanceMap.put(this.instanceId, this);

		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(ResizeEvent event) {
				draw();
			}
		});
	}

	public void setChartData(List<WordCloudChartData> data) {
		this.wordCloudChartData = data;
	}

	public void draw() {
		this.clear();

		JsArray<JavaScriptObject> data = JsArray.createArray().cast();
		for (WordCloudChartData w : wordCloudChartData) {
			JsArrayMixed word = JsArrayMixed.createArray().cast();
			word.push(w.getAbbreviatedWord());
			word.push(w.getFrequency());
			word.push(w.getWord());
			data.push(word);
		}

		WordCloud2ChartOptions options = WordCloud2ChartOptions.create();
		options.setList(data);
		options.setWeightFactor(1.5);
		options.setGridSize(12);
		options.setInstanceId(instanceId);

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

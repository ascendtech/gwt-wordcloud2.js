package us.ascendtech.wordcloud2.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * These are some of the options provided by wordcloud2.js. They can be extended as needed.
 */
public class WordCloud2ChartOptions extends JavaScriptObject {

	public static WordCloud2ChartOptions create() {
		return createObject().cast();
	}

	protected WordCloud2ChartOptions() {
	}

	/**
	 * Sets the data for the word cloud
	 * @param list the data for the word cloud
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setList(JsArray<JavaScriptObject> list) /*-{
        this.list = list;
        return this;
    }-*/;

	/**
	 * Sets the grid size
	 * @param gridSize grid size of the chart
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setGridSize(int gridSize) /*-{
        this.gridSize = gridSize;
        return this;
    }-*/;

	/**
	 * Sets the origin which is used to determine the center of the chart
	 * @param origin the origin
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setOrigin(JsArrayInteger origin) /*-{
        this.origin = origin;
        return this;
    }-*/;

	/**
	 * Sets the weight factor to be used to draw the words
	 * @param weightFactor double weight factor
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setWeightFactor(double weightFactor) /*-{
        this.weightFactor = weightFactor;
        return this;
    }-*/;

	/**
	 * The unique instance ID to be assigned to this chart
	 * @param instanceId string instance ID
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setInstanceId(String instanceId) /*-{
        this.instanceId = instanceId;
        return this;
    }-*/;

	/**
	 * Sets the minimum size of the chart
	 * @param minSize integer minimum size
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setMinSize(int minSize) /*-{
        this.minSize = minSize;
        return this;
    }-*/;

	/**
	 * Sets the rotation ratio
	 * @param rotateRatio double rotation ratio
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setRotateRatio(double rotateRatio)  /*-{
        this.rotateRatio = rotateRatio;
        return this;
    }-*/;

	/**
	 * Sets the background color.
	 * @param backgroundColor string color
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setBackgroundColor(String backgroundColor)  /*-{
        this.backgroundColor = backgroundColor;
        return this;
    }-*/;

	/**
	 * Sets the javascript function to be used for color
	 * @param colorFunction javascript function to be used for the color
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setColorFunction(JavaScriptObject colorFunction)  /*-{
        this.color = colorFunction;
        return this;
    }-*/;

	/**
	 * Sets the font family to be used by the chart
	 * @param fontFamily string comma separated font family
	 * @return this javascript object
	 */
	public final native WordCloud2ChartOptions setFontFamily(String fontFamily)  /*-{
        this.fontFamily = fontFamily;
        return this;
    }-*/;

}

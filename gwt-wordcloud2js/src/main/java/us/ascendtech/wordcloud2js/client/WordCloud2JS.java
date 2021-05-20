package us.ascendtech.wordcloud2js.client;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Payam Meyer
 * Docs: https://github.com/timdream/wordcloud2.js/blob/gh-pages/API.md
 */
@JsType(namespace = JsPackage.GLOBAL, isNative = true, name = "WordCloud")
public class WordCloud2JS {

	public WordCloud2JS(String elementId, WordCloud2JSOptions wordCloud2JSOptions) {
	}

	public native static void stop();

	public native static Boolean isSupported();

	public native static void minFontSize(Double minFontSize);

}

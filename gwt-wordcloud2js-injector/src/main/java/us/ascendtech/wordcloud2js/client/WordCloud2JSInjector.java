package us.ascendtech.wordcloud2js.client;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class WordCloud2JSInjector {

	public static void inject() {
		ScriptInjector.fromUrl("https://github.com/timdream/wordcloud2.js/blob/gh-pages/src/wordcloud2.js").setCallback(new Callback<Void, Exception>() {
			@Override
			public void onFailure(Exception reason) {
				GWT.log("Failed to load required library, Please file a ticket");
			}

			@Override
			public void onSuccess(Void result) {
				GWT.log("Successfully loaded WordCloud2JS");
			}
		}).setWindow(ScriptInjector.TOP_WINDOW).inject();

	}

}

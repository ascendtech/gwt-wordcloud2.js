package us.ascendtech.wordcloud2.shared;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * Client Bundle that loads the java script file.
 */
public interface WordCloudClientBundle extends ClientBundle {

	@Source("wordcloud2.js")
	TextResource wordcloud2js();

}
package us.ascendtech.webapp.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;

import java.util.List;

public interface ExampleServiceAsync {

	void getWordCloudData(AsyncCallback<List<WordCloudChartData>> asyncCallback);
}

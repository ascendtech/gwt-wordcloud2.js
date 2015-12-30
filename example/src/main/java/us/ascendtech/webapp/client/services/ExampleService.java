package us.ascendtech.webapp.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;

import java.util.List;

@RemoteServiceRelativePath("example")
public interface ExampleService extends RemoteService {

	List<WordCloudChartData> getWordCloudData();
}
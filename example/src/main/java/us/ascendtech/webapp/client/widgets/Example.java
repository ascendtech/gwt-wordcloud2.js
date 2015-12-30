package us.ascendtech.webapp.client.widgets;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;
import org.gwtbootstrap3.client.ui.html.Div;
import us.ascendtech.webapp.client.services.ExampleServiceProvider;
import us.ascendtech.wordcloud2.client.WordCloudChart;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;

import java.util.List;

/**
 * Created by pmeyer on 12/30/15.
 */
public class Example implements EntryPoint {

	@Override
	public void onModuleLoad() {

		final Div main = new Div();

		WordCloudChart wordCloudChart = new WordCloudChart() {
			@Override
			public void clickedWord(String tag, String abbreviatedTag, int frequency) {
				// TODO: Implement clicking on words
			}
		};

		main.add(wordCloudChart);

		ExampleServiceProvider.get().getExampleService().getWordCloudData(new AsyncCallback<List<WordCloudChartData>>() {
			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(List<WordCloudChartData> result) {
				wordCloudChart.setChartData(result);

				RootPanel.get().add(main);
			}
		});

	}

}

package us.ascendtech.webapp.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import us.ascendtech.webapp.client.services.ExampleService;
import us.ascendtech.wordcloud2.shared.WordCloudChartData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExampleServiceImpl extends RemoteServiceServlet implements ExampleService {

	private static final long serialVersionUID = 1L;

	@Override
	public List<WordCloudChartData> getWordCloudData() {

		List<WordCloudChartData> data = new ArrayList<>();

		final Map<String, Integer> wordToFrequencyMap = new HashMap<>();
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(ExampleServiceImpl.class.getResourceAsStream("/words.txt")))) {
			buffer.lines().forEach(s -> {
				String[] tokens = s.split("\\s");
				wordToFrequencyMap.put(tokens[1], Integer.valueOf(tokens[0]));
			});
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		for (String key : wordToFrequencyMap.keySet()) {
			data.add(new WordCloudChartData("", key, wordToFrequencyMap.get(key)));
		}

		return data;
	}
}

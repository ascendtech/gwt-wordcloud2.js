package us.ascendtech.wordcloud2.shared;

import java.io.Serializable;

/**
 * Created by pmeyer on 12/30/15.
 */
public class WordCloudChartData implements Serializable {

	private String word;
	private int frequency;

	// Default constructor for GWT
	public WordCloudChartData() {
	}

	public WordCloudChartData(String word, int frequency) {
		this.word = word;
		this.frequency = frequency;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return "WordCloudChartData{" +
				"word='" + word + '\'' +
				", frequency=" + frequency +
				'}';
	}
}

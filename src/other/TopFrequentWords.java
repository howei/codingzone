package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopFrequentWords {

	public static final String SPACE = " ";
	public static final String NON_LOWERCASE_LETTER_REGEX = "[^a-z]+";
	public static final TopFrequentWords instance = new TopFrequentWords();
	/**
	 * Given a String representing the contents of a text document and an
	 * integer providing the number of items to return. Return a list of Strings
	 * ordered by word frequency, the most frequently occurring word first.
	 * 
	 * @param text
	 * @param numberOfItems
	 * @return a List of String
	 */
	public static List<String> getTopFrequentWords(String text,
			int numberOfItems) {

		if (text == null) {
			System.out.println("TopFrequentWords: Input String is null!");
			return null;
		}
		if (numberOfItems <= 0) {
			System.out
					.println("TopFrequentWords: Number of items should be a positive number! numberOfItems input is "
							+ numberOfItems);
			return null;
		}
		List<String> res = new ArrayList<String>();
		if (text.length() == 0) {
			System.out
					.println("TopFrequentWords: Length of input String is 0!");
			return res;
		}

		text = text.toLowerCase();
		text = text.replaceAll(NON_LOWERCASE_LETTER_REGEX, SPACE);
		text = text.trim();
		String[] wordArray = text.split(SPACE);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : wordArray) {
			map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
		}

		Comparator<WordFrequency> wordFreqComparator = instance.new WordFreqComparator();
		PriorityQueue<WordFrequency> priorityQueue = new PriorityQueue<WordFrequency>(
				numberOfItems, wordFreqComparator);
		for (Entry<String, Integer> e : map.entrySet()) {
			String word = e.getKey();
			int freqency = e.getValue();
			WordFrequency wordFrequency = instance.new WordFrequency(word, freqency);
			if (priorityQueue.size() < numberOfItems) {
				priorityQueue.add(wordFrequency);
			} else {
				if (priorityQueue.peek().freqency < freqency) {
					priorityQueue.remove();
					priorityQueue.add(wordFrequency);
				}
			}
		}

		while (!priorityQueue.isEmpty()) {
			res.add(0, priorityQueue.poll().word);
		}
		return res;
	}

	public class WordFreqComparator implements Comparator<WordFrequency> {
		@Override
		public int compare(WordFrequency word1, WordFrequency word2) {
			if (word1.freqency > word2.freqency) {
				return 1;
			} else if (word1.freqency < word2.freqency) {
				return -1;
			}
			return 0;
		}
	}

	public class WordFrequency {
		public String word;
		public int freqency;

		public WordFrequency(String word, int freqency) {
			this.word = word;
			this.freqency = freqency;
		}
	}
}

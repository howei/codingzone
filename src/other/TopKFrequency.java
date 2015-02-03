package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequency {
	public static List<String> solve(String text, int k) {
		if (text == null || text.length() == 0 || k <= 0) {
			return null;
		}
		text = text.toLowerCase();
		text = text.replaceAll("[^a-z]+", " ");
		text = text.trim();
		String[] textArray = text.split("[^a-z]+");
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (String s : textArray) {
			map.put(s, map.containsKey(s)? map.get(s) + 1 : 1);
		}
		
		Comparator<Word> wordFreqComparator = new TopKFrequency().new WordFreqComparator();
		PriorityQueue<Word> pq = new PriorityQueue<Word>(k, wordFreqComparator);
		for (Entry<String, Integer> e  : map.entrySet()) {
			String word = e.getKey();
			int freq = e.getValue();
			Word newWord = new TopKFrequency().new Word(word, freq);
			if (pq.size() < k) {
				pq.add(newWord);
			} else {
				if (pq.peek().freq < freq) {
					pq.remove();
					pq.add(newWord);
				}
			}
		}
		List<String> res = new ArrayList<String>();
		while (!pq.isEmpty()) {
			res.add(0, pq.poll().word);
		}
		return res;
	}
	
	public class Word {
		public String word;
		public int freq;
		public Word(String word, int freq) {
			this.word = word;
			this.freq = freq;
		}
	} 
	
	public class WordFreqComparator implements Comparator<Word> {
		@Override
		public int compare (Word word1, Word word2) {
			if (word1.freq > word2.freq) {
				return 1;
			} else if (word1.freq < word2.freq) {
				return -1;
			}
			return 0;
		}
	}
}

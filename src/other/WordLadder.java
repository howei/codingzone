package other;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		int length = start.length();
		Queue<String> queue = new LinkedList<String>();
		queue.add(start);
		Queue<String> tmpQueue = new LinkedList<String>();
		int dist = 1;
		while (!queue.isEmpty()) {
			while (!queue.isEmpty()) {
				String word = queue.poll();
				if (word.equals(end)) {
					return dist;
				} else {
					for (int i = 0; i < length; i++) {
						for (char j = 'a'; j <= 'z'; j++) {
							String newWord = word.substring(0, i) + j
									+ word.substring(i + 1, length);
							if (newWord.equals(end)) {
								return dist + 1;
							}
							if (word.charAt(i) != j
									&& dict.contains(newWord)) {
								tmpQueue.add(newWord);
								dict.remove(newWord);
							}
						}
					}
				}
			}
			dist++;
			queue.addAll(tmpQueue);
			tmpQueue.clear();
		}
		return 0;
	}
}

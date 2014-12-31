package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
		List<String> res = new ArrayList<String>();
		if (words == null || words.length == 0) {
			return res;
		}
		int i = 0;
		while (i < words.length) {
			int j = i;
			while (j < words.length && words[j].equals("")) {
				j++;
			}
			if (j >= words.length) {
				String line = "";
				for (int ind = 0; ind < L; ind++) {
					line += " ";
				}
				res.add(line);
				break;
			}
			List<String> line = new ArrayList<String>();
			line.add(words[j]);
			int currLen = words[j].length();
			int nSpace = 0;
			while (j + 1 < words.length && currLen + words[j + 1].length() < L) {
				j++;
				if (!words[j].equals("")) {
					line.add(" " + words[j]);
					currLen += 1 + words[j].length();
					nSpace++;
				}
			}
			int tSpace = L - currLen;
			String lineStr = line.get(0);
			if (nSpace != 0 && j != words.length - 1) {
				if (tSpace % nSpace != 0) {
					for (int ind = 1; ind <= tSpace % nSpace; ind++) {
						for (int nS = 0; nS <= tSpace / nSpace; nS++) {
							lineStr += " ";
						}
						lineStr += line.get(ind);
					}
				}
				for (int ind = tSpace % nSpace + 1; ind <= nSpace; ind++) {
					int nS = 0;
					while (nS < tSpace / nSpace) {
						lineStr += " ";
						nS++;
					}
					lineStr += line.get(ind);
				}
			} else {
				int ind = 1;
				while (ind < line.size()) {
					lineStr += line.get(ind);
					ind++;
				}
				int nS = 0;
				while (nS < L - currLen) {
					lineStr += " ";
					nS++;
				}
			}
			res.add(lineStr);
			i = j + 1;
		}
		return res;
	}
	
}

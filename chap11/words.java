package entry;

import java.util.*;

class Word {
	public String content;
	public int count;
	public Word(String content, int count) {
		this.content = content;
		this.count = count;
	}
	public void addCount() {
		this.count += 1;
	}
	public String toString() {
		return this.content + " " + this.count;
	}
}

class Main {
	public static void main(String[] args) {
		List<String> testData = new ArrayList<String>();
		Set<Word> words = new HashSet<Word>();
		
		Collections.addAll(
			testData,
			"hello", "world", "maple",
			"I", "am", "you", "love",
			"I", "maple", "world"
		);
		
		Collections.sort(testData, String.CASE_INSENSITIVE_ORDER);
		
		for (int i = 0, size = testData.size(); i < size; i++) {
			String word = testData.get(i);
			int count = testData.lastIndexOf(word) - i + 1;
			words.add(new Word(word, count));
			// update position
			i += count - 1;
		}
		
		System.out.println(words);
	}
}

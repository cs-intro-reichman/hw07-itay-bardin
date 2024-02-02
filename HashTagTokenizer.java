

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i = 0; i < dictionary.length; i++){
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean exists = false;
		for(int i = 0; i < dictionary.length; i++){
			if (dictionary[i].equals(word)) {
				exists = true;
			}
		}
		return exists;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
		String lowerCasedHashtag = hashtag.toLowerCase();
        int N = hashtag.length();
		for (int i = 1; i <= N; i++) {
			String currentSubstring = lowerCasedHashtag.substring(0, i);
			if (existInDictionary(currentSubstring, dictionary)) {
				System.out.println(currentSubstring);
				breakHashTag(lowerCasedHashtag.substring(i), dictionary);
				return;
			}
    	}	
	}
}
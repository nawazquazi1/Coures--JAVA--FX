package application;

public class PigLatinTranslator {
	
	private boolean isVowel(char c) {
		return "aeiouy".indexOf(c) != -1;
	}
	
	public String translate(String word) {
		int length = word.length();
		int index = -1;
		
		for(int i=0;i<length;i++) {
			if(isVowel(word.charAt(i))) {
				index = i;
				break;
			}
		}
		
		// Pig latin is only possible if the
		// word contains vowels
		if(index == -1 ) {
			return null;
		}
		return word.substring(index) + word.substring(0, index) + "ay";
	}
}

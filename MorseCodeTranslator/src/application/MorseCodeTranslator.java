package application;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {

    Map<Character, String> morseToTextMapping = new HashMap<Character, String>();
    Map<String, Character> textToMorseMapping = new HashMap<String, Character>();

    char[] letter = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0', ' ' };

    String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "/" };

    public MorseCodeTranslator() {
        setupMap();
    }

    private void setupMap(){
        for (int i = 0; i < letter.length; i++) {
            morseToTextMapping.put(letter[i], morse[i]);
            textToMorseMapping.put(morse[i], letter[i]);
        }
    }

    public String translateToMorse(String text){
        char[] characters = text.toCharArray();
        StringBuilder morseString = new StringBuilder();

        for (char character : characters) {
            morseString.append(morseToTextMapping.get(character)).append(" ");
        }
        return String.valueOf(morseString);
    }

    public String translateToText(String morse){
        String[] morseArray = morse.split(" ");

        StringBuilder morseString = new StringBuilder();

        for (String morsePart : morseArray) {
            morseString.append(textToMorseMapping.get(morsePart));
        }
        return String.valueOf(morseString);
    }
}
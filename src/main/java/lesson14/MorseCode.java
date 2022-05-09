package lesson14;

import java.util.*;

public class MorseCode {
    private final Map<Character,String> ALPHABET = new HashMap<>();
    private final char[] english = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    private final String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    {{
        for (int i = 0; i <= english.length - 1; i++) {
            ALPHABET.put(english[i], morse[i]);
        }
    }};

    public int uniqueMorseRepresentations(String[] words) {
        String[] wordsMorse = new String[words.length];
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            char[] wordsChar = words[i].toCharArray();
            for (int j = 0; j < wordsChar.length; j++) {
                if(wordsMorse[i] == null){
                    wordsMorse[i] = ALPHABET.get(wordsChar[j]);
                } else {
                    wordsMorse[i] += ALPHABET.get(wordsChar[j]);
                }
            }
        }
        unique.addAll(Arrays.asList(wordsMorse));

        return unique.size();
    }
}

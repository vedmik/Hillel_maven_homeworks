package Lesson23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.function.BiFunction;

public class Pattern {

    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();

        String[] sArr=s.split(" ");
        char[] patternArr = pattern.toCharArray();

        if(sArr.length != pattern.length()) return false;

        for(int i = 0; i < patternArr.length; i++) {

            if(map.containsKey(patternArr[i])) {
                if(!map.get(patternArr[i]).equals(sArr[i])){
                    return false;
                }
            } else {
                map.put(patternArr[i], sArr[i]);
            }
        }

        return true;
    }
}

package lesson20;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private final Map<Character,Integer> ROMAN = new HashMap<>();

    {
        ROMAN.put('I',1);
        ROMAN.put('V',5);
        ROMAN.put('X',10);
        ROMAN.put('L',50);
        ROMAN.put('C',100);
        ROMAN.put('D',500);
        ROMAN.put('M',1000);

    }

    public int romanToInt(String s) {
        char[] arrRoman = s.toCharArray();
        int sum = 0;

        for (int i = arrRoman.length - 1; i >= 0 ; i--) {
            if(i == arrRoman.length - 1){
                sum += ROMAN.get(arrRoman[i]);
            } else {
                if(ROMAN.get(arrRoman[i]) >= ROMAN.get(arrRoman[i + 1])){
                    sum += ROMAN.get(arrRoman[i]);
                } else {
                    sum -= ROMAN.get(arrRoman[i]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}

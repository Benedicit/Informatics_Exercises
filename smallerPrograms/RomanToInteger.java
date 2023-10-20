package smallerPrograms;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        Map<Character, Integer> roman = Map.of(
                'I',1,
                'V',5,
                'X',10,
                'L',50,
                'C',100,
                'D',500,
                'M',1000);
        int sum = 0;
        String romanNumber = "LXX";
        char[] allCharacters = romanNumber.toCharArray();
        for (int i =0; i<allCharacters.length; i++) {
            if (i>=1 && roman.get(allCharacters[i]) > roman.get(allCharacters[i-1])) {
                sum = sum + roman.get(allCharacters[i]) - roman.get(allCharacters[i-1]) * 2;
            }
            else {
                sum = sum + roman.get(allCharacters[i]);
            }
        }
        System.out.println(sum);


    }

}

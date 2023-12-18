package smallerPrograms;

import java.util.Arrays;

public class SplitStrings {
    public static void main(String[] args) {
        String test = "12 34 56 78 ";
        String[] splitted = test.split(" ");
        for (String s: splitted) {
            System.out.println(s);
        }
        System.out.println(Long.parseLong("2497466808"));
       // System.out.println(Arrays.toString(splitted));
    }
}

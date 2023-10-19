package smallerPrograms;

public class SumOfDigits {
    public static void main(String[] args) {
        int n = 35;
        int m = sum(n);
        System.out.println(m);
    }
    public static int sum(int eins) {
        int summe = 0;
        while (eins != 0) {
            summe += eins % 10;
            eins /= 10;
        }
        return summe;
    }
}

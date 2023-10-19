package smallerPrograms;

public class RecursiveMethodes {
    public static void main(String[] args) {
        int z = factorial(4);
        System.out.println(z);
        System.out.println(sum(7));
        System.out.println(fibonacci(10));
        System.out.println(isPalindrome("lagerregal"));
        System.out.println(reverseString("Hello World"));
        System.out.println(greatestCommonDivisor(6,12));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public static int fibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);

        if (firstChar != lastChar) {
            return false;
        }

        String remainingSubstring = str.substring(1, str.length() - 1);
        return isPalindrome(remainingSubstring);
    }
    public static String reverseString(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    public static int greatestCommonDivisor(int x, int y) {
        if (y==0) {
            return x;
        }
        int remainder = x % y;
        return greatestCommonDivisor(y,remainder);
    }
}

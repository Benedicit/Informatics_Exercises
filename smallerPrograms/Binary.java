package smallerPrograms;

public class Binary {
    public static void main(String[] args) {
        int x = 42;
        System.out.println(bin(x));
    }
    public static String bin(int i) {
        String y="";
        while (i!=0){

            if (i%2 == 1) {
                y = y + '0';
            }
            else {
                y = y + '1';
            }
            i = i / 2;

        }
        return y;
    }
}

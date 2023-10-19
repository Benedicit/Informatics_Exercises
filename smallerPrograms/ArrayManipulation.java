package smallerPrograms;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {

        int[] org = {20, 35, 40};
        int[] arr = oneToTheLeft(org);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = swapFirstAndLast(org);
        System.out.println(Arrays.toString(arr2));
    }
    public static int[] oneToTheLeft(int[] y) {
        int[] newArr = new int[3];
        for (int i = 0; i<y.length; i++) {
            if (i<2){
                newArr[i] = y[i+1];
            } else {
                newArr[i] = y[0];
            }
        }
        return y;
    }
    public static int[] swapFirstAndLast(int[] y) {
        int[] temp = new int[y.length];
        temp[0] = y[y.length-1];
        for (int i=1; i<y.length-1; i++) {
            temp[i] = y[i];
        }
        temp[y.length-1] = y[0];
        return temp;
    }



}
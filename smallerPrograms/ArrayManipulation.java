package smallerPrograms;

import java.util.Arrays;

public class ArrayManipulation {
    public static void main(String[] args) {

        int[] org = {20, 35, 40,5};
        int[][] test = {{1,4,7},{2,5,8},{3,6}};
        int[][] test2 = {{}};
        //int[] arr = oneToTheLeft(org);
        //System.out.println(Arrays.toString(arr));
        //int[] arr2 = swapFirstAndLast(org);
        //System.out.println(Arrays.toString(arr2));
        rotate(org,0);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(zipMany(test)));

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
    public static void rotate (int[] array, int amount) {
        if (amount % array.length == 0 || (amount *-1) % array.length == 0) {
            return;
        }
        int[] result = new int[array.length];

        if(amount<0) {
            amount *= -1;
            amount %= array.length;
            amount = array.length-amount;
        } else {
            amount %= array.length;
        }
        for (int i = 0; i < result.length; i++) {
                //for (int i = 1; i < array.length - 1; i++) {
            if(i+amount<result.length) {
                result[amount+i] = array[i];
            } else {
                result[-array.length+i+amount] = array[i];
            }
        }
        System.arraycopy(result,0,array,0,array.length);

    }
    public static int[] zipMany(int[][] arrays) {
        int totalLength =0;

        //get the total length
        for(int[] array : arrays) {
            totalLength += array.length;
        }
        int[] result = new int[totalLength];

        //An array to store which element in the subarrays we are
        int[] array = new int[arrays.length];

        int i=0;
        int row =0;
        while(i<totalLength) {
            if(row % arrays.length ==0) {
                row = 0;
            }
            if (array[row] < arrays[row].length) {
                result[i] = arrays[row][array[row]];
                array[row] += 1;
                i++;
            }
            row++;

        }
     return result;
    }





}
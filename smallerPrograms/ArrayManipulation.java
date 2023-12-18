package smallerPrograms;

import java.util.Arrays;
import java.util.Map;

public class ArrayManipulation {
    public static void main(String[] args) {

        int[] org = {2, 5, 4,5,3,3,-1,0};
        int[][] test = {{1,4,7},{2,5,8},{3,6}};
        int[][] test2 = {{}};
        //int[] arr = oneToTheLeft(org);
        //System.out.println(Arrays.toString(arr));
        //int[] arr2 = swapFirstAndLast(org);
        //System.out.println(Arrays.toString(arr2));
        rotate(org,0);
        System.out.println(Arrays.toString(org));
        System.out.println(Arrays.toString(zipMany(test)));
        System.out.println(Arrays.toString(multiplyOddsAndEvens(org)));
        oddsBeforeEvens(org);
        System.out.println(Arrays.toString(org));


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
        return newArr;
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
        if (array.length ==0 || amount % array.length == 0 || (amount *-1) % array.length == 0) {
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
    public static int[] multiplyElements (int[] x, int[] y) {
        //x and y have the same length
        int[] result = new int[x.length];
        for (int i=0; i<x.length; i++) {
            result[i] = x[i] * y[i];
        }
        return result;

    }

    /**
     * A function to calculate the result of all odds and all evens in an array multiplied. Negatives are filtered out
     * @param x
     * @return
     */
    public static int[] multiplyOddsAndEvens (int[] x) {
        int[] result = new int[2];
        int odds =1;
        int evens =1;
        int oddsCount =0;
        int evensCount=0;
        if (x.length==0) {
            return new int[2];
        }
        for (int i=0; i<x.length; i++) {
            if(x[i]<=0) {
                continue;
            } else if (x[i] %2 ==0) {
                evens *= x[i];
                evensCount++;
            } else {
                odds *= x[i];
                oddsCount++;
            }
        }
        if(oddsCount>0) {
            result[1] = odds;
        }
        if (evensCount>0) {
            result[0] = evens;
        }

        return result;
    }
    public static void oddsBeforeEvens (int [] array) {
        int[] result = new int[array.length];
        int[] odds = new int[array.length];
        int[] evens = new int[array.length];
        int oddCount =0;
        int evenCount =0;
        if (array.length==0) {
            return;
        }
        for (Integer ints : array) {
            if (ints %2 ==0) {
                evens[evenCount++] = ints;
                //evenCount++;
            } else {
                odds[oddCount++] = ints;
            }
        }
        //array = new int[oddCount+evenCount];
        int index =0;
        for(int i=0; i<oddCount; i++) {
            array[i] = odds[i];
            index++;
        }
        for (int i=0; i<evenCount; i++) {
            array[index++] = evens[i];
        }
    }












}
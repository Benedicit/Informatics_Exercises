package smallerPrograms;

public class Combinatorics {
    public static void main(String[] args) {
        System.out.println(sterlingNumberType2(9,4));
        System.out.println(partitionFunction(8,4));
    }

    /**
     * Calculates the sterling number type 2 without memoization
     * @param n objects
     * @param k classes
     * @return how many partitions exist
     */
    public static long sterlingNumberType2 (long n, long k) {
        if (n>0 && k == 0) {
            return 0;
        } else if (n==k) {
            return 1;
        } else {
            return sterlingNumberType2(n-1,k-1) + k * sterlingNumberType2(n-1,k);
        }
    }

    /**
     * calculates how many different partitions of n objects in k classes but both of them aren't differentiable
     * @param n objects
     * @param k classes
     * @return how many partitions exists
     */
    public static long partitionFunction (long n, long k) {
        if(n > 0 && k == 0) {
            return 0;
        } else if (k > n) {
            return 0;
        } else if (k == n) {
            return 1;
        } else {
            return partitionFunction(n-1,k-1) + partitionFunction(n-k,k);
        }
    }
}

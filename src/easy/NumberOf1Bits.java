package easy;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }

        int count = 1;
        while ((n & (n - 1)) != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}

package easy;

public class FactorialTrailingZeroes {
    //O(logn)
    //二分
    //末尾产生0----2,5---4,5---10  同时有%2和%5为0的数
    //遍历O(n)
    //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
    public int trailingZeroes(int n) {
        int solution = 0;
        while(n / 5 != 0) {
            n /= 5;
            solution += n;
        }
        return solution;
    }

    //jiuzhang solution
    public int trailingZeroes1(int n) {
        // write your code here
        return  n < 5 ? 0 :trailingZeroes(n/5) + n/5;
    }

}

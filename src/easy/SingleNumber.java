package easy;

public class SingleNumber {


    //XOR 异或操作消除重复 = =
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int num: nums) {
            a ^= num;
        }
        return a;
    }

    //也可以用set，2∗(a+b+c)−(a+a+b+b+c)=c
}

package easy;

//递归超时了。。。。
public class ClimbingStairs {
    public static int climbStairs(int n){
        if(n == 1 || n == 0) return 1;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }
    public static int climbStairs1(int n){
        if(n == 0 || n == 1) return 1;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        for(int i = 2; i < n; i++){
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1] + a[n - 2];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(44));
    }
}

package easy;
//  考虑溢出。。。。。
public class Sqrtx {
	public static int mySqrt(int x){
	    if(x == 0 || x == 1) return x;
	    return mySqrt(x, 0, x);
    }

    public static int mySqrt(int x, int lo, int hi){
	    if(lo == (hi - 1)) return lo;
	    int mid = lo + (hi - lo) / 2;
	    long y = (long) mid * mid;
	    if(y <= x) return mySqrt(x, mid, hi);
	    else if (y > x) return mySqrt(x, lo, mid);

	    return 0;
    }

    public static void main(String args[]){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
	    System.out.println(mySqrt(8));
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(9));
        System.out.println(mySqrt(2147395599));
    }

}

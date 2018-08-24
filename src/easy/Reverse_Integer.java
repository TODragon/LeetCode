package easy;

public class Reverse_Integer {
//	solution
	public static int reverse(int x) {
		int solution = 0;
		int temp = 0;
		while(x != 0) { //可以写为while（x）
			solution = temp * 10 + x % 10;
//			检测int溢出！
			if(solution / 10 != temp) {
				return 0;
			}
			temp = solution;
//			x = (x - x % 10) / 10;
			x /= 10; //直接除十，与上一行相同！
		}
		return solution;
	}
//	test
	public static void main(String[] args) {
		int test = 1534236469;
		int x = -120;
		System.out.println(reverse(test));
		System.out.println(reverse(x));
	}
}
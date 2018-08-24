package easy;

public class Palindrome_Number {
//	solution
	public static boolean isPalindrome(int x) {
		
//		String str = String.valueOf(x);
		String str = x + ""; //可直接变为String
		StringBuilder s = new StringBuilder(str);
		s.reverse();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != s.charAt(i)) {
				return false;
			}
		}
		return true;
	}
//	test
	public static void main(String[] args) {
		System.out.println(isPalindrome(-121));
		System.out.println(isPalindrome(121));
	}
}

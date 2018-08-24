package easy;

public class LongestCommonPrefix {
//	solution: Runtime error
	public static String longestCommonPrefix1(String[] strs) {
		String solution = new String();
		if(strs == null || strs.length == 0) {
			solution = "";
			return solution;
		}
		char[][] dic = new char[strs.length][10];
		for(int i = 0; i < strs.length; i++) {
			for(int j = 0; j < strs[i].length(); j++) {
				dic[i][j] = strs[i].toCharArray()[j];
			}
		}
		for(int j = 0; j < 10; j++) {
			boolean indic = true;
			for(int i = 0; i < strs.length; i++) {
				if(dic[i][j] != dic[0][j]) {
					indic = false;
					break;
				}
			}
			if(indic) {
				solution = solution + dic[0][j];
			}
			
		}
		return solution.trim();
	}
//  solution 按列读取各个str相同部分，需要注意溢出，数组边界以及返回为空！！
	public static String longestCommonPrefix(String[] strs) {
		String solution = new String();
		int n = 0;
		
		if(strs == null || strs.length == 0) {
			return solution;
		}
		for(int j = 0; j < strs[0].length(); j++) {
			int m = 0;
			for(int i = 0; i < strs.length; i++) {
				if(j < strs[i].length() && strs[i].charAt(j) == strs[0].charAt(j)) {
					m++;
				}
			}
			if(m != strs.length) {
				break;
			}
			else {
				n++;
			}
		}
		solution = strs[0].substring(0, n);
		return solution;
	}
//	JiuZhang 各个str与第一个求prefix后输出
	public static String longestCommonPrefix2(String[] strs) {
	     if (strs == null || strs.length == 0) {
	    	 return "";
	    	 }
	     String prefix = strs[0];
	     for(int i = 1; i < strs.length; i++) {
	         int j = 0;
	         while( j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
	            j++;
	         }
             if( j == 0) {
            	 return "";
	        }
	         prefix = prefix.substring(0, j);
	      }
	      return prefix;
}
	
//	test
	public static void main(String[] args) {
		String[] strs1 = {"flower","flow","flight"};
		String[] strs2 = {"aaa","aa", "aa"};
		System.out.println(longestCommonPrefix(strs1));
		System.out.println(longestCommonPrefix(strs2));
	}
}

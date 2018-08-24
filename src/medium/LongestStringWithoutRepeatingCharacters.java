package medium;

import java.util.HashSet;

public class LongestStringWithoutRepeatingCharacters {
	//直接暴力
	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
		int max = 1;
		for(int i = 0; i < s.length(); i++) {
			int size = 1;
			for(int j = i + 1; j < s.length(); j++) {
				int k = i;
				while(k < j) {
					if(s.charAt(k) == s.charAt(j)) break;
					k++;
				}
				if(k == j) {
					size ++;
					max = (size > max)? size: max;
				}
				else break;
			}
		}
		return max;
	}
	
	//jiuzhang solution
    //方法一：利用char对应的int占位
	public int lengthOfLongestSubstring1(String s) {
		int[] map = new int[256]; // map from character's ASCII to its last occured index
	       
		int j = 0;
		int i = 0;
		int ans = 0;
		for (i = 0; i < s.length(); i++) {
			while (j < s.length() && map[s.charAt(j)]==0) {
				map[s.charAt(j)] = 1;
				ans = Math.max(ans, j-i + 1);
				j ++;
			}
			map[s.charAt(i)] = 0;
		}    
		return ans;
	}
	
    public int lengthOfLongestSubstring2(String s) {
        if ( (s.length() == 0) ||(s.length() ==1) ) {
            return s.length();
        }
        int max = -1;
        int start = 0;
        for(int i = 1; i < s.length(); i++) {
            for(int k = start; k < i; k++) {
                if(s.charAt(k) == s.charAt(i)) {
                    start = k + 1;
                }
            }
            max = Math.max(max, i- start + 1);
        }
        return max;
    }
	
    //HashSet 集合
    public int lengthOfLongestSubstring3(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashSet<Character> hset = new HashSet<>();
        while(right < s.length()){
            if (!hset.contains(s.charAt(right))){
                hset.add(s.charAt(right));
                res = Math.max(res, hset.size());
                right++;
            }
            else{
                hset.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
		String a = "abcabcbb";
		String b = "bbbbb";
		String c = "pwwkew";
		String d = "abcdefghijk";
		System.out.println(lengthOfLongestSubstring(a));
		System.out.println(lengthOfLongestSubstring(b));
		System.out.println(lengthOfLongestSubstring(c));
		System.out.println(lengthOfLongestSubstring(d));
	}
}

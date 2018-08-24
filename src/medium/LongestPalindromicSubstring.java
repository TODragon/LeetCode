package medium;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int max = 1;
        int mid = 0;
        if(s.length() == 0) return s;
        for(int i = 0; i < s.length(); i++) {
            //even
            if(i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i)) {
                int k = i, j = i + 1, len = 1;
                while(--k >= 0 && ++j < s.length()) {
                    if(s.charAt(j) != s.charAt(k)) break;
                    else len++;
                }
                mid = ((2 * len) > max)? i: mid;
                max = ((2 * len) > max)? (2 * len): max;
            }
            //odd
            if(i >= 1 && i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i - 1)) {
                int k = i, j = i, len = 0;
                while (--k >= 0 && ++j < s.length()) {
                    if(s.charAt(j) != s.charAt(k)) break;
                    else len++;
                }
                mid = ((2 * len + 1) > max)? i: mid;
                max = ((2 * len + 1) > max)? (2 * len + 1): max;
            }
        }
        System.out.print(max);
        System.out.println(mid);
        String str = new String();
        str = (max % 2 == 0)? s.substring(mid - max / 2 + 1, mid + max / 2 + 1): s.substring(mid - max / 2, mid + max / 2 + 1);

        return str;
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //jiuzhang solution
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // abc => #a#b#c#
        String str = generateString(s);

        int[] palindrome = new int[str.length()];
        int mid = 0, longest = 1;
        palindrome[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            int len = 1;
            if (mid + longest > i) {
                int mirrorOfI = mid - (i - mid);
                len = Math.min(palindrome[mirrorOfI], mid + longest - i);
            }

            while (i + len < str.length() && i - len >= 0) {
                if (str.charAt(i - len) != str.charAt(i + len)) {
                    break;
                }
                len++;
            }

            if (len > longest) {
                longest = len;
                mid = i;
            }

            palindrome[i] = len;
        }

        longest = longest - 1; // remove the extra #
        int start = (mid - 1) / 2 - (longest - 1) / 2;
        return s.substring(start, start + longest);
    }

    private String generateString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append('#');

        return sb.toString();
    }


    public static void main(String args[]) {
        String a = "babad";
        String b = "aaaaa";
        String c = "baab";
        System.out.println(longestPalindrome(a));
        System.out.println(longestPalindrome(b));
        System.out.println(longestPalindrome(c));
    }
}

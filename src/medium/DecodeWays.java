package medium;

public class DecodeWays {
    //一个数可以分为多种码
    //最多两位，第一位1,第二位0～9。。第一位2,第二位0~6
    //递归
//    public int numDecodings(String s) {
//        if(s.length() == 0) return 1;
//
//        return
//    }
//
//    private int numDecodings(String s, int lo) {
//        if(s.charAt(lo) - '0' > 2) {return numDecodings(s, lo + 1);}
//        else if(s.charAt(lo) - '0' == 1) {return numDecodings(s, lo + 1) + numDecodings(s, lo + 2);}
//        else if(s.charAt(lo) - '0' == 2) {
//            if(s.charAt(lo + 1) - '0' > 6) {return numDecodings(s, lo + 1);}
//            else return numDecodings(s, lo + 1) + numDecodings(s, lo + 2);
//        }
//    }

    //使用memo, 自底向上
    public static int numDecodingsMemo1(String s) {
        if(s == null || s.length() == 0) return 0;
        int cur = 1;
        int next = 1;
        if(s.charAt(0) == '0') return 0;
        for(int i = s.length() - 1; i > 0; i--) {
//            if(s.charAt(i) == '0' && s.charAt(i - 1) != '0') continue;
//            else if(s.charAt(i) == '0' && s.charAt(i - 1) == '0') return 0;

            int decode = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');
            if(decode <= 26 && decode >= 10) {
                int temp = cur;
                cur = cur + next;
                next = temp;
            }
            else if(decode < 10) {
                cur = next;
                next = 0;
            }
            else {
                next = cur;
            }
        }

        return cur;
    }



    //jiuzhang solution
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }

            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];
    }

    public int numDecodings2(String s) {
        // Write your code here
        int l = s.length();
        if (l == 0) {
            return 0;   // only for this problem, but the ans should be 1
        }
        int[] f = new int[l + 1];
        f[0] = 1;
        char sc[] = s.toCharArray();

        for (int i = 1; i <= l; i++) {
            if (sc[i - 1] != '0') {
                f[i] += f[i - 1];
            }
            if (i >= 2) {
                int val2 = (sc[i - 2] - '0') * 10 + sc[i - 1] - '0';
                if (10 <= val2 && val2 <= 26) {
                    f[i] += f[i - 2];
                }
            }
        }
        return f[l];
    }

    char[] s = null;
    int[] f = null;
    int n;

    void calc(int i) {
        if (f[i] != -1) {
            return;
        }

        if (i == 0) {
            f[i] = 1;
            return;
        }

        int t = s[i - 1] - '0';
        f[i] = 0;
        calc(i - 1);

        if (t >= 1 && t <= 9) {
            f[i] += f[i - 1];
        }

        if (i > 1) {
            calc(i - 2);
            t = (s[i - 2] - '0') * 10 + s[i - 1] - '0';
            if (t >= 10 && t <= 26) {
                f[i] += f[i - 2];
            }
        }
    }

    public int numDecodings3(String ss) {
        s = ss.toCharArray();
        n = s.length;
        if (n == 0) {
            return 0;
        }

        f = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            f[i] = -1;
        }

        calc(n);
        return f[n];
    }

    public int numDecodings4(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];

        return memo[0];
    }
}

package medium;

public class MultiplyStrings {
    //乘法算式
    //solution
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return "";
        if(num1.equals("0") || num2.equals("0")) return "0";

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int m = c1.length;
        int n = c2.length;
        int[] res = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                res[m + n - i - j - 2] += (c1[i] - '0') * (c2[j] - '0');
                res[m + n - i - j - 1] += res[m + n - i - j - 2] / 10;
                res[m + n - i - j - 2] %= 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        for(int i = m + n - 1; i >= 0; i--) {
            if(res[i] != 0) {
                for(int j = i; j >= 0; j--) { ans.append(res[j]); }
                return ans.toString();
            }
        }

        return "0";
    }
}

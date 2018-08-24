package easy;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        char[] str = s.toCharArray();
        int n = 0;
        for(int i = str.length - 1; i >= 0; i--) {
            n += (int) (1 + str[i] - 'A') * Math.pow(26, str.length - 1 - i);
        }
        return n;
    }

    public static void main(String args[]) {
        String s = "ZY";
        System.out.print(titleToNumber(s));
    }
}

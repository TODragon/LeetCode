package medium;

public class String2Integer {
    //还是有问题。。。。。。。。见九章solution
    public static int myAtoi(String str) {
        if(str.length() == 0) return 0;
        long solution = 0;
        int time = 1;
        int i = 0;
        String s = "1234567890";
        while (i < str.length() && (str.charAt(i) == ' ' || str.charAt(i) == '0')) i++;
        if(i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            time = (str.charAt(i) == '-')? -1: 1;
            i++;
        }
        int j = i;
        while (i < str.length() && str.charAt(i) == '0') i++;
        j = i;
        while (i < str.length() && s.contains(str.charAt(i) + "")) i++;
        s = str.substring(j, i);
        if((i - j) > 10) return ((time == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE);
        solution = (i > j)? Long.parseLong(s): 0;
        solution = time * solution;
        return (solution < Integer.MAX_VALUE && solution > Integer.MIN_VALUE)? (int) solution: ((time == 1)? Integer.MAX_VALUE: Integer.MIN_VALUE);
    }

    //jiuzhang solution
    public int myAtoi1(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9')
                break;
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE ) {
                break;
            }
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }

    public static void main(String args[]) {
        String a = "-";
        String b = "+1";
        String c = "-000000000000001";
        String d = "words and 987";
        String e = "-91283472332";
        System.out.println(myAtoi(a));
        System.out.println(myAtoi(b));
        System.out.println(myAtoi(c));
        System.out.println(myAtoi(d));
        System.out.println(myAtoi(e));
    }
}

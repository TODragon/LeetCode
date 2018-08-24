package medium;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows >= s.length() || numRows == 1 || s.length() == 0) return s;

        String str = "";
        //i为第i行，j为原字符串的index
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); ) {
                if(i == 0 || i == numRows - 1) {
                    str += s.charAt(j);
                    j += 2 * (numRows - 1);
                }
                else {
                    str += s.charAt(j);
                    if((j += 2 * (numRows - 1 - i)) < s.length()) str += s.charAt(j);
                    j += 2 * i;
                }
            }
        }

        return str;
    }


    //jiuzhang solution
    public String convert1(String s, int nRows) {
        int length = s.length();
        if (length <= nRows || nRows == 1) return s;
        char[] chars = new char[length];
        int step = 2 * (nRows - 1);
        int count = 0;
        for (int i = 0; i < nRows; i++){
            int interval = step - 2 * i;
            for (int j = i; j < length; j += step){
                chars[count] = s.charAt(j);
                count++;
                if (interval < step && interval > 0
                        && j + interval < length && count <  length){
                    chars[count] = s.charAt(j + interval);
                    count++;
                }
            }
        }
        return new String(chars);
    }

    public String convert2(String s, int numRows) {
        StringBuilder sb = new StringBuilder("");
        if(numRows == 1) return s;
        int cyclelen = 2 * numRows -2;
        int n = s.length();
        for(int i=0;i<numRows;i++)
        {
            for(int j=0; j+i < n; j+=cyclelen)
            {
                sb.append(s.charAt(j+i));
                if(i !=0 && i != numRows-1 && j+cyclelen-i < n)
                    sb.append(s.charAt(j+ cyclelen - i));
            }
        }
        return sb.toString();

    }
    public static void main(String args[]) {
        String s = "PAYPALISHIRING";
        String a = "";
        System.out.println(convert(s, 3));
        System.out.println(convert(s, 100));
        System.out.println(convert(a, 5));
    }
}

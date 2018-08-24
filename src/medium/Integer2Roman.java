package medium;

import java.util.Scanner;

public class Integer2Roman {
    public static String intToRoman(int num) {
        String str = "";
        String roman[] = {"I", "V", "X", "L", "C", "D", "M"};
        //个,5,十,5,百,5,千

        for(int i = 3; i >=0; i--) {
            int n = num / (int) Math.pow(10, i);
            num -= (int) Math.pow(10, i) * n;

            if(n > 0 && n < 4) {
                while (n-- > 0) str += roman[2 * i];
            }
            else if(n == 4) str += roman[2 * i] + roman[1 + 2 * i];
            else if(n == 5) str += roman[1 + 2 * i];
            else if(n > 5 && n < 9) {
                str += roman[1 + 2 * i];
                while (n-- > 5) str += roman[2 * i];
            }
            else if(n == 9) str += roman[2 * i] + roman[2 + 2 * i];
        }

        return str;
    }

    //jiuzhang solution
    public String intToRoman1(int n) {
        // Write your code here
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[n / 1000] + C[(n / 100) % 10] + X[(n / 10) % 10] + I[n % 10];
    }

    public static void main(String args[]) {

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(intToRoman(sc.nextInt()));
        }

    }
}

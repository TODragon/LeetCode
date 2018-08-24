package easy;

import java.util.Scanner;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String str = new String();
        while (n != 0) {
            char letter;
            if(n % 26 != 0) {
                letter = (char) ('A' + n % 26 - 1);
                str = letter + str;
                n = n / 26;
            }
            else if(n / 26 != 0) {
                letter = 'Z';
                str = letter + str;
                n = n / 26 - 1;
            }
        }
        return str;
    }


    public String convertToTitle1(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }



    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.print(convertToTitle(s));
    }
}

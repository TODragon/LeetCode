package easy;

public class AddDigits {
    public static int addDigits(int num) {
        if(num / 10 == 0) return num;

        String s = num + "";
        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            n += a;
        }
        return addDigits(n);
    }


    public int addDigits1(int num) {

        return num==0?0:(num%9==0?9:(num%9));

    }

    public static void main(String args[]) {
        System.out.print(addDigits(5));
    }
}

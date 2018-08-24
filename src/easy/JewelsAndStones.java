package easy;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) return 0;
        int num = 0;
        for(int i = 0; i < J.length();i++) {
            char a = J.charAt(i);
            for(int j = 0; j < S.length(); j++) {
                char b = S.charAt(j);
                if(a == b) num++;
            }
        }



        return num;
    }
}

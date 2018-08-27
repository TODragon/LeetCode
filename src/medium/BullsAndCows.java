package medium;

import java.util.ArrayList;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] num = new int[10];
        int bull = 0;
        int cow = 0;


        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                if (num[secret.charAt(i)-'0']++ < 0) cow++;
                if (num[guess.charAt(i)-'0']-- > 0) cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}

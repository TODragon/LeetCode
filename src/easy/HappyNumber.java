package easy;

import java.util.ArrayList;
import java.util.HashSet;

public class HappyNumber {
    //递归
    public boolean isHappy(int n) {
        HashSet<Integer> hash = new HashSet<>();

        while (n != 1) {
            if(hash.contains(n)) return false;
            hash.add(n);
            n = getHappy(n);
        }

        return true;
    }
    public int getHappy(int n) {
        String s = n + "";
        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            num += Math.pow(s.charAt(i) - '0', 2);
        }
        return num;
    }

}
//7.49.1681.97.8149.130.10.1

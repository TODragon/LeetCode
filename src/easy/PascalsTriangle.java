package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> solution = new ArrayList<>();
        if(numRows == 0) return solution;

        List<Integer> temp = null;
        for(int i = 0; i <= numRows; i++) {
            List<Integer> sub = new ArrayList<>();
            if(i == 0) {
                sub.add(1);
                continue;
            }

            for(int j = 0; j < i; j++) {
                if(j == 0) sub.add(1);
                else if(j < i - 1){
                    sub.add(temp.get(j - 1) + temp.get(j));
                }
                else sub.add(1);
                System.out.print(sub.get(j));
            }
            System.out.println("");

            temp = sub;
            solution.add(sub);
        }
        return solution;
    }

    public static void main(String args[]) {
        generate(5);
    }
}

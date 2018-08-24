package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    //从大到小替换，常数空间复杂度
    public List<Integer> getRow(int rowIndex) {
        List<Integer> solution = new ArrayList<>();
        if(rowIndex == 0) return solution;
        //i row, j col
        solution.add(1);
        for(int i = 0; i <= rowIndex + 1; i++) {

            for(int j = i - 1; j > 0; j--) {
                if(j == i - 1) solution.add(1);
                else solution.set(j, solution.get(j) + solution.get(j - 1));
            }
        }
        return solution;
    }
}

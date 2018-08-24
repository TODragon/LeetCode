package medium;

import java.util.List;

public class Triangle {
    //不占用额外space，直接在该位置记录min
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);

        for(int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> temp = triangle.get(row);
            List<Integer> next = triangle.get(row + 1);
            for(int col = 0; col < temp.size(); col++) {
                temp.set(col, temp.get(col) + Math.min(next.get(col), next.get(col + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}

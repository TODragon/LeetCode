package medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    //     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> res = new ArrayList<>();
//         if(n == 0) return res;
//         dfs(n, k, res, new ArrayList<>(), n);
//         return res;
//     }

//     private void dfs(int n, int k, List res, ArrayList sub, int hi) {
//         if(k == 0) res.add(new ArrayList(sub));
//         else {
//             for(int i = n; i > 0; i--) {
//                 if(sub.contains(i) || i > hi) continue;
//                 sub.add(i);
//                 dfs(n, k - 1, res, sub, i);
//                 sub.remove(sub.size() - 1);
//             }
//         }
//     }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0) return res;
        dfs(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(int n, int k, List res, ArrayList sub, int lo) {
        if(k == 0) res.add(new ArrayList(sub));
        else {
            for(int i = 1; i <= n; i++) {
                if(sub.contains(i) || i < lo) continue;
                sub.add(i);
                dfs(n, k - 1, res, sub, i);
                sub.remove(sub.size() - 1);
            }
        }
    }
}

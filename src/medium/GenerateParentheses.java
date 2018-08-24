package medium;

import java.util.List;
import java.util.ArrayList;

public class GenerateParentheses {
//    public List<String> generateParenthesis(int n) {
//        List<String> solution = new ArrayList<>();
//
//
//
//
//    }






    //jiuzhang solution
    public ArrayList<String> generateParenthesis1(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public void helper(ArrayList<String> result,
                       String paren, // current paren
                       int left,     // how many left paren we need to add
                       int right) {  // how many right paren we need to add
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            helper(result, paren + "(", left - 1, right);
        }

        if (right > 0 && left < right) {
            helper(result, paren + ")", left, right - 1);
        }
    }




    //
    List<String> res = new ArrayList<>();
    int n;

    void gen(int nleft, int nright, String cur) {
        if (nleft == n && nright == n) {
            res.add(cur);
            return;
        }

        if (nleft < n) {
            gen(nleft + 1, nright, cur + "(");
        }

        if (nright < nleft) {
            gen(nleft, nright + 1, cur + ")");
        }
    }

    public List<String> generateParenthesis2(int nn) {
        n = nn;
        gen(0, 0, "");
        return res;
    }
}

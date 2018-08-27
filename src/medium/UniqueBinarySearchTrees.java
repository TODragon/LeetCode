package medium;

public class UniqueBinarySearchTrees {

    //recursive
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }







    /*
    The case for 3 elements example
    Count[3] = Count[0]*Count[2]  (1 as root)
                  + Count[1]*Count[1]  (2 as root)
                  + Count[2]*Count[0]  (3 as root)

    Therefore, we can get the equation:
    Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
    F(i, n) = G(i-1) * G(n-i)
    */
    //jiuzhang solution
    public int numTrees1(int n) {
        int[] count = new int[n + 2];
        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}

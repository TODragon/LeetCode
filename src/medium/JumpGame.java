package medium;

public class JumpGame {

//    Solution
//    This is a dynamic programming[1] question. Usually, solving and fully understanding a dynamic programming problem is a 4 step process:
//
//    Start with the recursive backtracking solution
//    Optimize by using a memoization table (top-down[3] dynamic programming)
//    Remove the need for recursion (bottom-up dynamic programming)
//    Apply final tricks to reduce the time / memory complexity
//    All solutions presented below produce the correct result, but they differ in run time and memory requirements.



    //能否绕过0, 如果绕不过就false
    public static boolean canJump(int[] nums) {
        if(nums != null && nums.length == 1 && nums[0] == 0) return true;
        if(nums == null || nums.length == 0 || nums[0] == 0) return false;


        for(int i = nums[nums.length - 1] == 0? (nums.length - 2): (nums.length - 1); i > 0; i--) {
            if(nums[i] != 0) continue;
            int j = i - 1;
            while (j >= 0) {
                if(nums[j] > (i - j)) {
                    i = j;
                    break;
                }
                j--;
            }
            if(j == -1) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        int[] a = {0};
        System.out.print(canJump(a));
    }




    //solution

//    Approach 1: Backtracking
//    This is the inefficient solution where we try every single jump pattern that takes us from the first position to the last.
//    We start from the first position and jump to every index that is reachable. We repeat the process until last index is reached.
//    When stuck, backtrack.
    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump1(int[] nums) {
        return canJumpFromPosition(0, nums);
    }


    //Approach 2: Dynamic Programming Top-down
    //Top-down Dynamic Programming can be thought of as optimized backtracking. It relies on the observation that once we determine that a certain index is good / bad, this result will never change. This means that we can store the result and not need to recompute it every time.
    //
    //Therefore, for each position in the array, we remember whether the index is good or bad. Let's call this array memo and let its values be either one of: GOOD, BAD, UNKNOWN. This technique is called memoization[2].
//    enum Index {
//        GOOD, BAD, UNKNOWN
//    }
//
//    public class Solution {
//        Index[] memo;
//
//        public boolean canJumpFromPosition(int position, int[] nums) {
//            if (memo[position] != Index.UNKNOWN) {
//                return memo[position] == Index.GOOD ? true : false;
//            }
//
//            int furthestJump = Math.min(position + nums[position], nums.length - 1);
//            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
//                if (canJumpFromPosition(nextPosition, nums)) {
//                    memo[position] = Index.GOOD;
//                    return true;
//                }
//            }
//
//            memo[position] = Index.BAD;
//            return false;
//        }
//
//        public boolean canJump(int[] nums) {
//            memo = new Index[nums.length];
//            for (int i = 0; i < memo.length; i++) {
//                memo[i] = Index.UNKNOWN;
//            }
//            memo[memo.length - 1] = Index.GOOD;
//            return canJumpFromPosition(0, nums);
//        }
//    }




    //Approach 3: Dynamic Programming Bottom-up
    //Top-down to bottom-up conversion is done by eliminating recursion. In practice, this achieves better performance as we no longer have the method stack overhead and might even benefit from some caching. More importantly, this step opens up possibilities for future optimization. The recursion is usually eliminated by trying to reverse the order of the steps from the top-down approach.
    //
    //The observation to make here is that we only ever jump to the right. This means that if we start from the right of the array, every time we will query a position to our right, that position has already be determined as being GOOD or BAD. This means we don't need to recurse anymore, as we will always hit the memo table.

//    enum Index {
//        GOOD, BAD, UNKNOWN
//    }
//
//    public class Solution {
//        public boolean canJump(int[] nums) {
//            Index[] memo = new Index[nums.length];
//            for (int i = 0; i < memo.length; i++) {
//                memo[i] = Index.UNKNOWN;
//            }
//            memo[memo.length - 1] = Index.GOOD;
//
//            for (int i = nums.length - 2; i >= 0; i--) {
//                int furthestJump = Math.min(i + nums[i], nums.length - 1);
//                for (int j = i + 1; j <= furthestJump; j++) {
//                    if (memo[j] == Index.GOOD) {
//                        memo[i] = Index.GOOD;
//                        break;
//                    }
//                }
//            }
//
//            return memo[0] == Index.GOOD;
//        }
//    }


    //Approach 4: Greedy
    //Once we have our code in the bottom-up state, we can make one final, important observation. From a given position, when we try to see if we can jump to a GOOD position, we only ever use one - the first one (see the break statement). In other words, the left-most one. If we keep track of this left-most GOOD position as a separate variable, we can avoid searching for it in the array. Not only that, but we can stop using the array altogether.
//
//    public class Solution {
//        public boolean canJump(int[] nums) {
//            int lastPos = nums.length - 1;
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (i + nums[i] >= lastPos) {
//                    lastPos = i;
//                }
//            }
//            return lastPos == 0;
//        }
//    }
}

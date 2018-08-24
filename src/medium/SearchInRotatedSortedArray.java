package medium;

public class SearchInRotatedSortedArray {
    //两个子数组，分别sorted，以末尾为边界拆分，可以先和末尾比较，找出属于哪个子组，再二分,二分时添加上mid和length-1的比较即可
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(target == nums[nums.length - 1]) return nums.length - 1;
        return search(nums, target, 0, nums.length - 1, nums[nums.length - 1]);
    }

    public static int search(int[] nums, int target, int lo, int hi, int flag) {
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(target == nums[mid]) return mid;
        else if((target > nums[mid] && flag < nums[mid]) || (target < flag && target > nums[mid] && flag > nums[mid]) || (target < flag && target < nums[mid] && flag < nums[mid])) return search(nums, target, mid + 1, hi, flag);
//        else if((target < nums[mid] && flag > nums[mid]) || (target > flag && target < nums[mid] && flag < nums[mid]) || (target > flag && target > nums[mid] && flag > nums[mid])) return search(nums, target, lo, mid - 1, flag);
        else return search(nums, target, lo, mid - 1, flag);
    }


    //jiuzhang solution
    public int search1(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] n = {4,5,6,7,0,1,2};
        System.out.println(search(n, 3));
        System.out.println(search(n, 5));
        System.out.println(search(n, 6));
        System.out.println(search(n, 7));
        System.out.println(search(n, 1));
        System.out.println(search(n, 2));
        System.out.println(search(n, 9));

    }
}

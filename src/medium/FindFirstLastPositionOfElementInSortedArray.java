package medium;

public class FindFirstLastPositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {

        int[] solution = {-1, -1};
        if(nums.length == 0) return solution;
        solution[0] = searchFirst(nums, target, 0, nums.length - 1);
        solution[1] = searchLast(nums, target, 0, nums.length - 1);
        return solution;
    }

    //last
    public static int searchLast(int[] nums, int target, int lo, int hi) {
        if(lo >= hi && nums[lo] == target) return lo;
        else if(lo >= hi && nums[lo] != target && lo >= 1 && nums[lo - 1] == target) return lo - 1;
        else if(lo >= hi && nums[lo] != target) return -1;
        int mid = lo + (hi - lo) / 2;

        if(nums[mid] == target) return searchLast(nums, target, mid + 1, hi);
        else if(nums[mid] > target) return searchLast(nums, target, lo, mid - 1);
        else if(nums[mid] <= target) return searchLast(nums, target, mid + 1, hi);
        return -1;
    }

    //first
    public static int searchFirst(int[] nums, int target, int lo, int hi) {
        if(lo >= hi && nums[lo] == target) return lo;
        else if(lo >= hi && nums[lo] != target && lo <= nums.length - 2 && nums[lo + 1] == target) return lo + 1;
        else if(lo >= hi && nums[lo] != target) return -1;

        int mid = lo + (hi - lo) / 2;

        if(nums[mid] == target) return searchFirst(nums, target, lo, mid - 1);
        else if(nums[mid] > target) return searchFirst(nums, target, lo, mid - 1);
        else if(nums[mid] <= target) return searchFirst(nums, target, mid + 1, hi);
        return -1;
    }

    //faster solution
    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1,-1};
        if(nums.length==0) {return result;}
        int i=0, j=nums.length-1;
        // Left Biased
        while(i<j){
            int m = (i+j)/2;
            if(nums[m]<target){ i = m+1;}
            else{j = m;}
        }
        if(nums[i]!=target){return result;}
        else{result[0]=i;}

        j = nums.length-1;
        //Right Biased
        while(i<j){
            int m = (i+j)/2 + 1;
            if(nums[m]>target){j = m-1;}
            else{i = m;}
        }
        result[1] = i;
        return result;
    }


    public static void main(String args[]) {
        int[] a = {1,2,3};

        System.out.println(searchRange(a, 2)[0] + "       " + searchRange(a, 2)[1]);
//        System.out.println(searchRange(a, 6)[0] + "       " + searchRange(a, 6)[1]);
//        System.out.println(searchRange(a, 5)[0] + "       " + searchRange(a, 5)[1]);
//        System.out.println(searchRange(a, 10)[0] + "       " + searchRange(a, 10)[1]);
    }
}

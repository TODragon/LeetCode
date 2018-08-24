package easy;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> a = new ArrayList<>();
        if(nums.length <= 1) return nums.length;
        int temp = nums[0];
        a.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != temp){
                a.add(nums[i]);
                temp = nums[i];
            }
        }
        for(int i = 0; i < a.size(); i++) nums[i] = a.get(i);
        return a.size();
    }
//  jiuzhang solution
    public int removeDuplicates1(int[] A) {
        if (A == null || A.length == 0) return 0;
        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }
}

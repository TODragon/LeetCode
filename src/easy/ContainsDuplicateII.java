package easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    //brute force
//    public boolean conatinsNearbyDuplicate(int[] nums, int k) {
//
//    }


    //discuss
    //wow, sliding window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}

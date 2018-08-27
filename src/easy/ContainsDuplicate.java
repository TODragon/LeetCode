package easy;

import java.util.HashSet;

public class ContainsDuplicate {
    //数组问题先排序！！！
    public boolean containsDuplicates(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i: nums) {
            if(hash.contains(i)) return true;
            else hash.add(i);
        }
        return false;
    }
}

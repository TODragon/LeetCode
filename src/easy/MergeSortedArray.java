package easy;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if(nums1[i] <= nums2[j]) { temp[k++] = nums1[i++]; }
            else { temp[k++] = nums2[j++]; }
        }
        if(i < m) { while (i < m) {temp[k++] = nums1[i++]; } }
        if(j < n) { while (j < n) { temp[k++] = nums2[j++]; } }

        for(int c = 0; c < k; c++) {nums1[c] = temp[c]; }
    }

    //jiuzhang solution 从大到小排
    public void mergeSortedArray1(int[] A, int m, int[] B, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
    public static void main(String args[]) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for(int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}

package medium;

public class ContainerWithMostWater {

    //n^2 不好
    public static int maxArea(int[] height) {
        int h = 0;
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            int far = 0;
            for(int j = 0; j < height.length; j++) {
                if(height[j] >= height[i]) {
                    int distance = Math.abs(j - i);
                    far = (distance > far)? distance: far;
                }
            }
            h = height[i];
            System.out.print(h+"   ");
            System.out.print(far+"   ");
            max = ((h * far) > max)? (h * far): max;
            System.out.println(max+"   ");
        }

        return max;
    }



    //jiuzhang solution
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    int computeArea(int left, int right,  int[] heights) {
        return (right-left)*Math.min(heights[left], heights[right]);
    }

    public int maxArea1(int[] heights) {
        // write your code here
        int left = 0, ans=  0 ;
        int right = heights.length - 1;
        while(left <= right) {
            ans = Math.max(ans,computeArea(left, right, heights));
            if(heights[left]<=heights[right])
                left++;
            else
                right--;
        }
        return ans;
    }

    // for any i, the maxium area will be the farthest j that has a[j] > a[i];
    //这个方法好 n
    public int maxArea2(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length -1;
        while(left < right) {
            max = Math.max( max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;

    }

    public int maxArea3(int[] A) {
        int len = A.length;
        int l = 0;
        int r = len -1;
        int area = 0;

        while (l < r)
        {
            // Calculating the max area
            area = Math.max(area, Math.min(A[l], A[r]) * (r - l));
            if (A[l] < A[r]) l += 1;
            else r -= 1;
        }
        return area;
    }

    public static void main(String args[]) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] a = {1,2};
        System.out.println(maxArea(a));
    }
}

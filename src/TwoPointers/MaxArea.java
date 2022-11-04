package TwoPointers;

/*
      Time Complexity: O(n)
      Space: O(1)
 */
public class MaxArea {
    public static int maxArea(int[] height) {
        int maxArea =0;
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int min = Math.min(height[left], height[right]);
            int area = min * (right-left);
            maxArea = Math.max(maxArea,area);

            if(height[left]>height[right]){
                right --;
            }
            else {
                left++;
            }
        }
        return maxArea;
    }
}

package BinarySearch;

public class MyBinarySearch {

    // Time Complexity: O(logn)
    // Space: O(1)
    public static int myBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    // Time Complexity: O(mlogn)
    // Space: O(1)
    public static boolean searchMatrixlogMLogNSolution(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int r =row/2;
        int c = col-1;
        // First figure out which row to search
        while(r<row && r>=0){
            if(target < matrix[r][c] && target > matrix[r][0]){
                break;
            }
            else if(target > matrix[r][c]){
                r++;
            }
            else if(target<matrix[r][0]){
                r--;
            }
            else {
                break;
            }
        }

        int mid = c/2;
        while(mid<=col && mid >=0){
            if(target== matrix[r][mid]) return true;

            else if(target > matrix[r][mid]){
                mid++;
            }
            else if(target < matrix[r][mid]){
                mid--;
            }
            else {
                break;
            }
        }

        return false;
    }

    // Time Complexity: O(logn)
    // Space: O(1)
    public boolean searchMatrixLognSolution(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;
        // Binary Search
        while (r < row && c >= 0) {
            int current = matrix[r][c];
            if (current == target) {
                return true;
            }
            if (current > target) {
                c--;
            }
            else {
                r++;
            }
        }
        return false;
    }


    public int firstBadVersion(int n) {
        int l = 1;
        int r =n;
        int res = 0;
        if (n==1 && isBadVersion(n)) return 1;

        while(l<=r){
            int m = l + (r-l)/2;
            if(isBadVersion(m)){
                res=m;
                r= m-1;
            }
            else {
                l= m+1;
            }
        }

        return res;
    }

    private boolean isBadVersion(int n) {
        return n >= 4;
    }


}

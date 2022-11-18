package TwoPointers;

/*
    167. Two Sum II - Input Array Is Sorted
    Time Complexity: O(n)
    Space: O(N)
 */
public class TwoSum2 {
    public static int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int [] res = new int[2];
        int r = numbers.length -1;

        if(numbers.length==2){
            res[0]=1;
            res[1]=2;
            return res;
        }

        while(l<r){
            if(numbers[l] + numbers[r] > target){
                r--;
            }
            else if(numbers[l]+ numbers[r]<target){
                l++;
            }
            else {
                res[0]= l+1;
                res[1] = r+1;
                break;
            }
        }
        return res;
    }
}

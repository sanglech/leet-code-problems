package ArraysWithHashing.Medium;

/*
    978. Longest Turbulent Subarray
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        if( arr.length ==0) return 0;
        int res=0, curr =0;

        for(int i=0;i< arr.length;i++){
            if(i >= 2 && ((arr[i-2] > arr[i-1] && arr[i-1] < arr[i]) ||
                    (arr[i-2] < arr[i-1] && arr[i-1] > arr[i])) ){
                // If the last three elements are turbulent, increment run length by 1.
                curr++;
            }
            else if(i >= 1 && arr[i]!=arr[i-1]){
                // The last three elements are not turbulent, so we'll reset the run length.
                // And If the previous and current elements are not equal, the new run length is 2.
                curr =2;
            }
            else {
                // Otherwise, the new run length is 1.
                curr =1;
            }

            res = Math.max(res,curr);
        }


        return res;
    }
}

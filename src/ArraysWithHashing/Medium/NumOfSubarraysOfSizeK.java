package ArraysWithHashing.Medium;

/*
    1343. Number of Sub-arrays of Size K
    and Average Greater than or Equal to Threshold
 */
public class NumOfSubarraysOfSizeK {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int res =0;
        if (arr.length==0) return 0;

        int l=0;
        int windowSize = Math.min(k,arr.length);

        for (int r =windowSize; r<= arr.length;r++){
            int avg =0;
            for(int i =l;i<r;i++){
                avg+=arr[i];
            }
            avg = avg/k;
            l++;
            if(avg >= threshold){
                res++;
            }
        }
        return res;
    }
}

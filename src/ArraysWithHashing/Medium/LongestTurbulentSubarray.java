package ArraysWithHashing.Medium;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        if( arr.length ==0) return 0;
        int res =0;

        boolean positive = false;

        for(int i=0; i< arr.length-1;i++){
            int val = arr[i+1]-arr[i];
            if(val > 0){
                if(!positive){
                    res++;
                    positive=true;
                }
            }
            else if(val<0){
                if(positive){
                    res++;
                    positive =false;
                }
            }
        }
        return res;
    }
}

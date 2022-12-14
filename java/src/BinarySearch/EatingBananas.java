package BinarySearch;

/*
    875. Koko Eating Bananas
 */
public class EatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int right=0;
        int left=1;

        for(int pile: piles){
            right = Math.max(right,pile);
        }

        int res = right;
        while(left<right){
            int mid = (right + left) /2;
            int timeToEat =0;
            for(int pile: piles){
                timeToEat += Math.ceil((1.0*pile)/mid);
            }
            if(timeToEat<=h)
            {
                res = Math.min(res,mid);
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return res;
    }
}

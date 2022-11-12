package SlidingWindow;

/*
    1423. Maximum Points You Can Obtain from Cards
 */
public class CardPoints {
    public int maxScore(int[] cardPoints, int k) {
        int l =0, r= cardPoints.length-k;
        int res =0;
        int maxSum=0;

        for(int i =r;i<cardPoints.length;i++){
            maxSum+=cardPoints[i];
        }
        res = Math.max(maxSum,res);

        while(r<cardPoints.length){
            maxSum+=cardPoints[l];
            maxSum-=cardPoints[r];
            res = Math.max(maxSum,res);

            l++;
            r++;
        }


        return res;
    }
}

package BinarySearch;

/*
    374. Guess Number Higher or Lower
 */
public class GuessGame {
        public int guessNumber(int n) {
            int left = 1;
            int right =n;

            while(left<=right){
                int mid = left+ (right-left)/2;
                int myGuess = guess(mid);
                if(myGuess==1){
                    left= mid+1;
                }
                else if(myGuess==-1){
                    right = mid -1;
                }
                else {
                    return mid;
                }
            }

            return -1;
        }

    public int guess( int num){
        return 1;
    }
}

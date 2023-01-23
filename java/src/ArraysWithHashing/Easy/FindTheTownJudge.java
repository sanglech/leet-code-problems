package ArraysWithHashing.Easy;

/*
    997. Find the Town Judge
 */
public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if(n==1 && trust.length == 0) return 1;
        int [] count = new int[n+1];
        for (int[] ints : trust) {
            count[ints[0]]--;
            count[ints[1]]++;
        }
        for(int i = 0;i<count.length;i++){
            if(count[i] ==n-1)  return i;
        }

        return -1;
    }
}

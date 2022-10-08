package DynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int val1 = 1;
        int val2 = 2;

        for(int i=3; i<=n;i++){
            int newVal = val1 + val2;
            val1=val2;
            val2=newVal;
        }

        return val2;
    }
}

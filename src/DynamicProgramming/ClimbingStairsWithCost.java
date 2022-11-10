package DynamicProgramming;

/*
    746. Min Cost Climbing Stairs
 */
public class ClimbingStairsWithCost {
    public static int minCostClimbingStairs(int[] cost) {

        int val2;
            for(int i = cost.length-2;i>=0;i--){
                if(i+2==cost.length){
                    val2=0;
                } else{
                    val2= cost[i+2];
                }
                cost[i] += Math.min(cost[i+1],val2);
            }

            return Math.min(cost[0],cost[1]);

        }
}

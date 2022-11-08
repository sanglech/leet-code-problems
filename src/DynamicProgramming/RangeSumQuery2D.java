package DynamicProgramming;

/*
    304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2D {
    int[][] sumMatrix;
    public void rangeSumQuery2D(int[][] matrix) {
        this.sumMatrix= new int[matrix.length][matrix[0].length];

        for( int i =0; i<matrix.length;i++){
            for(int j =0; j< matrix[0].length;j++){
                if(j==0){
                    sumMatrix[i][j]= matrix[i][j];
                }
                else {
                    sumMatrix[i][j]=sumMatrix[i][j-1] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2){
        if(col1<0 || row1<0 || row2> this.sumMatrix.length || col2> this.sumMatrix[0].length){
            return -1;
        }
        int sum =0;
        for(int i=row1;i<row2;i++){
            sum+= sumMatrix[i][col2] - (col1 > 0 ? sumMatrix[i][col1 - 1] : 0);
        }
        return sum;
    }

}

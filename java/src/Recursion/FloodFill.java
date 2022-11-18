package Recursion;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;

        fill(image,sr,sc,image[sr][sc],color);
        return image;
    }

    public void fill(int [][] image, int sr, int sc, int orgColour, int newColour){
        if(sr<0 || sc < 0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=orgColour) return;

        image[sr][sc] = newColour;
        fill(image,sr-1,sc,orgColour,newColour);
        fill(image,sr+1,sc,orgColour,newColour);
        fill(image,sr,sc-1,orgColour,newColour);
        fill(image,sr,sc+1,orgColour,newColour);
    }
}

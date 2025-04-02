class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        int[][] cache= new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length ; i++){
            for(int j =0; j < matrix[i].length; j++){
                res=Math.max(res,dfs(i,j,matrix,cache));
                
            }
        }
        
        return res;
    }

    public int dfs(int i,int j,int[][] matrix, int[][] cache){
        // int left = i-1;
        // int right = i+1;
        // int up=j-1;
        // int bottom=j+1;
        // if(i < 0 || i > matrix.length-1 || j < 0 || j > matrix[0].length-1) return 0;

        if(cache[i][j]!=0){
            return cache[i][j];
        }

        int numberOfPath=1;
        if(i > 0 && matrix[i-1][j] > matrix[i][j]){
            numberOfPath = Math.max(numberOfPath,1+dfs(i-1,j,matrix,cache));
        }
        if(i < matrix.length-1 && matrix[i+1][j] > matrix[i][j]){
            numberOfPath = Math.max(numberOfPath,1+dfs(i+1,j,matrix,cache));
        }
        if(j > 0 && matrix[i][j-1] > matrix[i][j]){
            numberOfPath = Math.max(numberOfPath,1+dfs(i,j-1,matrix,cache));
        }
        if(j < matrix[0].length-1 && matrix[i][j+1] > matrix[i][j]){
            numberOfPath = Math.max(numberOfPath,1+dfs(i,j+1,matrix,cache));
        }

        cache[i][j] =  numberOfPath;

        return numberOfPath;
    }
}
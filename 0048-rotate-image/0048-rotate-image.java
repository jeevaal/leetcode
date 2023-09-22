class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < i; j++)
                swap(i, j, j, i, matrix);
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n / 2; j++)
                swap(i, j, i, n - j - 1, matrix);
                
    }
    
    void swap(int i, int j, int x, int y, int matrix[][])
    {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}
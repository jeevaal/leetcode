class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if( mat.length * mat[0].length != r * c )
            return mat;
        int res[][] = new int[r][c];
        int x = 0, y = 0;
        for( int i = 0; i < mat.length; i++ )
        {
            for( int j = 0; j < mat[i].length; j++ )
            {
                res[x][y] = mat[i][j];
                y++;
                if( y == c )
                {
                    x++;
                    y = 0;
                } 
            }
        }
        return res;
    }
}
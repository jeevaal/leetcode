class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, column = n;
        for( int i = 0; i < ops.length; i++ )
        {
            if( row > ops[i][0] )
                row = ops[i][0];
            if( column > ops[i][1] )
                column = ops[i][1];
        }
        return row * column;
    }
}
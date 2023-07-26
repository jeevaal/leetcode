class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int visited[][] = new int[row][col];
        int count = 0;
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] == 0)
                {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    class Pair
    {
        int row;
        int col;
        
        Pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    
    public void bfs(int row, int col, char[][] grid, int visited[][])
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        
        while(!q.isEmpty())
        {
            row = q.peek().row;
            col = q.peek().col;
            q.remove();
            // 4 directions
            int neighbourRow[] = {-1, 0, 0, 1}; // we can use two for loops instead of two arrays also.
            int neighbourCol[] = {0, -1, 1, 0};
            
            for(int i = 0; i < 4; i++)
            {
                int nRow = row + neighbourRow[i];
                int nCol = col + neighbourCol[i];
                
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0)
                {
                    q.add(new Pair(nRow, nCol));
                    visited[nRow][nCol] = 1;
                }
            }
        }
    }
}
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
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countFresh = 0;
        
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new Pair(i, j));
                else if(grid[i][j] != 0)
                    countFresh++;
            }
        }
        
        if(countFresh == 0)
            return 0;
        int count = 0, t = 0;
        count -= q.size();
        while(!q.isEmpty())
        {
            int size = q.size();
            count += size;
            for(int k = 0; k < size; k++)
            {
                int drow[] = {0, 0, -1, 1};
                int dcol[] = {-1, 1, 0, 0};
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();
                for(int i = 0; i < 4; i++)
                {
                    int nrow = row + drow[i];
                    int ncol = col + dcol[i];

                    if(nrow < 0 || ncol < 0 || nrow >= m || ncol >= n || grid[nrow][ncol] != 1)
                        continue;

                    grid[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol));
                }
            }
            if(!q.isEmpty())
                t++;
        }
        
        return (countFresh == count) ? t : -1;
    }
}
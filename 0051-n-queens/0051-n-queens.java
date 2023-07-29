class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        String chess[][] = new String[n][n];
        for(String row[] : chess)
            Arrays.fill(row, ".");
        placeQueen(0, n, chess, res);
        return res;
    }
    
    public void placeQueen(int col, int n, String chess[][], List<List<String>> al)
    {
        // base case
        if(col == n)
        {
            String temp = "";
            List<String> l = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                temp = "";
                for(int j = 0; j < n; j++)
                {
                    temp += chess[i][j];
                }
                l.add(temp);
            }
            al.add(l); 
            return;
        }
        
        for(int row = 0; row < n; row++)
        {
            if(isSafe(row, col, n, chess))
            {
                chess[row][col] = "Q";
                placeQueen(col + 1, n, chess, al);
                chess[row][col] = ".";
            }
        }
    }
    
    public boolean isSafe(int row, int col, int n, String chess[][])
    {
        // need to check only in 3 directions
        
        int row1 = row, col1 = col;
        while(row1 >= 0 && col1 >= 0)
        {
            if((chess[row1][col1]).equals("Q"))
                return false;
            row1--;
            col1--;
        }
        
        row1 = row;
        col1 = col;
        while(col1 >= 0)
        {
            if((chess[row1][col1]).equals("Q"))
                return false;
            col1--;
        }
        
        row1 = row;
        col1 = col;
        while(row1 < n && col1 >= 0)
        {
            if((chess[row1][col1]).equals("Q"))
                return false;
            row1++;
            col1--;
        }
        
        return true;
        
    }
}
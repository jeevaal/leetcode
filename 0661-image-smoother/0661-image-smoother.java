class Solution {
    public int[][] imageSmoother(int[][] img) {
        int count = 0, sum = 0;
        int res[][] = new int[img.length][img[0].length];
        for( int i = 0; i < img.length; i++ )
        {
            for( int j = 0; j < img[i].length; j++ )
            {
                count = 0;
                sum = 0;
                sum += img[i][j];
                count++;
                if( j > 0 )
                {
                    sum += img[i][j - 1];
                    count++;
                }
                if( j < img[i].length - 1)
                {
                    sum += img[i][j + 1];
                    count++;
                }
                if( i > 0 )
                {
                    sum += img[i - 1][j];
                    count++;
                    if( j > 0 )
                    {
                        sum += img[i - 1][j - 1];
                        count++;
                    }
                    if( j < img[i].length - 1)
                    {
                        sum += img[i - 1][j + 1];
                        count++;
                    }
                }
                if( i < img.length - 1)
                {
                    sum += img[i + 1][j];
                    count++;
                    if( j > 0 )
                    {
                        sum += img[i + 1][j - 1];
                        count++;
                    }
                    if( j < img[i].length - 1)
                    {
                        sum += img[i + 1][j + 1];
                        count++;
                    }
                }
                res[i][j] = sum / count;   
            }
        }
        return res;
    }
}
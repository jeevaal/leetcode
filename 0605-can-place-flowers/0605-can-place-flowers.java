class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if( n == 0 )
            return true;
        if( flowerbed.length == 1 )
            if( flowerbed[0] == 0 )
                return true;
            else
                return false;
        int count = 0;
        for( int i = 0; i < flowerbed.length; i++ )
        {
            if( i == 0 )
            {
                if( flowerbed[i] == 0 && flowerbed[i + 1] == 0 )
                {
                    flowerbed[i] = 1;
                    count++;
                }
                    
                if( count == n )
                    return true;
            }
            else if( i == flowerbed.length - 1 )
            {
                if( flowerbed[i] == 0 && flowerbed[i - 1] == 0 )
                {
                    flowerbed[i] = 1;
                    count++;
                }
                if( count == n )
                    return true;
            }
            else
            {
                if( flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 )
                {
                    flowerbed[i] = 1;
                    count++;
                }
                    
                if( count == n )
                    return true;
            }
        }
        return false;
    }
}
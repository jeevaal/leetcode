class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lCount = 0;
        int maxLCount = 0;
        for( int i = 0; i < s.length(); i++ )
        {
            char c = s.charAt(i);
            if ( c == 'L' )
                lCount++;
            else
            {
                if( c == 'A' )
                    aCount++;
                if( maxLCount < lCount )
                    maxLCount = lCount;
                lCount = 0;       
            }
            if( i == s.length() - 1 )
            {
                if( maxLCount < lCount )
                    maxLCount = lCount;
                lCount = 0;
            }
            if( aCount >= 2 || maxLCount >= 3 )
                return false;
        }
        return true;
    }
}
class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0, lr = 0;
        for( char c : moves.toCharArray() )
        {
            if( c == 'U' )
                ud++;
            else if( c == 'D' )
                ud--;
            else if( c == 'R' )
                lr++;
            else
                lr--;
        }
        if( ud == 0  && lr == 0 )
            return true;
        return false;
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        if( word.length() == 1)
            return true;
        
        boolean flag1 = true, flag2 = true, flag3 = true;

        // case 1
        for( int i = 0; i < word.length(); i++ )
        {
            if( !Character.isUpperCase( word.charAt(i) ) )
            {
                flag1 = false;
                break;
            }
        }
        if(flag1)
            return true;

        //case2
        for( int i = 0; i < word.length(); i++ )
        {
            if( !Character.isLowerCase( word.charAt(i) ) )
            {
                flag2 = false;
                break;
            }
        }
        if(flag2)
            return true;  
        
        //case3
        if( !Character.isUpperCase( word.charAt(0) ) )
            flag3 = false;
        if(flag3)
        {
            for( int i = 1; i < word.length(); i++ )
            {
                if( !Character.isLowerCase( word.charAt(i) ) )
                {
                    flag3 = false;
                    break;
                }
            }
        }
        if(flag3)
            return true;
        
        return false;
    }
}
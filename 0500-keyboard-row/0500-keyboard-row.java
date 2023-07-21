class Solution {
    public String[] findWords(String[] words) {
        List< Character > row1 = new ArrayList< Character >();
        row1.add('q');
        row1.add('w');
        row1.add('e');
        row1.add('r');
        row1.add('t');
        row1.add('y');
        row1.add('u');
        row1.add('i');
        row1.add('o');
        row1.add('p');
        List< Character > row2 = new ArrayList< Character >();
        row2.add('a');
        row2.add('s');
        row2.add('d');
        row2.add('f');
        row2.add('g');
        row2.add('h');
        row2.add('j');
        row2.add('k');
        row2.add('l');
        List< Character > row3 = new ArrayList< Character >();
        row3.add('z');
        row3.add('x');
        row3.add('c');
        row3.add('v');
        row3.add('b');
        row3.add('n');
        row3.add('m');
        List< String > res = new ArrayList<>();
        for( int i = 0; i < words.length; i++ )
        {
            String str = words[i].toLowerCase();
            char c[] = str.toCharArray();
            List< Character > temp = new ArrayList<>();
            for( char t : c )
                temp.add( t );
            if( row1.containsAll( temp ) )
                res.add( words[i] );
            else if( row2.containsAll( temp ) )
                res.add( words[i] );
            else if( row3.containsAll( temp ) )
                res.add( words[i] );
        }
        String arr[] = res.toArray( new String[0] );
        return arr;
    }
}
class Solution {
    public int calPoints(String[] operations) {
        List< Integer > al = new ArrayList<>();
        for( String s : operations )
        {
            if( s.equals("C") )
                al.remove(al.size() - 1);
            else if( s.equals("D") )
                al.add( al.get(al.size() - 1) * 2 );
            else if( s.equals("+") )
                al.add( al.get(al.size() - 1) + al.get(al.size() - 2) );
            else
                al.add(Integer.valueOf(s));
        }
        int sum = 0;
        for( int i : al )
            sum += i;
        return sum;
    }
}
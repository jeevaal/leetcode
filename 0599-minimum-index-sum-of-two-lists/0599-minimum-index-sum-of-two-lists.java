class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList< String > al = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE, counter = 0;
        for( int i = 0; i < list1.length; i++ )
        {
            for( int j = 0; j < list2.length; j++ )
            {
                if( list1[i].equals(list2[j]) )
                {
                    int index = i + j;
                    if( index < minIndex )
                    {
                        al.clear();
                        al.add(list1[i]);
                        minIndex = index;
                    }
                    else if( index == minIndex )
                        al.add(list1[i]);
                }
            }
        }
        String res[] = new String[al.size()];
        for( String s : al )
            res[counter++] = s;
        
        return res;
    }
}
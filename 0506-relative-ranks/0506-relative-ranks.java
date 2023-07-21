import java.util.*;
class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap< Integer, String > tm = new TreeMap<>();
        for( int i = 0; i < score.length; i++ )
            tm.put(score[i], "0");
        NavigableMap< Integer, String > nm = tm.descendingMap();
        int count = 1;
        String arr[] = new String[score.length]; 
        for( Map.Entry< Integer, String > entry : nm.entrySet() )
        {
            if( count == 1 )
                nm.replace(entry.getKey(), "Gold Medal");
            else if( count == 2 )
                nm.replace(entry.getKey(), "Silver Medal");
            else if( count == 3 )
                nm.replace(entry.getKey(), "Bronze Medal");
            else
                nm.replace(entry.getKey(), String.valueOf(count));
            count++;
        }
        for( int i = 0; i < score.length; i++ )
            arr[i] = nm.get(score[i]);
        return arr;
    }
}
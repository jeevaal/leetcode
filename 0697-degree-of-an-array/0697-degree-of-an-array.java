class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxCount = 0, min = 0;
        HashMap< Integer, Integer > hm = new HashMap<>();
        List< Integer > al = new ArrayList<>();
        for( int e : nums )
        {
            al.add(e);
            hm.put(e, hm.getOrDefault(e, 0) + 1);
        }
        for( Map.Entry< Integer, Integer > entry : hm.entrySet() )
        {
            int count = entry.getValue();
            if( count > maxCount )
            {
                maxCount = count;
                min = al.lastIndexOf(entry.getKey()) - al.indexOf(entry.getKey()) + 1;
            }
            else if( count == maxCount )
            {
                min = Math.min(min, al.lastIndexOf(entry.getKey()) - al.indexOf(entry.getKey()) + 1);
            }
        }

        return min;
    }
}
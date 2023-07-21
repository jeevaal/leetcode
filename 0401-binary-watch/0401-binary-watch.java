class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> l = new ArrayList<>();
        if(turnedOn>8)
            return l;
        for(int i=0; i<12; i++)
        {
            for(int j=0; j<60; j++)
            {
                if(Integer.bitCount(i)+Integer.bitCount(j) == turnedOn)
                {
                    if(j<10)
                        l.add(String.format("%d:0%d",i,j));
                    else
                        l.add(String.format("%d:%d",i,j));
                }
            }
        }
        return l;
    }
}
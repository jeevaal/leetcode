class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);

        if(rowIndex==0)
            return l2;

        l1.add(l2);
        for(int i=1;;i++)
        {
            List<Integer> l3 = new ArrayList<>();
            for(int j=0;j<i+1;j++)
            {
                if(j==0)
                    l3.add(l1.get(i-1).get(0));
                else if(j==i)
                    l3.add(l1.get(i-1).get(i-1));
                else
                    l3.add(l1.get(i-1).get(j-1)+l1.get(i-1).get(j));
                    
            }
            if(i==rowIndex)
                return l3;
            l1.add(l3);
        }
    }
}
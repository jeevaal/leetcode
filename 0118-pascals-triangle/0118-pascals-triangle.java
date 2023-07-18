class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l1.add(l2);
        for(int i = 1; i < numRows; i++)
        {
            List<Integer> l3 = new ArrayList<>();
            l3.add(1);
            for(int j = 1; j < i ; j++)
               l3.add(l1.get(i - 1).get(j - 1) + l1.get(i - 1).get(j)) ;
            l3.add(1);
            l1.add(l3);
        }
        return l1;
    }
}
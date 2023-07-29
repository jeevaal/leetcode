class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> l = new ArrayList<>();
        for(int i =1; i < n; i++)
        {
            fact = fact * i;
            l.add(i);
        }
        l.add(n);
        String res = "";
        k--;
        while(true)
        {
            res += l.get(k / fact);
            l.remove(k / fact);
            
            if(l.size() == 0)
                break;
            
            k = k % fact;
            fact = fact / l.size();
        }
        return res;
    }
}
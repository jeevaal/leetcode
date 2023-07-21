class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length == 0)
            return 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while(i < g.length && j < s.length)
        {
            if(s[j] >= g[i])
            {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int n1[], int n2[])
            {
                if(n1[0] != n2[0])
                    return n1[0] - n2[0];
                return n1[1] - n2[1];
            }
        });
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] <= end)
            {
                if(intervals[i][1] > end)
                    end = intervals[i][1];
            }
            else
            {
                List<Integer> l = new ArrayList<>();
                l.add(start);
                l.add(end);
                list.add(l);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> l = new ArrayList<>();
        l.add(start);
        l.add(end);
        list.add(l);
        int res[][] = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++)
        {
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
            
        return res;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char c : tasks)
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.addAll(hm.values());
        
        int result = 0;
        while(!pq.isEmpty())
        {
            int time = 0;
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n + 1; i++)
            {
                if(!pq.isEmpty())
                {
                    temp.add(pq.poll() - 1);
                    time++;
                }
            }
            
            for(int ele : temp)
                if(ele > 0)
                    pq.add(ele);
            
            result += pq.isEmpty() ? time : n+1;
        }
        
        return result;
    }
}
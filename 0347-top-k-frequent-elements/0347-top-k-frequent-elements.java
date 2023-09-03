class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int e : nums)
            hm.put(e, hm.getOrDefault(e, 0) + 1);
        
        // to sort a hashmap need to convert it to list then use comparator, then again store it in new hashmap
        // otherwise we can use priority queue
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> entry : hm.entrySet())
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        
        int res[] = new int[k];
        int index = 0;
        while(k > 0)
        {
            res[index++] = pq.poll().getKey();
            k--;
        }
        return res;
    }
}
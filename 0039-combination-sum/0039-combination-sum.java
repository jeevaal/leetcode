class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, target, candidates, new ArrayList<>(), res);
        return res;
    }
    
    public void findCombinations(int index, int target, int candidates[], List<Integer> l, List<List<Integer>> al)
    {
        //base case
        if(index == candidates.length)
        {
            if(target == 0)
            {
                al.add(new ArrayList<>(l));
            }
            return;
        }
        
        //pick
        if(candidates[index] <= target)
        {
            l.add(candidates[index]);
            findCombinations(index, target - candidates[index], candidates, l, al);
            l.remove(l.size() - 1);
        }
        
        //not pick
        findCombinations(index + 1, target, candidates, l, al);
            
    }
}
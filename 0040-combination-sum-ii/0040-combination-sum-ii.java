class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res  =new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, target, candidates, new ArrayList<>(), res);
        return res;
    }
    
    public void findCombinations(int index, int target, int candidates[], List<Integer> l, List<List<Integer>> al)
    {
        //base case
        if(target == 0)
        {
            al.add(new ArrayList<>(l));
            return;
        }
                
        
           // this below method pick and not pick can be used if there is not repetition of elements in the array candidates, if repeats we may end up with result like 1,1,2  1,2,1
//         //pick
//         l.add(candidates[index]);
//         findCombinations(index + 1, target - candidates[index], candidates, l, al);
//         l.remove(l.size() - 1);
        
//         //not pick
//         findCombinations(index + 1, target, candidates, l, al);
        
        for(int i = index; i < candidates.length; i++)
        {
            if(i != index && candidates[i] == candidates[i - 1])
                continue;
            if(candidates[index] > target)
                break;
            l.add(candidates[i]);
            findCombinations(i + 1, target - candidates[i], candidates, l, al);
            l.remove(l.size() - 1);
            
        }
    }
}
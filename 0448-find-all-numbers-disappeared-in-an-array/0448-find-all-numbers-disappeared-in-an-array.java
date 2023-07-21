class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<Integer>();
        for(int i : nums)
            s.add(i);
        for(int i = 1; i <= nums.length; i++)
        {
            if(!s.contains(i))
                l.add(i);
        }
        return l;
    }
}
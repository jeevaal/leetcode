class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> h1 = new HashMap<>();
        HashMap<Character,Integer> h2 = new HashMap<>();

        for(int i=0;i<ransomNote.length();i++)
        {
            char c1=ransomNote.charAt(i);
            if(h1.containsKey(c1))
                h1.put(c1,h1.get(c1)+1);
            else
                h1.put(c1,1);
        }
        for(int i=0;i<magazine.length();i++)
        {
            char c2=magazine.charAt(i);
            if(h2.containsKey(c2))
                h2.put(c2,h2.get(c2)+1);
            else
                h2.put(c2,1);
        }

        for(Map.Entry<Character,Integer> entry:h1.entrySet())
        {
            char c3=entry.getKey();
            if(!h2.containsKey(c3))
                return false;
            else
                if(entry.getValue()>h2.get(c3))// <= is opposite to >
                    return false;
        }
        return true;
    }
}
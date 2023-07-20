class Solution {
    public boolean wordPattern(String pattern, String s) {
        String arr[] = s.split(" ");
        if(arr.length!=pattern.length())
            return false;
        HashMap<Character,String> hm = new HashMap<>();
        for(int i=0; i<pattern.length(); i++)
        {
            char c = pattern.charAt(i);
            if(hm.containsKey(c))
            {
                if(!hm.get(c).equals(arr[i]))
                    return false;
            }

            if(hm.containsValue(arr[i]))
            {
                char key = getKey(hm,arr[i]);
                if(c != key)
                    return false;
            }

            hm.put(c,arr[i]);
        }
        return true;
    }

    public <K,V> K getKey(HashMap<K,V> hm, V value)
    {
        for(Map.Entry<K,V> entry : hm.entrySet())
        {
            if(value.equals(entry.getValue()))
                return entry.getKey();
        }
        return null;
    }
}
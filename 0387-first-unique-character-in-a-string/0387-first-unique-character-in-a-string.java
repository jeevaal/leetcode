class Solution {
    public int firstUniqChar(String s) {
    // ArrayList<Character> a = new ArrayList<>();
    // ArrayList<Character> a2 = new ArrayList<>();
    // for(int i=0;i<s.length();i++)
    // {
    //     char c=s.charAt(i);
    //     if(a.contains(c)){
    //         a.removeIf(ch->ch==c);
    //         a2.add(c);
    //     }
    //     else if(!a2.contains(c))
    //         a.add(c);
    // }
    // return (a.size()>0)?s.indexOf(a.get(0)):-1;

    HashMap<Character,Integer> l = new HashMap<>();
    for(int i=0;i<s.length();i++)
    {
        if(l.containsKey(s.charAt(i)))
            l.replace(s.charAt(i),l.get(s.charAt(i))+1);
        else
            l.put(s.charAt(i),1);
    }

    for(int i=0;i<s.length();i++)
    {
        if(l.get(s.charAt(i))==1)
            return i;
    }
    return -1;

    }
}
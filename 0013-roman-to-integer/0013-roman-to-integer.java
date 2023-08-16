class Solution {
    public int romanToInt(String s) {
        HashMap<Character ,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        char c1, c2;
        int num = 0, i;
        for(i = 0; i < s.length() - 1; i++)
        {
            c1 = s.charAt(i);
            c2 = s.charAt(i + 1);
            
            if(hm.get(c1) < hm.get(c2))
                num -= hm.get(c1);
            else
                num += hm.get(c1);
        }
        num += hm.get(s.charAt(i));
        return num;
    }
}
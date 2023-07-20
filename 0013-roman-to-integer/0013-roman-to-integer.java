class Solution {
    public int romanToInt(String s) {
        HashMap<String ,Integer> hm = new HashMap<>();
        hm.put("I",1);
        hm.put("V",5);
        hm.put("X",10);
        hm.put("L",50);
        hm.put("C",100);
        hm.put("D",500);
        hm.put("M",1000);

        char c1,c2;
        int num=0,i;
        for(i=0;i<s.length()-1;i++)
        {
            c1=s.charAt(i);
            c2=s.charAt(i+1);
            if(c1=='I' && c2=='V')
                num-=2;
            else if(c1=='I' && c2=='X')
                num-=2;
            else if(c1=='X' && c2=='L')
                num-=20;
            else if(c1=='X' && c2=='C')
                num-=20;
            else if(c1=='C' && c2=='D')
                num-=200;
            else if(c1=='C' && c2=='M')
                num-=200;
            
            num+=hm.get(String.valueOf(c1));
        }
        num+=hm.get(String.valueOf(s.charAt(i)));
        return num;

    }
}
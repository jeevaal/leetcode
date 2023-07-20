class Solution {
    public String reverseVowels(String s) {
        StringBuilder t = new StringBuilder(s);
        int i=0,j=t.length()-1;
        int flag1=0,flag2=0;
        while(i<j)
        {
            char c1 = t.charAt(i);
            char c2 = t.charAt(j);
            if((c1=='A'||c1=='a'||c1=='E'||c1=='e'||c1=='I'||c1=='i'||c1=='O'||c1=='o'||c1=='U'||c1=='u'))
                flag1=1;
            else
                i++;
            
            if((c2=='A'||c2=='a'||c2=='E'||c2=='e'||c2=='I'||c2=='i'||c2=='O'||c2=='o'||c2=='U'||c2=='u'))
                flag2=1;
            else
                j--;

            if(flag1==1 && flag2==1)
            {
                t.setCharAt(i,c2);
                t.setCharAt(j,c1);

                flag1=0;
                flag2=0;
                i++;
                j--;
            }
        }
        return String.valueOf(t);
    }
}
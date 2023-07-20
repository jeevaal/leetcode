class Solution {
    public int addDigits(int num) {
        if(num/10==0)
            return num;
        int sum=0;
        while(true)
        {
            sum=0;
            while(num>0)
            {
                int rem=num%10;
                sum+=rem;
                num/=10;
            }
            if(sum/10==0)
                return sum;
            num=sum;
        }
    }
}
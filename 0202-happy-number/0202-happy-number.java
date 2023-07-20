class Solution {
    public int nextNum(int n)
    {
        int sum=0;
        while(n>0)
        {
            int rem=n%10;
            sum+=Math.pow(rem,2);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        // // happy=1,7
        // //unhappy=2,3,4,5,6,8,9
        // if(n==1 || n==7)
        //     return true;
        // if(n/10==0)
        //     return false;
        // int sum=0;
        // while(true)
        // {
        //     sum=0;
        //     while(n>0)
        //     {
        //         int rem=n%10;
        //         sum+=Math.pow(rem,2);
        //         n/=10;
        //     }
        //     if(sum==1)
        //         return true;
        //     if(sum==1 || sum==7)
        //         return true;
        //     if(sum/10==0)
        //          return false;
        //     n=sum;
        // }
        HashSet<Integer> hm = new HashSet<>();
        while(n!=1 && !hm.contains(n))
        {
            hm.add(n);
            n=nextNum(n);
        }
        return n==1;
    }
}
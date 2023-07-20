class Solution {
    static int[] dp = new int[46];
    public int climbStairs(int n) {

    //     int steps=1+n-1;
    //     int rem_ones,total;
    //     for(int i=2;;i++)
    //     {
    //         rem_ones=n-i*2;
    //         if(rem_ones<0)
    //             break;
    //         total=rem_ones+i;
    //         steps+=(fact(total)/(fact(i)*fact(rem_ones)));
    //         System.out.println(steps);
    //     }
    //     // if(n%2==0 && n!=2)
    //     //     steps++;
    //     return steps;
    // }
    // public static int fact(int x)
    // {
    //     if(x==0 || x==1)
    //         return 1;
    //     return x*fact(x-1);
    // }
    if(n<=0) return 0;
    if(n==1||n==2) return n;
    if(dp[n-1] == 0)
    {
        dp[n-1] = climbStairs(n-1);
    }
    if(dp[n-2] == 0)
    {
        dp[n-2] = climbStairs(n-2);
    }
    return dp[n-1] + dp[n-2];
}}
class Solution {
    public int[] plusOne(int[] digits) {
        // we cannot use string to integer conversion, because it shows error when input is large
        int n=digits.length;
        int d=n;
        if(digits[n-1]==9)
        {
            digits[n-1]=0;
            n--;
            while(n>0 && digits[n-1]==9)
            {
                digits[n-1]=0;
                n--;
            }
            if(n==0)
            {
                int arr[]=new int[d+1];
                arr[0]=1;
                for(int j=1;j<d+1;j++)
                    arr[j]=digits[j-1];
                return arr;
            }
            else
            {
                digits[n-1]=digits[n-1]+1;
                return digits;
            }
            
        }
        else{
            digits[n-1]=digits[n-1]+1;
            return digits;
        }
    }
}
class Solution {
    public int myAtoi(String s) {
//         int n = s.length();
//         int i = 0, neg = 0, pos = 0;
//         long res = 0, int_count = 0;
//         while(i < n)
//         {
//             char c = s.charAt(i);
//             if(c == '-')
//                 neg++;
//             else if(c == '+')
//                 pos++;
//             else if(neg > 0 && pos > 0)
//                 return 0;
//             else if(c >= '0' && c <= '9')
//             {
//                 res = res * 10 + c - '0';
//                 int_count++;
//             }
//             else if(c != ' ')
//             {
//                 if(int_count > 0)
//                     return (int)res;
                
//                 if(res > Integer.MAX_VALUE)
//                     return Integer.MAX_VALUE;
//                 if(res < Integer.MIN_VALUE)
//                     return Integer.MIN_VALUE;

//                 return (int)res;
//             }
            
//             i++;
//         }
//         if(neg > 0)
//             res = -res;
        
//         if(res > Integer.MAX_VALUE)
//             return Integer.MAX_VALUE;
//         if(res < Integer.MIN_VALUE)
//             return Integer.MIN_VALUE;
        
//         return (int)res;
        
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') { // skipping space characters at the beginning
            i++;
        }

        int positive = 0;
        int negative = 0;

        if (i<n && s.charAt(i) == '+') {
            positive++; // number of positive signs at the start in string
            i++;
        }

        if (i<n && s.charAt(i) == '-') {
            negative++; // number of negative signs at the start in string
            i++;
        }

        double ans = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + (s.charAt(i) - '0'); // (s.charAt(i) - '0') is converting character to integer
            i++;
        }

        if (negative > 0) { // if negative sign exists
            ans = -ans;
        }
        if (positive > 0 && negative > 0) { // if both +ve and -ve sign exist, Example: +-12
            return 0;
        }

        if (ans > Integer.MAX_VALUE) { // if ans > 2^31 - 1
            ans = Integer.MAX_VALUE;
        }

        if (ans < Integer.MIN_VALUE) { // if ans < -2^31
            ans = Integer.MIN_VALUE;
        }

        return (int) ans;
    }
}
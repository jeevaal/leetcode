/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start=1,end=n;
        while(start<=end)
        {
            int mid1=start+(end-start)/3;
            int mid2=end-(end-start)/3;
            int temp1=guess(mid1);
            int temp2=guess(mid2);
            if(temp1==0)
                return mid1;
            else if(temp2==0)
                return mid2;
            else if(temp1<0)
                end=mid1-1;
            else if(temp2>0)
                start=mid2+1;
            else{
                start=mid1+1;
                end=mid2-1; 
            }       
        }
        return -1;
        
        
    }
}
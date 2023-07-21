class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0, start, finish;
        for( int i = 0; i < timeSeries.length - 1; i++ )
        {
            start = timeSeries[i];
            finish = timeSeries[i] + duration - 1;
            while( start <= finish  && start < timeSeries[i+1] )
            {
                count++;
                start++;
            }   
        }
        start = timeSeries[timeSeries.length - 1];
        finish = timeSeries[timeSeries.length - 1] + duration - 1;
        while( start <= finish )
        {
            count++;
            start++;
        }
            
        return count;
    }
}
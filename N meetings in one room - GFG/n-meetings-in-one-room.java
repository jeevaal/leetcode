//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Meeting
{
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Meetingcomparator implements Comparator<Meeting>
{
    public int compare(Meeting m1, Meeting m2)
    {
        if(m1.end != m2.end)
            return m1.end - m2.end;
        else
            return m1.pos - m2.pos;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        List<Meeting> al = new ArrayList<>();
        for(int i = 0; i < n; i++)
            al.add(new Meeting(start[i], end[i], i + 1));
        
        Collections.sort(al, new Meetingcomparator());

        List<Integer> a = new ArrayList<>();
        a.add(al.get(0).pos);
        int endTime = al.get(0).end;
        for(int i = 1; i < n; i++)
        {
            if(endTime < al.get(i).start)
            {
                a.add(al.get(i).pos);
                endTime = al.get(i).end;
            }
        }

        return a.size();
    }
}

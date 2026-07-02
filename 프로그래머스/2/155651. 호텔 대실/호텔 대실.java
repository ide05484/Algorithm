import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        
        for(int i = 0; i < book_time.length; i++) {
            bookTime[i][0] = changeTime(book_time[i][0]);
            bookTime[i][1] = changeTime(book_time[i][1]);          
        }
        
        Arrays.sort(bookTime, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //끝나는 시간을 넣는다.
        for(int i = 0; i < bookTime.length; i++) {
            int start = bookTime[i][0];
            int end = bookTime[i][1];
            
            if(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            //끝나는 시간만 넣는다
            pq.offer(end + 10);
        }
        
        return pq.size();
    }
    
    public int changeTime(String str) {
        String[] time = str.split(":");
        
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
}
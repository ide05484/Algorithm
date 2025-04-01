import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] book_time) {
        int len = book_time.length;
        
        int[][] bookTime = new int[len][2];
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < 2; j++) {
                String[] tmp = book_time[i][j].split(":");
                int hour = Integer.parseInt(tmp[0])*60;
                int min = Integer.parseInt(tmp[1]);
                
                bookTime[i][j] = hour + min;
            }
        }
        
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < len; i++) {
            int start = bookTime[i][0];
            int end = bookTime[i][1];
            
            if(!pq.isEmpty() && pq.peek() + 10 <= start) {
                pq.poll();
            }
            
            pq.offer(end);
        }
       
        
        return pq.size();
    }
}
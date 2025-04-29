import java.util.*;
import java.io.*;

class Solution {
    
    static class Disk {
        int id;
        int requestTime;
        int doingTime;
        
        public Disk(int id, int requestTime, int doingTime) {
            this.id = id;
            this.requestTime = requestTime;
            this.doingTime = doingTime;
        }
    }
    
    public int solution(int[][] jobs) {
        
        int[][] newJobs = new int[jobs.length][3];
        
        for(int i = 0; i < jobs.length; i++) {
            newJobs[i][0] = i;
            newJobs[i][1] = jobs[i][0];
            newJobs[i][2] = jobs[i][1];
        }
        
        PriorityQueue<Disk> pq = new PriorityQueue<>((a,b) -> {
            if(a.doingTime == b.doingTime) {
                if(a.requestTime == b.requestTime) {
                    return Integer.compare(a.id, b.id);
                }
                return Integer.compare(a.requestTime, b.requestTime);
            }
            
            return Integer.compare(a.doingTime, b.doingTime);
        });
        
        int time = 0;
        int sum = 0;
        
        Arrays.sort(newJobs, (a, b) -> Integer.compare(a[1], b[1]));
        
        int idx = 0;
        int count = 0;
        
        while(count < newJobs.length) {
            while(idx < newJobs.length && newJobs[idx][1] <= time) {   
                pq.add(new Disk(newJobs[idx][0], newJobs[idx][1], newJobs[idx][2]));
                idx++;
            } // 다넣고
            
            if(!pq.isEmpty()){
                Disk now = pq.poll();
                time += now.doingTime;
                sum += time - now.requestTime; 
                count++;
            } else {
                //pq가 비었다면 다음 작업 시작 시간이 지금 시간 보다 멀다
                time = newJobs[idx][1];
            }
        }

        return sum / jobs.length;
    }
}
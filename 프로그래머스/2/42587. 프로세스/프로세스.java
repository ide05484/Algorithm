import java.io.*;
import java.util.*;

class Solution {
    class Here {
        int priority;
        int loc;
        
        public Here(int priority, int loc) {
            this.priority = priority;
            this.loc = loc;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int now = location;
        int answer = 0;
        
        Queue<Here> q = new LinkedList<>();
        
        for(int p = 0; p < priorities.length; p++) {
            q.add(new Here(priorities[p], p));
        }
        
        while(!q.isEmpty()) {
            Here here = q.poll();
            boolean flag = false;
            
            for(Here next : q) {
                if(here.priority < next.priority) flag = true;
            }
            
            if(flag) {
                q.add(here);
            } else {
                answer++;
                
                if(here.loc == location) {
                    return answer;
                }   
            }
        }
        
        return answer;
    }
}
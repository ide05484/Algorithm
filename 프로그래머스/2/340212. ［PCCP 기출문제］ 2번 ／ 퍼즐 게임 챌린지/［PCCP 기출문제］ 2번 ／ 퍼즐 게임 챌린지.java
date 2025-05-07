import java.io.*;
import java.util.*;

class Solution {
    
    static int max;
    static int answer;
    static int len;
    
    public int solution(int[] diffs, int[] times, long limit) {
        len = diffs.length;
        max = 0;
        
        for(int i = 0; i < len; i++) {
            max = Math.max(max, diffs[i]);
        }
        
        answer = max;
        
        find(1, max, diffs, times, limit);
        
        return answer;
    }
    
    //이분탐색에서 필요한건 명시적인 시작점과 끝점
    public static void find(int start, int end, int[] diffs, int[] times, long limit) {
        
        if(start > end) return;
        
        int level = (start + end) / 2;
        long time = 0;
        
        for(int i = 0; i < len; i++) {
            if(diffs[i] <= level) {
                time += times[i];
            } else {
                int redo = diffs[i] - level;
                
                if(i==0) {
                    time = limit + 1;
                    break;
                }
                
                time += (long) redo * (times[i] + times[i-1]) + times[i];
            }
            
            if(time > limit) break; //즉시종료
        }
        
        if(time <= limit) {
            answer = Math.min(answer, level);
            find(start, level - 1, diffs, times, limit);
        } else { 
            find(level + 1, end, diffs, times, limit);
        }
        
    }
}
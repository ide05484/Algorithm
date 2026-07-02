import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int end = 0;
        
        for(int i = 0; i < targets.length; i++) {
            int start = targets[i][0];
            int finish = targets[i][1];
            
            //요격범위에 해당하지 않는경우
            if(start >= end) {
                answer++;
                end = finish;
            }
        }
        
        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 0; // 아직 배포 안 된 가장 앞 기능
        
        while(idx < progresses.length) {
            
            for(int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            
            // 앞에서부터 완료된 기능 확인
            int deployCount = 0;
            int now = idx;
            
            for(int i = now; i < progresses.length; i++) {
                if(progresses[i] >= 100) {
                    deployCount++;
                    idx++;
                } else break;
            }
            
            if(deployCount > 0) list.add(deployCount);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
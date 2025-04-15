import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int count = 0;
        int zeroCnt = 0;
        
        int N = lottos.length;
        
        for(int i = 0; i < N; i++) {
            int num = lottos[i];
            
            if(num == 0) {
                zeroCnt++;
                continue;
            }
            
            for(int j = 0; j < N; j++) {
                if(num == win_nums[j]) {
                    count++; // 맞춘 개수
                    break;
                }
            }
        }
        
        int max = count == 0 && zeroCnt == 0 ? 6 : 6 - (zeroCnt + count) + 1; //최고등수
        int min = count == 0 ? 6 : 6 - count + 1;
        
        return new int[]{max, min};
    }
}
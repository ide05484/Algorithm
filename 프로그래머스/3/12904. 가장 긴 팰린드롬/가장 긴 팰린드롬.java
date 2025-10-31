import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s){
        
        int len = s.length();
        int max = len;
        boolean isPalin = false;
        
        out: while(true) {
            if(len <= 1) break;
            //
            for(int i = 0; i <= len - max; i++) {
                if(checkPalin(s, i, max)) {
                    break out;    
                }
            }
            
            max--;
        }
        
        return max;
    }
    
    private boolean checkPalin(String s, int idx, int max) {
        int mid = max / 2;
        int sum = 2 * idx + max - 1;
        
        for(int i = idx; i < idx + mid; i++) {
            char now = s.charAt(i);
            char next = s.charAt(sum - i);
            
            //idx, idx + 1, ... , idx + max - 2, idx + max - 1
            //둘의 합 2*idx + max - 1이어야 함...
            
            if(now != next) return false; //하나라도 같지 않으면...
        }
        
        return true;
    }
}
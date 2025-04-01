import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int len = tangerine.length;
        
        for(int i = 0; i < len; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        
        int cnt = 0;
        
        for(int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            cnt ++;
            
            if(k <= 0) break;
        }

        return cnt;
    }
}
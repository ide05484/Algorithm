import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    
        Map<String, Integer> todo = new HashMap<>();
        
        for(int i = 0; i < want.length; i++) {
            todo.put(want[i], number[i]);
        }
        
        int count = 0;
        
        for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            
            for(int d = 0; d < 10; d++) {
                tmp.put(discount[i+d], tmp.getOrDefault(discount[i+d], 0) + 1);
            }
            
            if(todo.equals(tmp)) count++;            
        }
        
        return count;
    }
}
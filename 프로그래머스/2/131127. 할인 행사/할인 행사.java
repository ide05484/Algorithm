import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    
        Map<String,Integer> map = new HashMap<>();
        
        int len = want.length;
        
        for(int i = 0; i < len; i++) {
            map.put(want[i], number[i]);
        }
        
        int count = 0;
        
        //할인날짜를 돌면서 10일간의 체크를 함
        to: for(int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            for(int j = i; j < i+10; j++) {
                tmp.put(discount[j], tmp.getOrDefault(discount[j], 0) + 1);
            }
            
            //여기에서 수량 다 샀는지 체크
            for(int l = 0; l < len; l++) {
                if(map.get(want[l]) != tmp.get(want[l])) continue to;
            }
            
            count++;
        }
        
        return count;
    }
}
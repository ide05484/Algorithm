import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        Map<String, Integer> wishList = new HashMap<>(); //위시리스트
        
        for(int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }
        
        int len = discount.length;
        
        int answer = 0;
        
        to: for(int i = 0; i <= len - 10; i++) {
            
            Map<String, Integer> canBuy = new HashMap<>();
            
            for(int j = i; j < i + 10; j++) {
                canBuy.put(discount[j], canBuy.getOrDefault(discount[j], 0) + 1);
            }
            
            //여기에서 숫자 일치하는지 확인
            for(int w = 0; w < want.length; w++) {
                String product = want[w];
                
                if(wishList.get(product) != canBuy.getOrDefault(product, 0)) {
                    //하나라도 안맞으면
                    continue to;
                }
            }
            
            //다맞으면
            answer++;
        }
        
        return answer;
    }
}
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) return 5 * cities.length;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(String city : cities) {
            city = city.toLowerCase();
            
            if(cache.remove(city)) {
                //캐시히트
                answer++;
                cache.add(city);
            } else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0); // 가장 오래된 데이터 제거
                }
                
                cache.add(city); // 새 데이터 추가
            }
        }
        
        return answer;
    }
}
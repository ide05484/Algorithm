import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        int answer = 1;

        for (String kind : map.keySet()) {
            answer *= map.get(kind) + 1; //안입는 경우의 수
        }
            
        return answer - 1; //전부 안입는 경우 빼기
    }
}
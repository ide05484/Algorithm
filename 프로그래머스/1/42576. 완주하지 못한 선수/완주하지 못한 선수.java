import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }
        
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) - 1);
            
            if(map.get(participant[i]) < 0) return participant[i];
        }
        
        
        return "";
    }
}
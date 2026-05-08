import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < words.length - 1; i++) {
            String str = words[i];
            String next = words[i+1];
            
            if(str.charAt(str.length() - 1) != next.charAt(0) || set.contains(next)) {
                return new int[] { ((i + 1) % n) + 1, ((i+1) / n) + 1 };
            }
            
            set.add(str);
        }
        
        return answer;
    }
}
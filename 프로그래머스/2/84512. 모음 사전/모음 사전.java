import java.util.*;
import java.io.*;

class Solution {
    
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    static ArrayList<String> list;
    
    public int solution(String word) {
        
        list = new ArrayList<>();
        
        comb("");
        
        int answer = 0;
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    
    public static void comb(String now) {
        if(now.length() > 5) {
            return;
        }
        
        if(!now.equals(""))  list.add(now);
        
        for(int i = 0; i < 5; i++) {
            comb(now + alphabet[i]);
        }
    }
}
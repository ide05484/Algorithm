import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        
        int time = 0; //횟수
        int count = 0; //0 카운트
        
        while(!s.equals("1")) {
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') count++;
            }
            
            String[] str = s.split("0");
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < str.length; i++) {
                sb.append(str[i]);
            }
            
            int size = sb.toString().length();
            s = Integer.toBinaryString(size);
            
            time++;
        }
        
        return new int[]{time, count};
    }
}
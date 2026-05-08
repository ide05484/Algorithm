import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int minLen = s.length();
        
        //문자열보다 커지면 멈추기
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i); //기본 문자
            int count = 1;
            
            for(int j = i; j < s.length(); j += i) {
                int end = Math.min(j + i, s.length()); //subString은 뒤에거 포함 안됨
                String next = s.substring(j, end); //다음 글자
                
                if(str.equals(next)){
                    count++;
                } else {
                    if(count >= 2){
                        sb.append(count);
                    }
                    
                    sb.append(str);
                    str = next;

                    count = 1;
                }
            }
            
            //마지막 단어도 더해주기
            if(count >= 2){
                sb.append(count);
            }
                    
            sb.append(str);
            
            minLen = Math.min(minLen, sb.length());
        }
        
        return minLen;
    }
}
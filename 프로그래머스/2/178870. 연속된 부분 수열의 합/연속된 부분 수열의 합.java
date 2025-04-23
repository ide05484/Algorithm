import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int min = 1000000; //최대길이
        
        int[] answer = new int[2];
        
        while(end < sequence.length) {
            if(sum < k) {
                end++;
                if(end < sequence.length) sum += sequence[end];
            } else {
                if(sum == k) {
                    if ((end - start) < min) {
                        min = end - start;
                        answer[0] = start;
                        answer[1] = end;
                    }
                }
                
                sum -= sequence[start++];
            }
        }
        
        return answer;
    }
}
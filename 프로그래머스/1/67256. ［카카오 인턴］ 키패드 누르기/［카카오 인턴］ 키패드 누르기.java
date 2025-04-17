import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        Map<Integer, int[]> map = new HashMap<>();
        
        map.put(0, new int[]{3,1});
        map.put(1, new int[]{0,0});
        map.put(2, new int[]{0,1});
        map.put(3, new int[]{0,2});
        map.put(4, new int[]{1,0});
        map.put(5, new int[]{1,1});
        map.put(6, new int[]{1,2});
        map.put(7, new int[]{2,0});
        map.put(8, new int[]{2,1});
        map.put(9, new int[]{2,2});
        
        StringBuilder answer = new StringBuilder();
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int n = 0; n < numbers.length; n++) {
            
            int[] now = map.get(numbers[n]);
            
            if(numbers[n] % 3 == 1) {
                answer.append("L");
                left[0] = now[0];
                left[1] = now[1];
            } else if(numbers[n] % 3 == 2 || numbers[n] == 0) {
                int diffR = Math.abs(right[0] - now[0]) + Math.abs(right[1] - now[1]);
                int diffL = Math.abs(left[0] - now[0]) + Math.abs(left[1] - now[1]);
                
                if(diffR > diffL) {
                    answer.append("L");
                    left[0] = now[0];
                    left[1] = now[1];
                } else if (diffR < diffL) {
                    answer.append("R");
                    right[0] = now[0];
                    right[1] = now[1];
                } else {
                    if(hand.equals("right")) {
                        answer.append("R");
                        right[0] = now[0];
                        right[1] = now[1];
                    } else {
                        answer.append("L");
                        left[0] = now[0];
                        left[1] = now[1];
                    }
                }
            } else {
                answer.append("R");
                right[0] = now[0];
                right[1] = now[1];
            }
        }
        
        return answer.toString();
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneLen = one.length;
        int twoLen = two.length;
        int threeLen = three.length;
        
        int[] count = {0, 0, 0};
        
        for(int i = 0; i < answers.length; i++) {
            
            if(answers[i] == one[i % oneLen]) count[0]++;
            if(answers[i] == two[i % twoLen]) count[1]++;
            if(answers[i] == three[i % threeLen]) count[2]++;
        }
        
        int maxCount = Math.max(count[0], Math.max(count[1], count[2]));
                
        int[] result = new int[3];
        
        int index = 0;

        for (int i = 0; i < 3; i++) {
            if (count[i] == maxCount) {
                result[index++] = i + 1;
            }
        }
        
        int[] answer = new int[index];
        
        for (int i = 0; i < index; i++) {
            answer[i] = result[i];
        }
        
        return answer;
    }
}
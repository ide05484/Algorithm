import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int len = gems.length;
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : gems){
            set.add(s);
        }
        
        int num = set.size(); //종류개수
        
        int start = 0;
        int end = 0;
        int diff = Integer.MAX_VALUE; // 구간 차이 최대값
        
        HashMap<String, Integer> map = new HashMap<>();
        //보석, 개수
        
        while(true) {
            if(map.size() == set.size()) {
                int length = end - start;
                
                if(length < diff) {
                    //최소값일 경우
                    diff = length;
                    answer[0] = start + 1;
                    answer[1] = end;
                }
                
                //축소시도
                String now = gems[start];
                map.put(now, map.get(now) - 1);
                
                if(map.get(now) == 0) {
                    //하나도 없으면
                    map.remove(now);
                }
                
                start++;
            } else {
                if(end == len) break;
                
                String rightGem = gems[end];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
                end++;    
            }
        }
        
        
        
        return answer;
    }
}
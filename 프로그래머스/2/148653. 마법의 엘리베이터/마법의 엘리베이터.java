class Solution {
    public int solution(int storey) {
        
        int answer = 0;
        
        while(storey > 0) {
            int end = storey % 10; //마지막 자리수
            storey /= 10;
            
            if(end == 5) {
                int nextEnd = storey % 10;
                
                if(nextEnd >= 5) {
                    answer += 10 - end;
                    storey++; //1자리수 올림
                } else {
                    answer += end;
                }
            } else if(end > 5) {
                answer += 10 - end;
                storey++; //1자리수 올림
            } else {
                answer += end;
            }
        }
        
        return answer;
    }
}
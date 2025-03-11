class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int workers = schedules.length; //직원 수
        
        int answer = 0;
        
        for(int r = 0; r < workers; r++) {     
            int count = 0;
            for(int c = 0; c < 7; c++) {
                //주말일 때는 세지 않는다.
                if((startday + c) % 7 == 6 || (startday + c) % 7 == 0) continue;
                
                int check = (schedules[r] + 10) % 100 >= 60 ? schedules[r] + 10 + 40 : schedules[r] + 10; //10분까지 인정
                
                if(check < timelogs[r][c]) break;
                
                count++;
            }
            
            if(count == 5) answer++;
        }
        
        return answer;
    }
}
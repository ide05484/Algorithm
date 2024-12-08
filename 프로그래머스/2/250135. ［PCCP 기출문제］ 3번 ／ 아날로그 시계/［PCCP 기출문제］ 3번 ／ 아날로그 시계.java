class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        
        int start = parseToSec(h1, m1, s1);
        int end = parseToSec(h2, m2, s2);
        
        answer = calculate(end) - calculate(start);
        answer += alramNow(start) ? 1 : 0; //시작 시간이 알림이 울리는 시간인지 체크
        
        return answer;
    }
    
    public int calculate(int time) {
        
        int minuteAlarm = time * 59 / 3600;
        // 분침 한바퀴(3600초) 동안 초침과 60번 만나는데, 시작시간(00시) 제외라서 59번
        int hourAlarm = time * 719 / 43200;
        // 시침 한바퀴(43200초) 동안 초침과 720번(60*12) 만나는데, 시작시간(00시) 제외라서 719번

        int twelveClockAlrams = 43200 <= time ? 2 : 1;
        //정오 전이면 1번(자정), 정오 후면 정오까지 2번 
        
        return minuteAlarm + hourAlarm - twelveClockAlrams; 
    }
    
    public boolean alramNow(int time) {
        return time * 59 / 3600 == 0 || time * 719 % 43200 == 0;
    }
    
    public int parseToSec(int h, int m, int s) {
        return 60*60*h + 60*m + s;
    }
    
}
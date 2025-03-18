class Solution {
    public int solution(int k, int m, int[] score) {
        
        int[] appleCnt = new int[k+1]; //사과는 최대 k점
        int total = score.length; //총 사과 개수
        int box = total / m; //박스 개수
        
        for(int i = 0; i < total; i++) {
            appleCnt[score[i]]++;
        }
        
        int sum = 0;
        int idx = k;
        
        for(int i = 0; i < box; i++) {
            int cnt = 0;
            int min = k;
            
            while(true) {
                if(cnt == m) break;
                
                if(appleCnt[idx] == 0) {
                    idx--;
                    continue;
                }               
                
                cnt++;
                appleCnt[idx]--;
                min = Math.min(min, idx);
            }
            sum += min * m;
        }

        return sum;
    }
}
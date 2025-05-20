class Solution {
    public int solution(int n, int w, int num) {
        
        int totalRow = n / w; //제일 높은 번쨰 줄 idx
        
        int row = (num - 1) / w; //0부터
        int pos = (num - 1) % w;
        int col = 0; //칼럼
        
        int answer = 1;
        
        // 현재 줄 방향에 따라 col 계산
        if (row % 2 == 0) {
            col = pos;
        } else {
            col = (w - 1) - pos;
        }
        
        for(int r = row + 1; r <= totalRow; r++) {
            int nextStart = r * w + 1;
            if (nextStart > n) break;
            
            int nextNum;
            
            if (r % 2 == 0) {
                // 왼 -> 오
                nextNum = nextStart + col;
            } else {
                // 오 -> 왼
                nextNum = nextStart + (w - 1 - col);
            }

            if (nextNum > n) break;

            
            answer++;
        }
        
        return answer;
    }
}
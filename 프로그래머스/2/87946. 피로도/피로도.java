class Solution {
    
    static int max;
    
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        
        boolean[] visit = new boolean[dungeons.length];
        
        dfs(visit, k, dungeons, 0);
        
        return max;
    }
    
    //방문배열, 체력, 던전, 돌았던 던전 개수
    public void dfs(boolean[] visit, int k, int[][] dungeons, int cnt) {
        max = Math.max(max, cnt);
        
        for(int d = 0; d < dungeons.length; d++) {
            if(visit[d] || k < dungeons[d][0]) continue;
            //방문했거나 못가는 던전이면 패스
            
            visit[d] = true;
            dfs(visit, k - dungeons[d][1], dungeons, cnt + 1);
            visit[d] = false; //원상복구
        }
        
        return;
    }
}
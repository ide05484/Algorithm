import java.util.*;
import java.io.*;

class Solution {
    class Pos {
        int r;
        int c;
        int dist;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, M;
    static int answer;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        answer = 0;
        
        N = maps.length;
        M = maps[0].length;
        
        return bfs(maps);
    }
    
    public int bfs(int[][] maps) {
        boolean[][] visit = new boolean[N][M];
        
        Queue<Pos> queue = new LinkedList();
        queue.add(new Pos(0, 0, 1));
        
        while(!queue.isEmpty()) {
            Pos now = queue.poll();
            visit[0][0] = true;
            
            if(now.r == N-1 && now.c == M-1) {
                return now.dist;
            }
            
            for(int d = 0; d < 4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];
                int dist = now.dist;
                
                //못갑니다
                if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || maps[nextR][nextC] == 0 || visit[nextR][nextC]) continue;
                
                visit[nextR][nextC] = true;
                queue.add(new Pos(nextR, nextC, dist+1));
            }
        }
        
        return -1;
    }
}
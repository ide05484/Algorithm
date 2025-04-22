import java.util.*;
import java.io.*;

class Solution {
    static class Now {
        int r;
        int c;
        int dist;
        
        public Now(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] board;
    static int R, C;
    static int answer;
        
    public int solution(String[] maps) {
        
        R = maps.length;
        C = maps[0].length();
        
        board = new char[R][C];
        
        int startR = 0;
        int startC = 0;
        int laverR = 0;
        int laverC = 0;
        int exitR = 0;
        int exitC = 0;
        
        for(int r = 0; r < R; r++) {
            String str = maps[r];
            for(int c = 0; c < C; c++) {
                board[r][c] = str.charAt(c);
                if(board[r][c] == 'S') {
                    startR = r;
                    startC = c;
                } else if(board[r][c] == 'L') {
                    laverR = r;
                    laverC = c;
                } else if(board[r][c] == 'E') {
                    exitR = r;
                    exitC = c;
                }
            }
        }
        
        answer = 0;
        
        bfs(startR, startC, laverR, laverC);
        if(answer == -1) return answer;
        
        bfs(laverR, laverC, exitR, exitC);

        return answer;
    }
    
    public static void bfs(int startR, int startC, int endR, int endC) {
        Queue<Now> queue = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];
        
        queue.add(new Now(startR, startC, 0));
        visit[startR][startC] = true;
        
        while(!queue.isEmpty()){
            Now now = queue.poll();
            
            if(now.r == endR && now.c == endC) {
                answer += now.dist;
                return;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc] || board[nr][nc] == 'X') continue;
                
                queue.add(new Now(nr, nc, now.dist + 1));
                visit[nr][nc] = true;
            }
        }
        
        answer = -1;
    }
}
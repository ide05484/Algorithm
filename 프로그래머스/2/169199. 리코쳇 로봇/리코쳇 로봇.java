import java.io.*;
import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    class Point {
        int r;
        int c;
        int dist;
        
        public Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    
    public int solution(String[] board) {
        int answer = 0;
        
        char[][] game = new char[board.length][board[0].length()];
        
        int startR = 0;
        int startC = 0;
        int goalR = 0;
        int goalC = 0;
        
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length(); c++) {
                game[r][c] = board[r].charAt(c);
                
                if(game[r][c] == 'R') {
                    startR = r;
                    startC = c;
                }
                
                if(game[r][c] == 'G') {
                    goalR = r;
                    goalC = c;
                }
            }
        }
        
        answer = bfs(game, startR, startC, goalR, goalC);
        
        return answer;
    }
    
    public int bfs(char[][] game, int startR, int startC, int goalR, int goalC) {
        int N = game.length;
        int M = game[0].length;
        
        boolean[][] visit = new boolean[N][M];
        
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(startR, startC, 0));
        visit[startR][startC] = true;
        
        while(!q.isEmpty()) {
            Point now = q.poll();
            
            if(now.r == goalR && now.c == goalC) return now.dist;       
            
            for(int d = 0; d < 4; d++) {
                int nr = now.r;
                int nc = now.c;
                
                while(true) {
                    int nextR = nr + dr[d];
                    int nextC = nc + dc[d];
                    
                    if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M || game[nextR][nextC] == 'D') {
                        break;
                    }
                    
                    nr = nextR;
                    nc = nextC;
                }
                
                if(visit[nr][nc]) continue;
                
                q.add(new Point(nr, nc, now.dist+1));
                visit[nr][nc] = true;
            }
        }
        
        return -1;
    }
}
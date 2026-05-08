import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int startR = 0;
    static int startC = 0;
    static int laverR = 0;
    static int laverC = 0;
    static int endR = 0;
    static int endC = 0;
    
    class Point {
        int r;
        int c;
        int time;
        
        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
        
    public int solution(String[] maps) {
        
        char[][] miro = new char[maps.length][maps[0].length()];
        
        for(int r = 0; r<maps.length; r++) {
            for(int c = 0; c < maps[0].length(); c++) {
                miro[r][c] = maps[r].charAt(c);
                
                if(miro[r][c] == 'S') {
                    startR = r;
                    startC = c;
                }
                
                if(miro[r][c] == 'L') {
                    laverR = r;
                    laverC = c;
                }
                
                if(miro[r][c] == 'E') {
                    endR = r;
                    endC = c;
                }
            }
        }
        
                    
        return bfs(miro);
    }
    
    public int bfs(char[][] miro) {
        int N = miro.length;
        int M = miro[0].length;
        
        boolean[][] visitA = new boolean[N][M];
        
        Queue<Point> qA = new LinkedList<>();
        qA.add(new Point(startR, startC, 0));
        visitA[startR][startC] = true;
        int tmpdist = 0;
        
        while(!qA.isEmpty()) {
            Point now = qA.poll();
            
            if(now.r == laverR && now.c == laverC) {
                tmpdist = now.time;
                break;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visitA[nr][nc] || miro[nr][nc] == 'X') continue;
                
                qA.add(new Point(nr, nc, now.time+1));
                visitA[nr][nc] = true;
            }
        }
        
        if(tmpdist == 0) return -1;
        
        boolean[][] visitB = new boolean[N][M];
        
        Queue<Point> qB = new LinkedList<>();
        qB.add(new Point(laverR, laverC, tmpdist));
        visitB[laverR][laverC] = true;
        
        while(!qB.isEmpty()) {
            Point now = qB.poll();
            
            if(now.r == endR && now.c == endC) {
                return now.time;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visitB[nr][nc] || miro[nr][nc] == 'X') continue;
                
                qB.add(new Point(nr, nc, now.time+1));
                visitB[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
}
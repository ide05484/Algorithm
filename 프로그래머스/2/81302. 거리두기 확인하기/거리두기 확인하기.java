import java.util.*;
import java.io.*;

class Solution {
    
    //팔방탐색
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        
        int T = places.length;
        
        int[] answer = new int[T];
        
        to: for(int t = 0; t < T; t++) {
            
            char[][] room = new char[5][5];
            
            for(int r = 0; r < 5; r++) {
                String str = places[t][r];
                for(int c = 0; c < 5; c++) {
                    room[r][c] = str.charAt(c);
                }
            } //입력 완료
            
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(room[r][c] == 'P') {
                        if(!bfs(room, r, c)) {
                            answer[t] = 0;
                            continue to;
                        };
                    }
                }
            } //bfs
            
            answer[t] = 1;
            
        } //테케돌리기
        
        return answer;
    }
    
    public static boolean bfs(char[][] room, int R, int C) {
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        
        queue.add(new int[]{R, C});
        visit[R][C] = true;
        
        while(!queue.isEmpty()) {
            
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            
            int dist = Math.abs(r - R) + Math.abs(c - C);
            
            //자기자신이거나 거리가 멀면 하지 않는다
            if(dist > 2) continue;
            
            if(dist == 1) {
                if(room[r][c] == 'P') return false;
            } else if(dist == 2 && room[r][c] == 'P') {
                //일직선일때
                if(r == R) {
                    if(room[r][(c+C)/2] == 'O') return false; //칸막이 없으면
                }
                
                if(c == C) {
                    if(room[(r+R)/2][c] == 'O') return false; //칸막이 없으면
                }
                
                //대각선일때
                if(room[r][C] == 'O' || room[R][c] == 'O') return false;
            }
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visit[nr][nc]) continue;
                
                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;
            }
            
        }
        
        return true;
    }
    
}
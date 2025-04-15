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
            String[] tmp = places[t];
        
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    room[r][c] = tmp[r].charAt(c);                
                }
            }
            
            //여기에서 체크
            for(int r = 0; r < 5; r++) {
                for(int c = 0; c < 5; c++) {
                    if(room[r][c] == 'P') {
                        if(!bfs(room, r, c)) {
                            //만약에 불가능하면
                            answer[t] = 0;
                            continue to;
                        };
                    }
                }
            }
            
            answer[t] = 1;
            
        }
        
        return answer;
    }
    
    public static boolean bfs(char[][] room, int R, int C) {
        boolean[][] visit = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{R, C});
        visit[R][C] = true;
        
        while(!queue.isEmpty()) {
            
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];
            
            int dist = Math.abs(r - R) + Math.abs(c - C); //거리
            
            if(dist > 2) continue; 
            
            if(dist == 1 && room[r][c] == 'P') return false;  // 거리 1이면 무조건 위반

            if(dist == 2 && room[r][c] == 'P') { // 거리가 2일 때 파티션 여부 체크
                    // 같은 행
                    if(r == R) {
                        if(room[r][(c + C) / 2] == 'O') return false;
                    }
                    // 같은 열
                    else if(c == C) {
                        if(room[(r + R) / 2][c] == 'O') return false;
                    }
                    // 대각선
                    else {
                        if(room[r][C] == 'O' || room[R][c] == 'O') return false;
                    }
            }
  
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visit[nr][nc]) continue;
                
                if(room[nr][nc] != 'X') {
                    queue.add(new int[]{nr, nc});
                    visit[nr][nc] = true;
                }
            }
            
        }
        
        return true;
    }
}
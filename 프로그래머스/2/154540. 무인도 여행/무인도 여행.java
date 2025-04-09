import java.util.*;
import java.io.*;

class Solution {
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    static ArrayList<Integer> list;
    static int[][] island;
    static int lenR;
    static int lenC;
    static boolean[][] visit;
    
    public int[] solution(String[] maps) {

        lenR = maps.length;
        lenC = maps[0].length();
        
        island = new int[lenR][lenC];
        
        for(int r = 0; r < lenR; r++) {
            String str = maps[r];
            for(int c = 0; c < lenC; c++) {
                char txt = str.charAt(c);
                
                if(txt == 'X') {
                  island[r][c] = 0;
                  // System.out.print(island[r][c] + " ");
                  continue;
                } 
                
                island[r][c] = txt - '0';
                
                // System.out.print(island[r][c] + " ");
            }
            // System.out.println();
        } //입력
        
        list = new ArrayList<>();
        visit = new boolean[lenR][lenC];
        
        for(int r = 0; r < lenR; r++) {
            for(int c = 0; c < lenC; c++) {
                if(island[r][c] > 0 && !visit[r][c]) {
                    int tmp = dfs(r, c);
                    list.add(tmp);
                    // System.out.println(tmp + "days");
                }
            }
        }
        
        Collections.sort(list);
        
        if(list.isEmpty()) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int dfs(int R, int C){
        
        visit[R][C] = true;
        // System.out.println(days + "이걸로 dfs");
        int totalDays = island[R][C]; // 현재 위치 값으로 시작
        
        for(int d = 0; d < 4; d++) {
            int nr = R + dr[d];
            int nc = C + dc[d];
            
            if(nr < 0 || nr >= lenR || nc < 0 || nc >= lenC || island[nr][nc] == 0 || visit[nr][nc]) continue;
            
            totalDays += dfs(nr, nc); // 반환된 값을 totalDays에 누적
        }
        
        
        return totalDays;
    }
}
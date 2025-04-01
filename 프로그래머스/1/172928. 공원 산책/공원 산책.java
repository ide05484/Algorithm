import java.util.*;
import java.io.*;

class Solution {
    
    static int[] dr = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dc = {0, 0, -1, 1}; //상 하 좌 우
    
    public int[] solution(String[] park, String[] routes) {
        
        int startR = 0;
        int startC = 0;
        
        int lenR = park.length;
        int lenC = park[0].length();
        
        char[][] board = new char[lenR][lenC];
        
        out: for(int r = 0; r < lenR; r++) {
            String str = park[r];

            for(int c = 0; c < lenC; c++) {
                
                board[r][c] = str.charAt(c);
                
                if(str.charAt(c) == 'S') {
                    startR = r;
                    startC = c;
                }
            }
        }
        
        to: for(int i = 0; i < routes.length; i++) {
            String[] order = routes[i].split(" ");
            
            int dir = -1;
            int going = Integer.parseInt(order[1]);
            
            switch (order[0]) {
                case "N" :
                    dir = 0; 
                    break;
                case "S" :
                    dir = 1;
                    break;
                case "W" :
                    dir = 2;
                    break;
                case "E" :
                    dir = 3;
                    break;
            }
            
            for(int j = 1; j <= going; j++) {
                int nr = startR + j * dr[dir];
                int nc = startC + j * dc[dir];
                
                if(nr < 0 || nr >= lenR || nc < 0 || nc >= lenC || board[nr][nc] == 'X') {
                    continue to;
                }
            }
            
            startR += going * dr[dir];
            startC += going * dc[dir];
        }
        
        return new int[]{startR, startC};
    }
}
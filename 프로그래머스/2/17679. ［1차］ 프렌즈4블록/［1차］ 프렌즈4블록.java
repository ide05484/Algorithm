import java.util.*;
import java.io.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        
        char[][] game = new char[m][n];
        
        for(int r = 0; r < m; r++) {
            String str = board[r];
            for(int c = 0; c < n; c++) {
                game[r][c] = str.charAt(c);
            }
        }
        
        int count = 0;
        
        while(true) {
            boolean[][] remove = new boolean[m][n];
            boolean found = false;            
            
            //지울 블록 표시
            for(int r = 0; r < m-1; r++) {
                for(int c = 0; c < n-1; c++) {
                    char now = game[r][c];
                    
                    if(now == '.') continue;
                    
                    if(now == game[r+1][c] && now == game[r][c+1] && now == game[r+1][c+1]) {
                        remove[r][c] = true;
                        remove[r+1][c] = true;
                        remove[r][c+1] = true;
                        remove[r+1][c+1] = true;
                        
                        found = true;
                    }
                }
            }
            
            if(!found) break; //지울 블록 없으면 멈춰
            
            //지울 블록 없애기
            for(int r = 0; r < m; r++) {
                for(int c = 0; c < n; c++) {
                    if(remove[r][c]) {
                        game[r][c] = '.';
                        count++;
                    }
                }
            }
            
            //블록 내리기
            for (int c = 0; c < n; c++) {
                Stack<Character> stack = new Stack<>();

                // 1. 위에서 아래로 보면서 .이 아닌 블록만 담기
                for (int r = 0; r < m; r++) {
                    if (game[r][c] != '.') {
                        stack.push(game[r][c]);
                    }
                }

                // 2. 일단 해당 열을 전부 .으로 만들기
                for (int r = 0; r < m; r++) {
                    game[r][c] = '.';
                }

                // 3. 아래에서부터 다시 채우기
                for (int r = m - 1; r >= 0; r--) {
                    if (stack.isEmpty()) break;
                    game[r][c] = stack.pop();
                }
            }
        }
        
        return count;
    }
}
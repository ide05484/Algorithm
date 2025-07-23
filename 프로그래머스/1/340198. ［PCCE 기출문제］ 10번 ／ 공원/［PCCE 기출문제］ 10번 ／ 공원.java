import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int lenR = park.length;
        int lenC = park[0].length;
        
        Arrays.sort(mats);
        
        for(int r = 0; r < lenR; r++) {
            to: for(int c = 0; c < lenC; c++) {
                    for(int i = mats.length - 1; i >= 0; i--) {
                        int num = mats[i];
                        
                        if (canPlace(park, r, c, num)) {
                            answer = Math.max(answer, num);
                            break; // 더 작은 매트는 무시
                        }
                    }
            }
        }
        
        return answer;
    }
    
    private boolean canPlace(String[][] park, int r, int c, int size) {
        int lenR = park.length;
        int lenC = park[0].length;

        if (r + size > lenR || c + size > lenC) return false;

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }

        return true;
    }
}
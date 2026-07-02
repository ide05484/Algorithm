import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int health = 0; //피로도
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(minerals.length, totalPicks * 5);
        //곡괭이가 더 적은 경우를 고려한 값        
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < maxMinerals; i += 5) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            
            for(int j = i; j < i+5; j++) {
                if(j >= maxMinerals) break;
                
                if(minerals[j].equals("diamond")) diamond++;
                else if(minerals[j].equals("iron")) iron++;
                else stone++;
            }
            
            list.add(new int[]{diamond, iron, stone});
        }
        
        list.sort((a, b) -> {
           if(b[0] != a[0]) return b[0] - a[0]; //다이아 많은 순
            return b[1] - a[1]; //그다음 철 많은 순
        });

        for(int[] group : list) {
            int tool = -1;
            
            for (int i = 0; i < 3; i++) {
                if (picks[i] > 0) {
                    picks[i]--;
                    tool = i;
                    break;
                }
            }

            if (tool == -1) break;

            int diamond = group[0];
            int iron = group[1];
            int stone = group[2];

            if (tool == 0) {
                health += diamond + iron + stone;
            } else if (tool == 1) {
                health += diamond * 5 + iron + stone;
            } else {
                health += diamond * 25 + iron * 5 + stone;
            }
        }
        
        return health;
    }
}
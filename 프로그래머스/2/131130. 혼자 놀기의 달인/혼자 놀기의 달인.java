import java.util.*;
import java.io.*;

class Solution {
    
    static List<Integer> list;
    static boolean[] visit;
    
    public int solution(int[] cards) {
        
        int len = cards.length;
        
//         int[][] boxes = new int[len + 1][2];
        
//         for(int r = 1; r <= len; r++) {
//             boxes[r][0] = r; //상자 번호
//             boxes[r][1] = cards[r]; //들어있는 카드
//         }
        
        //총 그래프가 몇개 인가, 그리고 그 그래프에는 얼만큼의 숫자가 있는가를 알아야..
        list = new ArrayList<>();
        visit = new boolean[len];
        
        //상자 번호 열기 ...
        for(int i = 0; i < len; i++) {
            if(!visit[i]) {
                dfs(cards, visit, 0, i);
            }
        }
        
        Collections.sort(list, (a, b) -> b-a);
        
        if(list.size() == 1) return 0;
                
        int answer = list.get(0) * list.get(1);
        return answer;
    }
    
    public static void dfs(int[] cards, boolean[] visit, int count, int idx) {
        if(visit[idx]) {
            list.add(count);
            // System.out.println(count);
            return;
        }
        
        visit[idx] = true;
        int nextIdx = cards[idx] - 1;
    
        dfs(cards, visit, count + 1, nextIdx);
    }
}
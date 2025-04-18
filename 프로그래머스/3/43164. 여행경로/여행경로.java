import java.util.*;
import java.io.*;

class Solution {
    
    static ArrayList<String> list;
    static int len;
    static boolean[] use;
    
    public String[] solution(String[][] tickets) {
        
        len = tickets.length;
        use = new boolean[len];
        list = new ArrayList<>();
        
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);

        return list.get(0).split(" ");
    }
    
    public static void dfs(int start, String now, String path, String[][] tickets) {
        if(start == len) {
            list.add(path);
            return;
        }
        
        for(int i = 0; i < len; i++) {
            if(!use[i] && now.equals(tickets[i][0])) {
                use[i] = true;
                dfs(start + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                use[i] = false;
            }
        }
    }
}
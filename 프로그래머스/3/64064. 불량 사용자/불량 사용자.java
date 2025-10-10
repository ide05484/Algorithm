import java.io.*;
import java.util.*;

/*
1. 각 불량 사용자가 몇명이 될 수 있는지를 저장해둘 배열 필요
2. 이를 다 곱하면 경우의 수가 나옴.
*/

class Solution {
    public int solution(String[] user_id, String[] banned_id) {        
        
        // 1) 각 banned 패턴에 매칭 가능한 user 인덱스 목록 만들기 (당신의 매칭 로직 재사용)
        List<List<Integer>> candidates = new ArrayList<>();
        
        for(int i = 0; i < banned_id.length; i++) {
            String banned = banned_id[i];
            List<Integer> list = new ArrayList<>();
            
            to: for(int j = 0; j < user_id.length; j++) {
                String user = user_id[j];
                
                //길이가 다르면 아닌거
                if(user.length() != banned.length()) continue;
                
                //여기에서 체크해야함
                for(int k = 0; k < banned.length(); k++) {
                    if(banned.charAt(k) == '*') continue;
                    if(banned.charAt(k) != user.charAt(k)) continue to;
                }
                
                list.add(j); // j번 user가 i번 banned 슬롯에 후보로 가능
            }
            
            candidates.add(list);
        }
        
        // 2) DFS로 가능한 조합 탐색 (비트마스크 X, boolean[] 사용)
        boolean[] used = new boolean[user_id.length];
        
        Set<String> uniqueCombos = new HashSet<>(); // 정렬된 사용자명 조합 키로 중복 제거
        
        dfs(0, candidates, user_id, used, uniqueCombos);
        
        return uniqueCombos.size();
    }
    
    private void dfs(int idx,
                     List<List<Integer>> candidates,
                     String[] user_id,
                     boolean[] used,
                     Set<String> uniqueCombos) {
        if (idx == candidates.size()) {
            // used[]에서 선택된 사용자명만 뽑아 정렬 후 키 생성
            List<String> selected = new ArrayList<>();
            for (int i = 0; i < user_id.length; i++) {
                if (used[i]) selected.add(user_id[i]);
            }
            
            Collections.sort(selected);
            
            String key = String.join("|", selected); //조합만들기
            uniqueCombos.add(key);
            return;
        }

        for (int uIdx : candidates.get(idx)) {
            if (used[uIdx]) continue;     // 이미 사용한 사용자면 스킵
            used[uIdx] = true;
            dfs(idx + 1, candidates, user_id, used, uniqueCombos);
            used[uIdx] = false;
        }
    }
}
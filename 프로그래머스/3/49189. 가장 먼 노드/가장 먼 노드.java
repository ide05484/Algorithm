import java.util.*;
import java.io.*;

class Solution {
    
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        };
        
        for(int r = 0; r < edge.length; r++) {
            int start = edge[r][0];
            int end = edge[r][1];
            
            list.get(start).add(end);
            list.get(end).add(start);
        }
        
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{1, 0}); //노드 시작, 거리
        
        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int now = nowNode[0];
            int d = nowNode[1]; //지금거리
            
            if(dist[now] < d) continue; //더 최단거리가 있다면 빼고
            
            for(int next : list.get(now)) {
                if(dist[next] > d + 1) {
                    dist[next] = d + 1;
                    pq.add(new int[]{next, d + 1});
                }
            }
        }
        
        int max = 0;
        for(int i = 2; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(max == dist[i]) count++;
        }
        
        return count;
    }
}
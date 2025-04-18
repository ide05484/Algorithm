import java.util.*;
import java.io.*;

class Solution {
    
    static class Node{
        int start;
        int cost;
        
        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
    
    static ArrayList<ArrayList<Node>> list;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<Node>());
        }
        
        for(int f = 0; f < fares.length; f++) {
            int start = fares[f][0];
            int end = fares[f][1];
            int cost = fares[f][2];
            
            list.get(start).add(new Node(end, cost));
            list.get(end).add(new Node(start, cost));
        }
        
        // 2. 다익스트라 3회: s, a, b 각각에서
        int[] distS = dijkstra(s, n);
        int[] distA = dijkstra(a, n);
        int[] distB = dijkstra(b, n);
        
        // 3) 모든 k에 대해 최소 합승 비용 계산
        int answer = Integer.MAX_VALUE;
        
        for (int k = 1; k <= n; k++) {
            int total = distS[k] + distA[k] + distB[k];
            answer = Math.min(answer, total);
        }
        
        return answer;
    }
    
    public static int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[start] = 0; //시작점은 0
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.start]) continue;
            
            for(Node next : list.get(cur.start)) {
                int nCost = cur.cost + next.cost;
                if(nCost < dist[next.start]) {
                    dist[next.start] = nCost;
                    pq.add(new Node(next.start, nCost));
                }
            }
        }
        
        return dist;
    }
}
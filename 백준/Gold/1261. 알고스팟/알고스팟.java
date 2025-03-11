import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	
	static class Room implements Comparable<Room> {
		int r;
		int c;
		int cost;
		
		public Room(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Room o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//반대로 받았어야 했다!!!
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] spot = new int[N+1][M+1]; //1부터 시작
		
		for(int r = 1; r <= N; r++) {
			String str = br.readLine();
			for(int c = 1; c <= M; c++) {
				spot[r][c] = str.charAt(c - 1) - '0';
			}
		} //입력
		
		int[][] dist = new int[N+1][M+1];
		
		int INF = Integer.MAX_VALUE; //무한
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= M; c++) {
				dist[r][c] = INF;
			}
		}
		
		dist[1][1] = 0; //시작지점
		
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.offer(new Room(1, 1, 0));
		
		while(!pq.isEmpty()) {
			Room now = pq.poll();
			int nowR = now.r;
			int nowC = now.c;
			
			
			for(int d = 0; d < 4; d++) {
				int nextR = nowR + dr[d];
				int nextC = nowC + dc[d];
				
				if(nextR <= 0 || nextR > N || nextC <= 0 || nextC > M) continue;
				
				if(dist[nextR][nextC] > dist[nowR][nowC] + spot[nextR][nextC]) {
					dist[nextR][nextC] = dist[nowR][nowC] + spot[nextR][nextC];
					
					pq.offer(new Room(nextR, nextC, dist[nextR][nextC]));
				}
			}
		}
		
		System.out.println(dist[N][M]);
	}
}

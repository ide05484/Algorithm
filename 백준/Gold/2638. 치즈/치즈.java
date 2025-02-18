import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] paper;
	static int N, M;
	
	static boolean[][] visit;

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		paper = new int[N][M]; // 모눈종이

		int count = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < M; c++) {
				paper[r][c] = Integer.parseInt(st.nextToken());

				if (paper[r][c] == 1) count++; // 치즈크기
			}
		} // 입력
		

		int time = 0;

		// 치즈가 없어질 때까지
		while (count != 0) {
			
			visit = new boolean[N][M]; //방문 초기화
			dfs(0, 0); //외부공기

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					
					if(paper[r][c] == 1 && isMelting(r, c)) {
						paper[r][c] = 0;
						count--;
					}
				}
			}
			
			time++;
		}
		
		System.out.println(time);
	}
	
	private static void dfs(int r, int c) {
		visit[r][c] = true;
		paper[r][c] = 2; //외부공기
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || paper[nr][nc] == 1 || visit[nr][nc]) continue;
			
			dfs(nr, nc);
		}
	}

	//녹을 수 있는 치즈 가장자리인가
	private static boolean isMelting(int r, int c) {
		
		int count = 0;
		
		for(int d = 0; d < 4; d++) {
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			
			if(paper[nr][nc] == 2) count++;
		}
		
		if(count >= 2) return true;
		
		return false;
	}
}

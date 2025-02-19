import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[][] grid;
	static boolean[][] visit;
	
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int countRedGreen, count;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		grid = new int[N][N];
		
		for(int r = 0; r < N; r++) {
			String str = br.readLine();
			
			for(int c = 0; c < N; c++) {
				grid[r][c] = str.charAt(c);
			}
		}
	
		countRedGreen = 0;
		visit = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					dfsRedGreen(r,c);
					countRedGreen++;
				}
			}
		}
	
		count = 0;
		visit = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(!visit[r][c]) {
					dfs(r,c);
					count++;
				}
			}
		}
		
		System.out.println(count + " " + countRedGreen);
		
	}
	
	//적록색약이 아닌 사람
	private static void dfs(int r, int c) {
		
		visit[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc] || grid[r][c] != grid[nr][nc]) continue;
			
			dfs(nr, nc);
			
		}
	}
	
	//적록색약인 사람
	private static void dfsRedGreen(int r, int c) {
		visit[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc]) continue;
			
			if((grid[r][c] == 'R' || grid[r][c] == 'G') && (grid[nr][nc] == 'R' || grid[nr][nc] == 'G')) {
				dfsRedGreen(nr, nc);
			} else if(grid[r][c] == 'B' && grid[nr][nc] == 'B') {
				dfsRedGreen(nr, nc);
			}
		}
	}
}
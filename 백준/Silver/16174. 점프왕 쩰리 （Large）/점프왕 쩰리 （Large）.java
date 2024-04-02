import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] game;
	static int N;
	static int count;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 구역의 크기
		game = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int c = 0; c < N; c++) {
				game[r][c] = Integer.parseInt(st.nextToken()); // 받아줌
			}
		}

        visit = new boolean[N][N]; //방문체크배열
		count = 0;
		DFS(0, 0); // 시작좌표
		
		String answer = "Hing";

		if (count != 0) {
			answer = "HaruHaru"; //하나라도 갈 길이 있는 거
		}
		
		System.out.println(answer);

	}

	private static void DFS(int r, int c) {

		// 경계를 벗어나면 return + 방문한 곳이면 리턴
		if (r >= N || c >= N || game[r][c] == 0 || visit[r][c]) {
			// 젤 끝
			return;
		}
		
		if (r == N - 1 && c == N - 1) {
			count++; // 되는 경우의 수
			return;
		}
		
		visit[r][c] = true;

		// 아래로 이동
		DFS(r + game[r][c], c);
		// 오른쪽으로 이동
		DFS(r, c + game[r][c]);
	}
}
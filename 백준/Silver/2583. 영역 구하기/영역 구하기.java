import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int M, N, width; // 면적 width
	static int[][] paper;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // R
		N = Integer.parseInt(st.nextToken()); // C
		int K = Integer.parseInt(st.nextToken()); // 사각형 개수

		paper = new int[M][N];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());

			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());

			for (int r = startR; r < endR; r++) {
				for (int c = startC; c < endC; c++) {// 좌표와 배열 좌표는 1개씩 차이난다
					paper[r][c]++;
				}
			}
		}
		
//		for (int r = 0; r < M; r++) {
//			for (int c = 0; c < N; c++) {
//				System.out.print(paper[r][c] + " ");
//			}
//			System.out.println();
//		}

		int count = 0;
		List<Integer> list = new ArrayList<>(); // 영역
		visit = new boolean[M][N]; // 방문체크배열

		// 좌표 체크 다함
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (paper[r][c] == 0 && !visit[r][c]) { // 아무 영역도 색칠 안된거
					width = 0;
					DFS(r, c);
					count++;
					list.add(width);
				}
			}
		}
		
		System.out.println(count);
		
		StringBuilder sb = new StringBuilder();
		
		Collections.sort(list);//오름차순 정렬
		
		for(int num : list) {
			sb.append(num).append(" ");
		}
		
		System.out.println(sb);

	}

	private static void DFS(int r, int c) {
		if (r < 0 || r >= M || c < 0 || c >= N || paper[r][c] != 0) //범위벗어나면
			return;

		if (!visit[r][c]) {
			// 방문안한 곳이라면

			visit[r][c] = true; // 방문쳌
			width++;
			
			for (int d = 0; d < 4; d++) {
				DFS(r + dr[d], c + dc[d]); //탐색
			}
		}
	}
}
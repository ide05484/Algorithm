import java.util.*;
import java.io.*;

public class Main {

	static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 칸 수

		int[][] game = new int[N][3];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < 3; c++) {
				game[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 완

		int max = 0;
		int min = 9 * N; // 최대값

		// 시작점
		int[][] maxScore = new int[N][3]; // 최대
		int[][] minScore = new int[N][3]; // 최소

		for (int n = 0; n < 3; n++) {
			maxScore[0][n] = game[0][n];
			minScore[0][n] = game[0][n];
		}

		for (int r = 1; r < N; r++) {
			
			//0인 줄
			maxScore[r][0] = Math.max(maxScore[r-1][0], maxScore[r-1][1]) + game[r][0];
			minScore[r][0] = Math.min(minScore[r-1][0], minScore[r-1][1]) + game[r][0];
			
			//중간
			maxScore[r][1] = Math.max(maxScore[r-1][0], Math.max(maxScore[r-1][2], maxScore[r-1][1])) + game[r][1];
			minScore[r][1] = Math.min(minScore[r-1][0], Math.min(minScore[r-1][2], minScore[r-1][1])) + game[r][1];
			
			//제일 끝쪽
			maxScore[r][2] = Math.max(maxScore[r-1][2], maxScore[r-1][1]) + game[r][2];
			minScore[r][2] = Math.min(minScore[r-1][2], minScore[r-1][1]) + game[r][2];
		}
		
		for(int c = 0; c < 3; c++) {
			max = Math.max(max, maxScore[N-1][c]);
			min = Math.min(min, minScore[N-1][c]);
		}
		
		System.out.println(max + " " + min);
	}
}
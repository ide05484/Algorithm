import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열크기
		int[][] arr = new int[N + 1][N + 1]; // 배열
		int[][] find = new int[N + 1][N + 1]; // 누적배열

		int M = Integer.parseInt(st.nextToken()); // 합횟수

		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()); // 배열받음
			}
		}

		for (int r = 0; r < N + 1; r++) {
			int sum = 0;
			for (int c = 0; c < N + 1; c++) {
				sum += arr[r][c];
				find[r][c] = sum; // 해당 행만 누적해주자
			}
		}
		
		StringBuilder sb = new StringBuilder();

		for (int m = 0; m < M; m++) {
			
			int answer = 0;
			
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken()); // 좌표받아줌

			for (int r = x1; r <= x2; r++) { // 행
				answer += find[r][y2] - find[r][y1 - 1];
			}

			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}

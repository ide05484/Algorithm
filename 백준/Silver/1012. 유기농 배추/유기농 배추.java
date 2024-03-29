import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] field;
	static int M, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 갯수

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이

			field = new int[M][N]; // 배추밭

			int K = Integer.parseInt(st.nextToken()); // 배추위치개수

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());

				int r = Integer.parseInt(st.nextToken()); // 행
				int c = Integer.parseInt(st.nextToken()); // 열

				field[r][c] = 1; // 해당 위치 있음 표시
			}

			int whiteWorm = 0; // 필요한 배추흰지렁이

			// 배열을 돌면서 해당 인덱스와 인접한 배추덩이? 갯수를 찾는다.
			for (int r = 0; r < M; r++) {
				for (int c = 0; c < N; c++) {
					if (field[r][c] == 1) { // 심은 곳인데 방문을 안했다면 ? 나와 연결된 애들을 찾아줘~~
						// 검사가즈아
						DFS(r, c); // 해당 좌표를 넘겨서 탐색
						whiteWorm++; // 한마리 필요
					}
				}
			}

			sb.append(whiteWorm + "\n");
		} // 테케

		System.out.println(sb);
	}

	private static void DFS(int r, int c) {

		if (r < 0 || r >= M || c < 0 || c >= N) {
			return; // 밤위벗어나면 나와
		}

		if (field[r][c] == 0) {
			return; // 배추가 아니면 되돌아가
		}

		field[r][c] = 0;// 그냥 0으로 만드러주자

		// 행우선순회라서 위와 왼쪽은 탐색할 필요가 x
		DFS(r + 1, c); // 아래탐색
		DFS(r, c + 1); // 오른쪽탐색
		DFS(r - 1, c); // 위탐색
		DFS(r, c - 1); // 왼쪽 탐색
	}
}
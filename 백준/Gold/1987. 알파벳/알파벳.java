import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][] board;
	static boolean[][] visit; // 방문체크
	static HashSet<Character> list;

	static int maxCnt;

	// 탐색할 델타배열
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		board = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine(); // 한줄씩 받기
			for (int c = 0; c < C; c++) {
				board[r][c] = str.charAt(c); // 하나씩 넣어줘 넣어줘
			}
		}

		visit = new boolean[R][C]; // 방문체크체크
		list = new HashSet<>(); // 방문한 길 넣어줄 것
		// 0,0부터 시작해서 같은 알파벳이 적힌 칸을 두 번 지날 수 없도록 체크해줘야해
		maxCnt = 0;
		DFS(0, 0, 1);

		System.out.println(maxCnt);
	}

	private static void DFS(int r, int c, int count) {

//		if (!check(r, c)) { // 만약 더이상 갈 수 있는 곳이 없다면 멈춰줘
		maxCnt = Math.max(maxCnt, count);
//			return;
//		}

		visit[r][c] = true;
		// 해당 자리를 어디 넣어줘야해
		list.add(board[r][c]); // 보드 자리 글자를 넣어줘

		// 더 이상 갈 수 있는 곳이 있다면 가자가자
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			
			if (!visit[nr][nc] && !check(nr, nc)) {
				// 범위 안이고, 방문하지 않았다면 가자
				DFS(nr, nc, count + 1);
			}
		}

		visit[r][c] = false; // 여기에 온다는 것은 DFS를 다 돌고 뒤로 돌아가겠다는 뜻...
		list.remove(board[r][c]);
	}

	private static boolean check(int r, int c) {

		if (list.contains(board[r][c])) { // 글자가 같아?
			return true;
		}
		// 만약에 걸리지 않고 잘 나왔다면 통과통과
		return false;
	}

}
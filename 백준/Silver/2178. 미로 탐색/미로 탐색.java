import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] maze;
	static int N, M;
	static boolean[][] visit;

	// 미로탐색할 델타배열
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행 갯수
		M = Integer.parseInt(st.nextToken()); // 열 갯수

		maze = new int[N][M]; // 미로배열

		for (int r = 0; r < N; r++) {
			String str = br.readLine();
			for (int c = 0; c < M; c++) {
				maze[r][c] = str.charAt(c) - '0';
			}
		} // 미로 배열은 받아줌!

		visit = new boolean[N][M]; // 방문배열
		BFS(0, 0);

		System.out.println(maze[N - 1][M - 1]); //도착지점에서의 거리값

	}//main끝

	private static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		// 좌표를 배열에 담아서 저장
		int[] here = new int[2];
		here[0] = r;
		here[1] = c;

		queue.add(here);
		visit[r][c] = true; // 방문했으니까
		int count = 1; // 1부터시작!

		while (!queue.isEmpty()) {
			int now[] = queue.poll(); // 지금 좌표 가져와!
			for (int i = 0; i < 4; i++) { // 델타탐색
				if (now[0] + dr[i] >= 0 && now[0] + dr[i] < N && now[1] + dc[i] >= 0 && now[1] + dc[i] < M) {
					// 범위안에서
					if (!visit[now[0] + dr[i]][now[1] + dc[i]] && maze[now[0] + dr[i]][now[1] + dc[i]] == 1) {
						// 방문하지 않았고 갈 수 있는 길이라면?
						int[] next = { now[0] + dr[i], now[1] + dc[i] }; // 고 좌표를 넣어주자
						queue.add(next);
						maze[now[0] + dr[i]][now[1] + dc[i]] = maze[now[0]][now[1]] + 1; // 거기 거리 ++해줘
						visit[now[0] + dr[i]][now[1] + dc[i]] = true; // 방문처리~~
					}
				}
			}
		} //bfs의 queue돌기 끝
	} //bfs 끝
}
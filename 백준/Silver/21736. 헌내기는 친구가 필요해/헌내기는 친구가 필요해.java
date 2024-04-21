import java.util.Scanner;

public class Main {

	static char[][] campus;
	static int N, M; // 캠퍼스 크기와 내 위치
	static int count; // 만나는 사람
	static boolean[][] visit; // 방문했나요

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 }; // 델타탐색

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 캠퍼스 행
		M = sc.nextInt(); // 캠퍼스 열

		campus = new char[N][M];

		int R = 0;
		int C = 0;
		// 헌내기의 위치

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				campus[r][c] = str.charAt(c);

				if (campus[r][c] == 'I') {
					R = r;
					C = c;
				}
			}
		}

		visit = new boolean[N][M];

		count = 0;
		DFS(R, C);
		
		if(count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	private static void DFS(int R, int C) {
		if (R < 0 || R >= N || C < 0 || C >= M || campus[R][C] == 'X') {
			return; //범위벗어나면 안되고 벽이어도 안 됨
		}
		
		if(!visit[R][C]) {
			//지금자리가 방문한게 아니라고?
			visit[R][C] = true; //방문처리하고
			
			if(campus[R][C] == 'P') {
				count++; //사람을 만난거면 카운트 해줘
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = R + dr[d];
				int nc = C + dc[d];
				
				DFS(nr,nc);
			}
		}
	}
}
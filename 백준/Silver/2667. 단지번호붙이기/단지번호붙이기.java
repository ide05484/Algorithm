import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 지도크기
		map = new int[N][N]; // 지도배열

		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		} // 아파트 지도 받아줌

		List<Integer> list = new ArrayList<>(); // 정답을 출력할 배열
		// 몇동까지 나올지 모르니까~~~
		visit = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1 && !visit[r][c]) { // 아파트가 있는 곳이면! + 방문안한곳이라면~
					count = 0; // 초기화해주고
					DFS(r, c); // 어디까지 이어져있나 봐줘잉
					list.add(count); // 다 돌고 나왔다면? 그 갯수를 넣어줘(동의 갯수)
				}
			}
		}
		
		System.out.println(list.size()); //총 단지수는 여기에
		//오름차순으로 출력해야함
		Collections.sort(list);
		
		for (int how : list) {
			System.out.println(how);
		}

	}

	private static void DFS(int r, int c) {

		if (r < 0 || r >= N || c < 0 || c >= N || visit[r][c]) {
			// 범위를 벗어나거나 방문한 곳이라면?
			return;
		}

		if (map[r][c] == 1) { //거기 동수가 있을때만
			visit[r][c] = true; // 방문처리해줘잉
			count++; //단지수 ++

			DFS(r + 1, c);
			DFS(r - 1, c);
			DFS(r, c - 1);
			DFS(r, c + 1);
		}
	}
}

import java.util.Scanner;

public class Main {

	static int answer; // 연결갯수 구하는 거

	static int N;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수

		arr = new int[N + 1][N + 1]; // 간선정보를 담을 배열

		for (int m = 0; m < M; m++) {

			int start = sc.nextInt(); // 시작점
			int end = sc.nextInt(); // 끝점

			arr[start][end] = arr[end][start] = 1; // 무방향 그래프니까~ 양방향 다 표시표시
		}

		visit = new boolean[N + 1];

		answer = 0; // 초기화
		for (int i = 1; i < N + 1; i++) {
			if (!visit[i]) {
				DFS(i); // 모든 번호에 연결된 것을 찾는거임!!
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static void DFS(int v) {
		// 나 방문처리 해줘
		visit[v] = true;

		for (int i = 1; i <= N; i++) {
			if (!visit[i] && arr[v][i] == 1) {
				// 방문 안한 곳중에 연결이 되어 있다면???
				DFS(i); // 계속 타고 가
			}
		}
	}
}
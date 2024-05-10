import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, K, X;
	static ArrayList<Integer>[] city;
	static List<Integer> answer; // 답
	static boolean[] visit; // 방문쳌

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 도시의 개수
		M = sc.nextInt(); // 도로의 개수
		K = sc.nextInt(); // 거리 정보
		X = sc.nextInt(); // 출발도시

		city = new ArrayList[N + 1]; // 1번부터 시작

		for (int n = 1; n <= N; n++) {
			city[n] = new ArrayList<>(); // 초기화
		}

		for (int m = 0; m < M; m++) {
			// 도로개수만큼
			int start = sc.nextInt();
			int end = sc.nextInt();

			city[start].add(end); // 추가 방향성있음
		}

		answer = new ArrayList<>();
		visit = new boolean[N + 1];

		BFS();

		Collections.sort(answer); // 오름차순

		if (answer.size() == 0) {
			// 같은 거리가 없다면
			System.out.println(-1);
		} else {
			// 그거리의 도시가 있다면
			for (int num : answer) {
				System.out.println(num);
			}
		}

	}

	private static void BFS() {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(X);

		int dist = 0;

		while (!queue.isEmpty() && dist <= K) {

			int size = queue.size(); // 현재 큐 사이즈

			if (size == 0)
				break; // 없으면 멈춰

			if (dist == K) {
				// 같다면 지금 들어가있는거 모두 넣어줘
				while(!queue.isEmpty()) {
					int num = queue.poll();
					
					if(!visit[num]) {
						answer.add(num);
						visit[num] = true;
					}
				}
				
				break;
			}
			
			for (int s = 0; s < size; s++) {

				int curr = queue.poll();
				// 하나 꺼내서
				visit[curr] = true;

				for (int i = 0; i < city[curr].size(); i++) {

					if (!visit[city[curr].get(i)]) {
						queue.add(city[curr].get(i));
					}
				}
			} // 사이즈만큼 돌아

			dist++;
		}
	}
}
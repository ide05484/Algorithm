import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수

		List<Integer> graph[] = new ArrayList[N + 1];
		int[] degree = new int[N + 1]; // 진입차수 저장

		for (int n = 1; n <= N; n++) {
			graph[n] = new ArrayList<Integer>();
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			degree[end]++; // 진입차수 증가증가
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				// 연결 안된 애들 중 키 젤 작은애들 넣어
				queue.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!queue.isEmpty()) {
			int curr = queue.poll(); // 지금꺼 꺼내줘잉
			sb.append(curr + " ");

			for (int now : graph[curr]) {
				degree[now]--; // 뺄꺼니까 하나씩 뺴
				if (degree[now] == 0)
					queue.offer(now); // 그거 다시 넣어줘
			}
		} // 큐가 빌때까지 (모든 그래프 다돌기

		System.out.println(sb);
	}
}
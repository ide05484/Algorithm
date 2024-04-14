import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int v, w;

		public Node(int v, int w) {
			this.v = v; // 도착점
			this.w = w; // 비용
		}
	}

	static int V, E, K; // 정점개수, 간선개수, 시작번호 // 1번부터 V번까지
	static List<Node>[] list; // 인접리스트
	static int[] cost; // 거기까지의 최소비용

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점개수
		E = Integer.parseInt(st.nextToken()); // 간선개수
		K = Integer.parseInt(br.readLine()); // 시작점

		list = new ArrayList[V + 1]; // V개의 연결리스트

		for (int v = 0; v < V + 1; v++) {
			list[v] = new ArrayList<>();
		} // 초기화

		cost = new int[V + 1]; // 그 도시까지의 비용
		Arrays.fill(cost, Integer.MAX_VALUE); // 일단 최대로 채워놔

		for (int e = 1; e <= E; e++) { // 간선받아줌
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[s].add(new Node(x, c));
		} // 입력완

		dijkstra(K);

		StringBuilder sb = new StringBuilder();

		for (int c = 1; c <= V; c++) {
			if (cost[c] == Integer.MAX_VALUE) {
				sb.append("INF" + "\n");
				continue;
			}
			sb.append(cost[c] + "\n");
		}

		System.out.println(sb);

	}

	private static void dijkstra(int start) {
		boolean[] visit = new boolean[V + 1]; // 방문체크
		cost[K] = 0; // 시작점은 0으로

		for (int e = 0; e < V - 1; e++) {
			int min = Integer.MAX_VALUE; // 최소값
			int idx = -1; // 절대 안나올 숫자로

			for (int i = 1; i < V + 1; i++) {
				// 모든 노드를 돌면서
				if (!visit[i] && min > cost[i]) {
					// 방문하지 않았고, 최소값을 그 비용으로 해주셈
					min = cost[i];
					idx = i;
				}
			}

			if (idx == -1) {
				// idx가 갱신 안된건 연결된 애가 없다는 뜻
				break;
			}

			visit[idx] = true; // 갱신된 애라면 방문체크하고

			for (Node node : list[idx]) {
				// 그 idx를 시작점으로 연결된 또 다른 노드 검색
				if (!visit[node.v] && cost[node.v] > cost[idx] + node.w) {
					// 그 idx에 연결된 애가 방문하지 않았던 노드이고, 지금 비용이 (그전+지금추가될 비용)보다 크다면?
					// 최소값을 갱신해줘야 맞겟지?
					cost[node.v] = cost[idx] + node.w;
				}
			}
		} // 모든 간선 다돔
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> { // 간선들의 정보
		int start;
		int end;
		int weight; // 가중치

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		} // 가중치 기준으로 정렬할게
	}

	static int[] top; // 대표 저장해줘

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		Edge[] tree = new Edge[E];

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			tree[e] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		} // 입력받아줘

		Arrays.sort(tree); // 정렬해야함! 최소로 모든 정점지나기(크루스칼)

		top = new int[V+1]; // V-1개 간선뽑기(연결됐을 때 대표를 바꿔줘야함)
		//1번부터 V번까지 잇으니까 하나 더 더해줘

		for (int v = 0; v < V; v++) {
			top[v] = v;
		} // 시작할때 연결해주지 않아서 본인은 본인이 대표!

		int cost = 0; // 최소가중치
		int count = 0; // 간선개수 뽑기

		for (int i = 0; i < E; i++) { // 주어진 간선을 다 돌면서 대표를 뽑아주자잉
			// 해당 간선의 시작과 끝으로 대표를 뽑아서
			int topX = findset(tree[i].start);
			int topY = findset(tree[i].end);

			// 같지않으면 합쳐줘
			if (topX != topY) {
				union(topX, topY);
				cost += tree[i].weight; // 해당 무게 더해주고
				count++; // 간선 하나 선택쓰키
			}

			if (count == V - 1) // 최소 간선개수만큼 봅으면 멈춰줘잉
				break;
		}
		
		System.out.println(cost);
	}

	// 합쳐줘 대표 하나만들어줘
	private static void union(int topX, int topY) {
		top[topY] = topX; //왼쪽으로 통일해주자
	}

	// 대표찾아
	private static int findset(int here) {

		if (here != top[here]) {
			// 내 대표가 내가 아니라면
			top[here] = findset(top[here]); //타고 가서 걔 대표도 알아내 //연결되어있으니가
		} 
		
		return top[here]; // 만약에 나랑 대 대표가 같은 애를 만나잖아? 바로 그 대표로 바꿔 왜냐면 연결되서 올라갔을 때 가장 큰 대표니가
	}
}
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] graph;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		int M = sc.nextInt(); // 간선의 개수
		int V = sc.nextInt(); // 탐색할 정점의 번호

		graph = new int[N + 1][N + 1]; // 1부터 시작

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt(); //시작정점
			int end = sc.nextInt(); //끝정점
			
			graph[start][end] = graph[end][start] = 1; //그래프 연결해주기
		}

		visit = new boolean[N + 1]; // 방문체크
		DFS(V);
		System.out.println(); // 한줄 줄바꿈
		visit = new boolean[N + 1]; // 방문체크 -- 다시 초기화해줘야함!
		BFS(V);
	}

	private static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>(); //bfs는 큐를 이용해서 이용한다.
		
		queue.add(v); //시작점을 넣어줘~
		visit[v] = true; //방문처리
		
		//큐가 빌때까지 하나씩 뽑아줘
		while(!queue.isEmpty()) {
			int curr = queue.poll(); //하나를 꺼내줘요
			System.out.print(curr+ " "); //지금 들어온 애 찍어줘요
			
			for(int i = 1; i < N+1; i++) {
				if(!visit[i] && graph[curr][i] == 1) { //방문하지 않고 나랑 연결되어 있는 곳으로 가
					queue.add(i); //연결되어 있는애를 추가해줘
					visit[i] = true; //방문한걸로 쳐
				}
			}
		}
	}

	private static void DFS(int v) {
		visit[v] = true; //방문했어
		System.out.print(v + " ");
		
		for(int i = 1; i < N+1; i++) {
			if(!visit[i] && graph[v][i] == 1) { //방문하지 않았고, 나랑 연결되어 있다면 가죠
				DFS(i);
			}
		}
	}
}
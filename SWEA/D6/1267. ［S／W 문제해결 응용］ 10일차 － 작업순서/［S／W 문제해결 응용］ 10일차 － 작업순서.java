import java.util.Scanner;
import java.util.Stack;

public class Solution {

	static int V, E;
	static int[][] arr;
	static int[] degree;
	static boolean[] visited;
	static Stack<Integer> stack; // 할일 담을 스택

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			V = sc.nextInt(); // 정점의 개수
			E = sc.nextInt(); // 간선의 개수

			arr = new int[V + 1][V + 1];
			degree = new int[V + 1];
			visited = new boolean[V + 1];
			stack = new Stack<>();
			
			int[] tmp = new int[2*E]; //간선을 입력받을 배열
			
			for (int e = 0; e < 2 * E; e++) {
				tmp[e] = sc.nextInt();
			} // 간선정보 입력 받음

			for (int e = 0; e < 2 * E; e += 2) { // 0부터 2씩 증가 (이게 시작점)
				int start = tmp[e];
				int end = tmp[e + 1];

				arr[start][end] = 1; // 가중치가 없고, 방향이 정해져 있으니까
				degree[end]++; // 그리고 진입되고 있으니까 +1해준다
			}
			
			for(int i = 1; i < V+1; i++) {
				if(degree[i] == 0) { //진입차수가 0부터
					DFS(i);//거기서부터 DFS
				}
			}
			
			System.out.print("#"+tc+" ");
			
			while (!stack.isEmpty()) { 
				//빌때까지 뺴줘
				System.out.print(stack.pop() + " ");
			}
			

		} // 테케 마감
	}// main 마감

	static void DFS(int v) {
		visited[v] = true; // 방문체크
		
		for (int i = 1; i < V + 1; i++) {
			if(arr[v][i] == 1 && !visited[i]) { //인접해있고 방문하지 않았다면?
				DFS(i);
			}
		}
		stack.add(v); //오케이 다 돌았으니까 넣어주셈
	}
}
import java.util.Scanner;

public class Main {
	
	static int[][] com; //컴퓨터 배열
	static int N; //전체 컴퓨터
	static boolean[] visit; //방문체크할 배열이 필요
	static int count; //감염되는 컴퓨터수
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //컴퓨터의 수
		int M = sc.nextInt(); //연결된 컴퓨터의 쌍
		
		com = new int[N+1][N+1]; //컴퓨터는 1번부터 시작이다
		
		for(int m = 0; m < M; m++) {
			int start = sc.nextInt(); //시작점
			int end = sc.nextInt(); //끝점
			
			com[start][end] = com[end][start] = 1; //무방향 그래프니까 연결해줘
		}
		
		visit = new boolean[N+1]; //1번부터 시작이니까
		count = 0;
		
		DFS(1); //1번 컴퓨터부터 검사
		
		System.out.println(count-1); //1번컴퓨터는 포함하지 않는다.
	}

	private static void DFS(int num) {
		visit[num] = true; //방문표시
		count++; //방문했으니 1개 세어줘
		
		for(int i = 1; i < N+1; i++) {
			if(!visit[i] && com[num][i] == 1) { //방문하지 않았고, 연결되어있다면
				DFS(i); //거기를 다시 타고가요~~
			}
		}
	}
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static List<Integer>[] friend;
	static int N, M;
	static boolean[] visit;
	static int answer;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //사람수
		M = sc.nextInt(); //관계수
		
		friend = new ArrayList[N]; //인접리스트 ArrayList 배열
		
		for(int n = 0 ; n<N; n++) {
			friend[n] = new ArrayList<>();
		}//초기화작업

		
		for(int m = 0; m < M; m++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			//시작과 끝 받기
			
			friend[start].add(end);
			friend[end].add(start);
			//방향없는 그래프니까
		}
		
		for(int n = 0; n < N; n++) {
			visit = new boolean[N];
			answer = 0; //답
//			System.out.println(n + " :시작노드");
			DFS(n, 0); //시작점부터 돈다
			if(answer == 1)
				break;
			//if를 넣었는데 되네요 근데 answer가 왜 1로 나오는지를 모르겟슈...
		}
		
		System.out.println(answer);
	}

	private static void DFS(int start, int cnt) {
		if(cnt >= 4) {
			answer = 1;
			return;
			//5개 연결되어 있으면 더 볼 필요 없음!
		}
		
		visit[start] = true;
		//일단 방문처리
		
//		System.out.println(start + " "+cnt);
		
		for(int i = 0; i < friend[start].size(); i++) {
			//연결된 노드들을 돌면서
			if(!visit[friend[start].get(i)]) {
				//그 연결된 노드를 방문하지 않았을 때
				DFS(friend[start].get(i), cnt+1); //다시탐색들어가고
			}
		}
        visit[start] = false; //원복은 왜해주나요

	}
}
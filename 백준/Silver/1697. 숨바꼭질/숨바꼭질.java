import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 수빈이가 있는 위치
		int K = sc.nextInt(); // 동생이 있는 위치

		Queue<int[]> queue = new LinkedList<>(); // BFS를 하기 위함
		boolean[] visit = new boolean[100001];
		int[] here = { N, 0 };
		queue.add(here); // 시작점 넣기

		int time = 0;

		while (!queue.isEmpty()) {
			
			int[] curr = queue.poll();

			if(curr[0] >= 100001 || curr[0] < 0) continue; //범위벗어나면 가
			
			if(visit[curr[0]]) continue; //방문했으면 가
			
			visit[curr[0]] = true; //방문안했으면 바꿔줘

			if (curr[0] == K) {
				time = curr[1];
				break;
			}
			
			int[] next1 = { curr[0] + 1, curr[1] + 1 };
			queue.add(next1);

			int[] next2 = { curr[0] - 1, curr[1] + 1 };
			queue.add(next2);

			int[] next3 = { curr[0] * 2, curr[1] + 1 };
			queue.add(next3);
		}

		System.out.println(time);
	}

}
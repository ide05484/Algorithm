import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 과목의 수
		int M = sc.nextInt(); // 선수조건의 수

		int[][] arr = new int[N + 1][N + 1]; // 인접행렬
		int[] degree = new int[N + 1]; // 진입차수

		for (int m = 0; m < M; m++) {
			int start = sc.nextInt(); // 시작
			int end = sc.nextInt(); // 끝

			arr[start][end] = 1; // 방향있는 가중치 없는 그래프
			degree[end]++; // 진입차수 ++
		}

		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> tmp = new LinkedList<>();

		int[] answer = new int[N + 1]; // 정답 출력배열
		int count = 1; // 시작학기
		
//		System.out.println(Arrays.toString(degree));

		for (int i = 1; i < N + 1; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				// 요 애들은 1학기
				answer[i] = count;
			}
		}
		
		while (true) {
			
			if(queue.isEmpty()) break;
			
			count++;
			
			while (!queue.isEmpty()) {
				int curr = queue.poll(); // 하나꺼내서
				
				for (int i = 1; i < N + 1; i++) {
					if (arr[curr][i] == 1) { // 연결되어 있으면
						degree[i]--; // 진입경로를 자르고
						if (degree[i] == 0) { // 0이 될때 넣어줘~
							tmp.offer(i);
							answer[i] = count; // 그러면 그 때 얘네가 다음학기인거야~
						}
					}
				}
			}
			
			while (!tmp.isEmpty()) {
				queue.offer(tmp.poll());
			}
			
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
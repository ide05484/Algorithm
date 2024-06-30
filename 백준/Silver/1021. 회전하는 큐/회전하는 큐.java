import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑아내려는 수의 크기

		int[] select = new int[M]; // 뽑아내는 배열

		for (int m = 0; m < M; m++) {
			select[m] = sc.nextInt(); // 뽑아내려는 idx 위치 0번째 는 첫번째로 본다
		}

		LinkedList<Integer> queue = new LinkedList<>();// 큐

		for (int i = 1; i <= N; i++) {
			queue.add(i);// 1부터 N까지 넣어둠 = 그것이 곧 해당 idx
		}

		int count = 0; // 회전수

		for (int m = 0; m < M; m++) {
			int target = queue.indexOf(select[m]); // 뽑아야할 위치

			int halfIdx = 0;

			if (queue.size() % 2 == 0) {
				// 사이즈가 짝수개일때
				halfIdx = queue.size() / 2 - 1;
			} else {
				// 사이즈가 홀수개일때
				halfIdx = queue.size() / 2;
			}

			if (target <= halfIdx) {
				// 뽑는 인덱스가 반보다 앞에 있으면 왼쪽으로 돌리는게 나음
				for (int i = 0; i < target; i++) {
					int tmp = queue.pollFirst(); // 하나씩 빼
					queue.addLast(tmp);
					count++;
				}
			} else {
				// 그게 아니라면 역순으로 돌리는게 나음
				for (int i = target; i < queue.size(); i++) {
					int tmp = queue.pollLast();
					queue.addFirst(tmp);
					count++;
				}
			}

			queue.pollFirst(); // target을 제거

		} // 모든 타겟 제거

		System.out.println(count);

	}
}
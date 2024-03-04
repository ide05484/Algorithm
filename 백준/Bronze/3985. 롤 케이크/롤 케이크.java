import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt(); // 롤케이크 길이
		int[] rollcake = new int[L + 1]; // 0번인덱스까지 포함

		int N = sc.nextInt(); // 방청객 수
		int[] eatCake = new int[N]; // 먹을걸로 예상되는 배열
		int[] realeat = new int[N]; // 진짜먹는 배열

		for (int i = 0; i <= L; i++) {
			rollcake[i] = 1; // 무조건 1명만 먹을 수 있다.
		}

		int max1 = 0; // 먹는 롤케잌 최대값
		int idx1 = 0; // 방청객 번호
		int max2 = 0; // 실제로 먹는 롤케잌 최대
		int idx2 = 0; // 그 번호값

		for (int i = 0; i < N; i++) {
			// 중복되면 적은 번호를 출력해야해서 거꾸로
			int P = sc.nextInt(); // 시작 인덱스
			int K = sc.nextInt(); // 끝 인덱스

			// i번째 사람이 먹을
			eatCake[i] = K - P + 1; // 가장 많이 먹을 것으로 예상되는 케이크양
			max1 = Math.max(max1, eatCake[i]); // 비교해서 맥스값

			// 실제로 먹는 거는 롤케이크에서 1씩 배봄
			for (int j = P; j <= K; j++) {
				realeat[i] += rollcake[j];
				rollcake[j]--;
			}
			max2 = Math.max(max2, realeat[i]);
		}
		
		//적은 인덱스를 갱신해주기 위함
		for(int i = N-1; i>=0; i--) {
			if(max1 == eatCake[i]) {
				idx1 = i+1;
			}
			if(max2 == realeat[i]) {
				idx2 = i+1;
			}
		}

		System.out.println(idx1);
		System.out.println(idx2);

	}
}

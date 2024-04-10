import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			// 받을 배열 갯수
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 배열 두개
			int[] arrN = new int[N];
			int[] arrM = new int[M];

			// 배열에 숫자 받아줌
			for (int n = 0; n < N; n++) {
				arrN[n] = sc.nextInt();
			}
			// 배열에 숫자 받아줌
			for (int m = 0; m < M; m++) {
				arrM[m] = sc.nextInt();
			}

			int max = 0; // 곱의 최대를 구해야함

			// N이 M보다 작을 대
			if (N <= M) {
				// N크기만큼 뺏을 때까지의 인덱스까지 갈수 있음
				for (int i = 0; i <= M - N; i++) { // M배열의 인댁스값
					int sum = 0; // 곱의 합 구하기 위함 //초기화를 위해 이 위치에 존재
					for (int j = 0; j < N; j++) { // N배열의 인덱스 값
						sum += arrN[j] * arrM[j + i]; // i만큼 더해서 한칸씩 이동
					}
					max = Math.max(max, sum); // 합의 max값 갱신
				}
			} else { //M이 작을때
				// N크기만큼 뺏을 때까지의 인덱스까지 갈수 있음
				for (int i = 0; i <= N-M; i++) { // M배열의 인댁스값
					int sum = 0; // 곱의 합 구하기 위함
					for (int j = 0; j < M; j++) { // N배열의 인덱스 값
						sum += arrM[j] * arrN[j + i]; // i만큼 더해서 한칸씩 이동
					}
					max = Math.max(max, sum); // 합의 max값 갱신
				}
			}
			
			System.out.println("#" + tc + " " + max);
		} // 테케 마감
	}// main마감
}
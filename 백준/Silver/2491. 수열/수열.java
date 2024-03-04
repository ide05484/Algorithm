import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 배열길이
		int[] arr = new int[N]; // 배열

		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt(); // 배열에 넣어줌
		}
		
		int max = 1; //정답
		
		int countUp = 1; // 오름차순 세기
		
		for (int n = 0; n < N - 1; n++) {
			if (arr[n] <= arr[n + 1]) {
				countUp++;
			} else
				countUp = 1;
			max = Math.max(countUp, max);
		}

		int countDown = 1; // 내림차순 세기

		for (int n = 0; n < N - 1; n++) {
			if (arr[n] >= arr[n + 1]) {
				countDown++;
			} else
				countDown = 1;
			max = Math.max(countDown, max);
		}
		
		
		
		System.out.println(max);
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어지는 수열 수

		int[] num = new int[N + 1];

		for (int n = 1; n < N + 1; n++) {
			num[n] = sc.nextInt();
		}

		int[] len = new int[N + 1]; // 길이를 알 수 있는 수열
		// 아무리 길어도 N개 가능

		next: for (int n = 1; n <= N; n++) { // num 배열을 돌면서 하나들고와서
			for (int m = 1; m <= n; m++) { // 거기까지 돌면서 검사검사검사

//				System.out.println(Arrays.toString(len));

				if (num[n] < len[m]) {
					len[m] = num[n]; // 그걸로 바꿔줘 (더 길게 붙일 수 있는 최선의 끝수)
					continue next;
				} else if (num[n] == len[m])
					continue next; // 같으면 넘어가

				if (len[m] == 0) { // 그리고 0이라면 그냥 거기에 붙여줘
					len[m] = num[n];
					continue next;
				}
			}
		}

		int count = 0;
		for (int n = 1; n <= N; n++) {
			if (len[n] != 0) {
				count++; // 0이 아닌것만 카운트해줘
			}
		}

		System.out.println(count);

	}
}

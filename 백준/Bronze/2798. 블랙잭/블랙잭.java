import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 카드 장수
		int M = sc.nextInt(); // 만들어야하는 합

		int[] card = new int[N];

		for (int n = 0; n < N; n++) {
			card[n] = sc.nextInt(); // 카드를 받아줌
		}

		int max = 0;

		for (int n = 0; n < N - 2; n++) {
			for (int i = n + 1; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (card[n] + card[i] + card[j] > M) { //합을 넘는다면 넘어가
						continue;
					}
					//그렇지 않다면 max값 갱신해줘~
					max = Math.max(max, card[n] + card[i] + card[j]);
				}
			}
		}
		System.out.println(max);
	}
}

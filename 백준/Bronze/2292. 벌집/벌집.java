import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 주어지는 벌집번호

		// 2 3 4 5 6 7까지 +6씩 커져나감
		int count = 1; // 몇칸 이동하나용
		// 첫바퀴부터 시작
		int here = 2; // 해당 트랙의 첫 숫자

		if (N == 1) {
			System.out.println(1);
		} else {
			while (here <= N) {
				here = here + (6 * count);
				count++;
				
//				System.out.println(here+":현재 바퀴 시작점");
//				System.out.println(count+":카운트");
			}
            System.out.println(count);
		}
	}
}
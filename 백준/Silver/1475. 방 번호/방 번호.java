import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int[] plastic = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// N을 자릿수로 변형
		int[] arrNum = new int[N.length()];
		for (int i = 0; i < N.length(); i++) {
			arrNum[i] = N.charAt(i) - '0'; // 아스키코드에서 빼서 int형으로...
		}

		int[] numbercount = new int[9]; // 갯수 세려고 (6과 9는 중복값이니까 6으로 더해주자)

		// 각 배열을 돌면서 같은거 찾기
		for (int i = 0; i < N.length(); i++) {
			for (int j = 0; j < 9; j++) { //9번뺴고 일단 돌아볼까
				if (arrNum[i] == plastic[j]) {
					numbercount[j]++; // 해당 칸에 ++해준다
				}
			}
			//만약에 9가 나오면 6번에 하나 더해주세용
			if(arrNum[i] == plastic[9]) {
				numbercount[6]++;
			}
		}
		
		//6과 9 중복값으로 만드는 셋트갯수는 홀짝일 떄 구분해준다
		if(numbercount[6] % 2== 0) {
			numbercount[6] = numbercount[6] / 2;
		} else numbercount[6] = numbercount[6] / 2 + 1;
		
		// 이 배열의 최대값을 구한다.
		int max = 0;

		for (int i = 0; i < 9; i++) {
			if (max <= numbercount[i]) {
				max = numbercount[i];
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}
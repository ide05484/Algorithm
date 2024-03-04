import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int koreamelon = sc.nextInt(); // 참외갯수

		int[][] width = new int[6][2]; // 방향은 1 2 3 4 만
		int[] count = new int[5]; // 방향 갯수 셈

		for (int i = 0; i < 6; i++) {
			int way = sc.nextInt(); // 방향
			count[way]++;
			width[i][0] = way; // 뱡향 넣어줌
			width[i][1] = sc.nextInt(); // 길이
		}

		int answer = 0;
		int total = 1; // 전체면적
		int part = 1; // 뺄면적

		// 전체면적은 count가 1인 면적
		for (int i = 0; i < 6; i++) {
			if (count[width[i][0]] == 1) {
				total *= width[i][1];
			}

			// 빼야할 면적은 count가 2가 나오는 4개 수 중 중간 두개의 수
			// i의 다음거랑 다다음거를 곱해야함
			int widthPart = (i + 1) % 6;
			int heightPart = (i + 2) % 6; //다다음거

			// 내거 i가 다다음거랑 같다면? 같은거 중간에 끼인 것이 답!
			if (width[i][0] == width[heightPart][0]) {
				part *= width[widthPart][1];	
			}
		}

		answer = (total - part) * koreamelon;

		System.out.println(answer);
	}
}
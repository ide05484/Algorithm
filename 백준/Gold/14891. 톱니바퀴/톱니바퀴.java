import java.io.*;
import java.util.*;

public class Main {

	static int[][] wheel;
	static int[] top;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 톱니바퀴
		wheel = new int[4][8];

		for (int r = 0; r < 4; r++) {
			String str = br.readLine();

			for (int c = 0; c < 8; c++) {
				wheel[r][c] = str.charAt(c) - '0';
			}
		}

		top = new int[4]; // 윗면, 해당 톱니의 인덱스 값

		int[] nums = { 1, 2, 4, 8 };

		int K = Integer.parseInt(br.readLine()); // 회전방법

		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken()) - 1; // 톱니번호
			int d = Integer.parseInt(st.nextToken()); // 방향

			int[] dir = new int[4];

			dir[num] = d;

			rotate(dir, num);

			for (int i = 0; i < 4; i++) {
				if (dir[i] == 0)
					continue;

				act(dir, i);
			}
		}

		int score = 0;

		for (int r = 0; r < 4; r++) {
//			System.out.print(wheel[r][top[r]] + " ");
			if (wheel[r][top[r]] != 0) {
				score += nums[r];
			}
		}
		
//		System.out.println();

		System.out.println(score);
	}

	// 양 옆 체크 및 방향 설정
	private static void rotate(int[] dir, int num) {
		// 왼쪽 확인
		for (int i = num - 1; i >= 0; i--) {
			// 기존의 왼쪽이랑 왼쪽의 오른쪽이랑 비교
			if (dir[i + 1] != 0 && wheel[i + 1][(top[i + 1] + 6) % 8] != wheel[i][(top[i] + 2) % 8]) {
				dir[i] = -dir[i + 1];
			} else
				break;
		}

		// 오른쪽 확인
		for (int i = num + 1; i < 4; i++) {
			// 기존의 오른쪽이랑 오른쪽의 왼쪽 비교
			if (dir[i - 1] != 0 && wheel[i - 1][(top[i - 1] + 2) % 8] != wheel[i][(top[i] + 6) % 8]) {
				dir[i] = -dir[i - 1];
			} else
				break;
		}
	}

	private static void act(int[] dir, int num) {
		if (dir[num] == -1) {
			// 반시계라면
			top[num] = (top[num] + 1) % 8;
		} else if (dir[num] == 1) {
			// 시계방향
			top[num] = (top[num] + 7) % 8;
		}
	}
}
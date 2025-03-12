import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int sum;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sum = 0;

		visit = new boolean[N][N];

		nqueen(0, 0);

		System.out.println(sum);

	}

	private static void nqueen(int R, int count) {

		if (count == N) {
			sum++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// 탐색가능한 영역인지
			if (check(R, i)) {
				visit[R][i] = true;
				nqueen(R + 1, count + 1);
				visit[R][i] = false; // 다시 탐색할 수 있또록함
			}

		}

	}

	private static boolean check(int R, int C) {

		for (int r = R - 1; r >= 0; r--) {
			if (visit[r][C])
				return false; // 못감
			
			//대각선 왼쪽
			if (C - (R - r) >= 0 && visit[r][C - (R - r)])
				return false;

			//대각선 오른쪽
			if (C + (R - r) < N && visit[r][C + (R - r)])
				return false;
		}

		return true;
	}
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt(); // 가로
		int c = sc.nextInt(); // 세로

		int num = sc.nextInt(); // 선 갯수

		List<Integer> rPos = new ArrayList<>();
		List<Integer> cPos = new ArrayList<>();

		// 시작지점 넣어주기
		rPos.add(0);
		cPos.add(0);

		for (int i = 0; i < num; i++) {
			int ox = sc.nextInt(); // 가로세로 판단
			// 가로줄
			if (ox != 0) {
				rPos.add(sc.nextInt());
			} else {// 세로줄
				cPos.add(sc.nextInt());
			}
		}
		// 끝지점 넣어주기
		rPos.add(r);
		cPos.add(c);

		// 오름차순으로 정렬
		Collections.sort(rPos);
		Collections.sort(cPos);

		// 가로세로의 맥스값 구하기
		int maxR = 0;
		int maxC = 0;

		for (int i = 1; i < rPos.size(); i++) {
			maxR = Math.max(maxR, findDif(rPos.get(i), rPos.get(i - 1)));
		}
		for (int i = 1; i < cPos.size(); i++) {
			maxC = Math.max(maxC, findDif(cPos.get(i), cPos.get(i - 1)));
		}

		System.out.println(maxR * maxC);

	}

	public static int findDif(int n, int m) {
		if (n >= m) {
			return n - m;
		}
		return m - n;
	}
}

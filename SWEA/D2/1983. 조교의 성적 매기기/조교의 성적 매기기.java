import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static class Student { // 학생 점수 배열
		int mid; // 중간
		int last;// 기말
		int hw; // 과제

		public Student(int mid, int last, int hw) {
			super();
			this.mid = mid;
			this.last = last;
			this.hw = hw;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();// 학생수
			int K = sc.nextInt() - 1;// 학점을 구할 몇번째 학생(인덱스로 인해 -1)

			double[] score = new double[N]; // 성적을 담을 배열 (소수점까지 담아야함)

			double tmp = 0; // k번째 학생 성적 담을 임시변수

			for (int i = 0; i < N; i++) {
				Student s = new Student(sc.nextInt(), sc.nextInt(), sc.nextInt()); // 학생성적
				score[i] = 0.35 * s.mid + 0.45 * s.last + 0.2 * s.hw; // 성적을 입력받는다.

				if (i == K) {
					tmp = score[i]; // K번째 학생 성적
				}
			}

			Arrays.sort(score); // 성적순 정렬

			int num = 0; // 찾아야할 학생인덱스

			for (int i = 0; i < N; i++) {
				if (score[i] == tmp) {
					num = i;
					break;
				}
			}

			String[] test = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
			String[] grade = new String[N]; // 진짜 평점 넣을 grade

			int idx = N - 1;
			int idxT = 0;

			while (idx >= 0 && idxT < N) {
				int count = N / 10;
				while (count > 0) {
					grade[idx] = test[idxT];
					count--;
					idx--;
				}
				idxT++;
			}

//			System.out.println(Arrays.toString(grade));
			System.out.println("#" + tc + " " + grade[num]);

		} // 테케 끝
	}// main끝
}
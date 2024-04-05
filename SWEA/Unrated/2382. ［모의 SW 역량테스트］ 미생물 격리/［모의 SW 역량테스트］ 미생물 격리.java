

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static List<Microbe> list; // 군집관리할 배열

	static class Microbe { // 미생물
		int r;
		int c;
		int cnt;
		int D;

		public Microbe(int r, int c, int cnt, int d) { // 미생물객체
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.D = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 배열 크기
			int M = Integer.parseInt(st.nextToken()); // 격리 시간
			int K = Integer.parseInt(st.nextToken()); // 군집 개수

			list = new ArrayList<>(); // 군집 넣어줄배열

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());

				int R = Integer.parseInt(st.nextToken()); // 행
				int C = Integer.parseInt(st.nextToken()); // 열
				int Cnt = Integer.parseInt(st.nextToken());// 수
				int D = Integer.parseInt(st.nextToken());// 이동방향

				list.add(new Microbe(R, C, Cnt, D)); // 객체추가

			} // 시작입력받아받아

			for (int t = 0; t < M; t++) {

				// 군집 배열을 돌면서 방향에 맞춰서 R C 값 옮겨주고
				// 가장자리에 도착하면 Cnt/2, 방향도 (D+2)%4 해주고
				// 그리고 그때 R과 C가 모두 같은 애들을 찾아서
				// Cnt를 다 더해서 하나의 객체로 만들고,원래 객체들은 없애주자 = 가장 많은 군집도 따로 선별해서 방향 정해주기 -> 개수바뀌니까
				// 동적으로?

				for (int i = 0; i < list.size(); i++) {

					Microbe here = list.get(i);// 지금 있는 객체보자

					switch (here.D) { // 방향에 맞춰서
					case 1: { // 상
						here.r--;
						break;
					}
					case 2: { // 하
						here.r++;
						break;
					}
					case 3: { // 좌
						here.c--;
						break;
					}
					case 4: { // 우
						here.c++;
						break;
					}
					} // switch끝

					// 거기가 경계값?
					if (here.r == 0 || here.r == N - 1 || here.c == 0 || here.c == N - 1) {

						if (here.D % 2 == 0)
							here.D = here.D - 1;
						else
							here.D = here.D + 1;

						here.cnt /= 2; // 반으로 나눠줭
					}

				} // 그 시간에 미생물 움직여줘~

				int newsize = list.size();

				for (int j = 0; j < newsize - 1; j++) {
					Microbe m1 = list.get(j);
					if(m1.cnt == 0)
						continue;
					int sum = m1.cnt;

					// 하나를 잡고 비교할 때 r과 c가 같은걸로 갱신
					for (int i = j + 1; i < newsize; i++) {
						Microbe m2 = list.get(i);
						if(m2.cnt == 0)
							continue;

						if ((m1.r == m2.r) && (m1.c == m2.c)) {
							sum += m2.cnt; // 좌표가 같으면 더해더해
							
							int Cnt = Math.max(m1.cnt, m2.cnt); // max값 갱신갱신

							if (Cnt == m2.cnt) { // 갱신된다면?
								m1.cnt = m2.cnt;
								m1.D = m2.D; // 방향 바꿔줘
								m2.cnt = 0; // 더해줬으니까 빼빼
							}
							// 갱신이 안된다면?
							// 그냥 m1값
							else {
								m2.cnt = 0;
							}
						}
					}
					// 다 비교함
					m1.cnt = sum;
				} // 객체 다 비교해

			} // 해당 시간만큼 움직일거얏

			int ans = 0; // 미생물 수

			for (Microbe m : list) {
				ans += m.cnt;
			}

			System.out.println("#" + tc + " " + ans);

		} // tc
	}// main
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 개수

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 도시크기
			int M = Integer.parseInt(st.nextToken()); // 한집당 낼 수 있는 돈

			int[][] city = new int[N][N];

			int home = 0;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					city[r][c] = Integer.parseInt(st.nextToken()); // 지도하나씩 받자

					if (city[r][c] == 1)
						home++; // 총집의 개수
				}
			}

			// K=1은 무조건 있음! 집은 하나이상 있다고 했고 M도 1부터 시작이니 손해보지는 않음
			// 그럼 2부터 시작
			int K = 2; // 방범범위

			int maxCnt = 1; // 최대집

			while (true) {
				// K크기에서의 방범 비용
				int cost = K * K + (K - 1) * (K - 1);

				if (cost > M * home)
					break; // 전체 집이 돈을 내도 방범비용이 더 많이들면 손해보니까 멈추자

				// 2차원 배열 돌면서 해당 범위에 있는 이익보는 집 최대 구하기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						int homeCnt = 0; //범위 안에 있는 집 개수 세주기
						//방범 범위 안에서
						for (int nr = r - (K - 1); nr <= r + (K + 1); nr++) {
							for (int nc = c - (K - 1); nc <= c + (K + 1); nc++) {
								//범위 안에 있는 것들 중에
								if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
									//범위 안에 있는 것 = x 좌표 차이 + y 좌표 차이가 K와 같은 애들이 방범범위
									if((Math.abs(r-nr) + Math.abs(c-nc) <= (K-1)) && city[nr][nc] == 1) {
										//그 안에 있는 집 개수를 새어준다
										homeCnt++;
									}
								}
								
								if(M*homeCnt >= cost) {
									//방범비용보다 집에서 내는 돈이 같거나 크다면
									maxCnt = Math.max(maxCnt, homeCnt); //최대 집개수 갱신
								}
							}//해당좌표의 방범범위 c
						}//해당좌표의 방범범위 r
					}
				}
				
				//다 돌고나면 다음 탐색은 K범위를 더 크게
				K++;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(maxCnt);
			
			System.out.println(sb);

		} // 테케마감
	}// main마감
}
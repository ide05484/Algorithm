import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열

			int[][] flower = new int[N][M]; // 꽃가루 배열

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					flower[r][c] = sc.nextInt(); // 꽃가루 받기
				}
			}

			// 델타 본인 하상우좌
			int[] dr = { 0, 1, -1, 0, 0 }; // 델타행
			int[] dc = { 0, 0, 0, 1, -1 }; // 델타열
			
			int max = 0; //합의 최대값
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int sum = 0; //합구하기
					// 델타배열을 돌겠습니다!
					for (int i = 0; i < 5; i++) {
						//넘치지 않는 범위 안에서
						if (r + dr[i] >= 0 && r + dr[i] < N && c + dc[i] >= 0 && c + dc[i] < M) {
							sum += flower[r+dr[i]][c+dc[i]];
							//해당 본인 하상우좌 더해줍니다.
						}
					} //델타를 다 돌고나서
					max = Math.max(max, sum); //max값 갱신
				} // 열마감
			} // 행마감
			
			System.out.println("#"+tc+" "+max);
		} // 테케마감
	}// main마감
}
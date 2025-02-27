import java.util.*;
import java.io.*;

public class Main {

	static boolean[] visit;
	static int[][] team;

	static int N;
	static int min;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		team = new int[N][N];

		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int c = 0; c < N; c++) {
				team[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[N];
		min = Integer.MAX_VALUE;

		comb(0, 0);
		
		System.out.println(min);

	}

	private static void comb(int start, int select) {
		
		if(start >= N) return; //범위를 나갈 때
		
		if (select == N / 2) {
			calculate();
			return;
		}
		
		if (!visit[start]) {
			visit[start] = true;
			comb(start + 1, select + 1);
			visit[start] = false;
			comb(start + 1, select);
		}

	}

	// 두 팀간의 차이 계산하기
	private static void calculate() {
		int starkTeam = 0;
		int linkTeam = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visit[i] && visit[j]) {
					starkTeam += team[i][j];
				} else if (!visit[i] && !visit[j]) {
					linkTeam += team[i][j];
				}
			}
		}
		
		int diff = Math.abs(starkTeam - linkTeam);
		
		min = Math.min(min, diff);
	}
}
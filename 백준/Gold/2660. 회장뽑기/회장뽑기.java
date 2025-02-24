import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 회원 수

		int[][] team = new int[N + 1][N + 1]; // 1번부터 시작

		for (int r = 0; r < N + 1; r++) {
			for (int c = 0; c < N + 1; c++) {
				if (r == c)
					continue;
				team[r][c] = INF;
			}
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == -1 && B == -1)
				break;

			team[A][B] = team[B][A] = 1; // 서로가 친구
		}

		floyd(team, N);
		
		int min = INF;
		int[] scores = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			int score = 0;
			for(int j = 1; j <= N; j++) {
				score = Math.max(score, team[i][j]);
			}
			
			scores[i] = score;
			min = Math.min(min, score);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(scores[i] == min) {
				list.add(i);
			}
		}
		
		System.out.println(min + " " + list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	private static void floyd(int[][] team, int n) {

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(team[i][k] != INF && team[k][j] != INF){
	                    team[i][j] = Math.min(team[i][j], team[i][k] + team[k][j]);
	                }
				}
			}
		} //모두 갱신
	}
}

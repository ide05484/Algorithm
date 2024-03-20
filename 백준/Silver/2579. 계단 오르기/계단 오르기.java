import java.util.Scanner;

public class Main {

	static int[] stairs;
	static int[][] dp;
	static int[][] dp2;
	static int sum;
	static int N;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		stairs = new int[N + 1];
		dp = new int[N + 1][3];
		dp2 = new int[N+1][3];

		for (int i = 1; i <= N; i++) {
			stairs[i] = sc.nextInt();
		}

		sum = 0;
		max = 0;

		step(N, 2, 1);

//		for(int i=3; i<=N; i++) {
//			dp[i][1] = dp[i-1][2];
//			dp[i][2] = stairs[i] + Math.max(dp[i-1][1], dp[i-1][2]);
//		}

		System.out.println(dp[N][2]);
		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(dp[i][j] + " ");
//			} System.out.println();
//		}
//		
//		for(int i=0; i<=N; i++) {
//			for(int j=0; j<3; j++) {
//				System.out.print(dp2[i][j] + " ");
//			} System.out.println();
//		}
	}

	static int step(int r, int c, int beforeC) {
		if (r == 1 && c == 1) {
			return dp[r][c] = 0;
		} else if (r == 1 && c == 2) {
			return dp[r][c] = stairs[1];
		}

		if (beforeC == 1 && dp[r][c] != 0) {
			return dp[r][c];
		} else if(beforeC ==2 && dp2[r][c] != 0){
			return dp2[r][c];
		} else {
			switch (c) {

			case 1:
				return dp[r][c] = step(r - 1, c + 1, 1);
			case 2:
				if (beforeC == 1) {
					return dp[r][c] = stairs[r] + Math.max(step(r - 1, c, beforeC + 1), step(r - 1, 1, 0));
				} else if(beforeC == 2){
					return dp2[r][c] = stairs[r] + step(r - 1, c - 1, 0);
				}
			}
		}
		return -1;
	}

}

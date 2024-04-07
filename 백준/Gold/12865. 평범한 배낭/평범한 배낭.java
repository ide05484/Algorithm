import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 물품의 수
		int K = sc.nextInt(); // 버틸수 있는 무게

		int[] weight = new int[N + 1]; // 물품 무게배열
		int[] cost = new int[N + 1]; // 물품 비용배열

		for (int n = 1; n < N + 1; n++) {
			weight[n] = sc.nextInt(); // 주어지는 물건의 무게
			cost[n] = sc.nextInt(); // 주어지는 물건의 비용
		}

		int[][] find = new int[N + 1][K + 1]; // 물건을 하나씩 고려하면서 N, K비용을 1kg단위로 살펴보자

		for (int n = 1; n < N + 1; n++) { //물건 하나 선택하고
			for (int k = 0; k < K + 1; k++) { // 1키로부터 고려해줄게!
				if(weight[n] <= k) {
					//해당 물건이 선택된 후라면? max값을 비교해야해
					find[n][k] = Math.max(find[n-1][k], find[n-1][k-weight[n]] + cost[n]);
					//앞의 물건을 선택한 채 내거를 선택 안하는게 낫나(K kg에서의 최적비용) vs 그전 고려버전에서 선택하는게 나은가
				} else { //아직 선택하기 전이라면?
					find[n][k] = find[n-1][k]; //그전행을 그대로 들고 오면 돼!
				}
			}
		}//고려다함
		System.out.println(find[N][K]);
	}
}
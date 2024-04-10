import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케갯수

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 당근 갯수
			int[] carrot = new int[N]; // 당근크기배열

			for (int n = 0; n < N; n++) {
				carrot[n] = sc.nextInt(); //당근 크기를 넣어줌
			}
			
			int max = 0; //얘는 최대값을 갱신하기 위함
			int count = 1; //세어주기 위함 (오름차순인 당근갯수를)
			//최소값은 1이라고 했기 때문에 1로 초기화
			
			for(int n = 0; n < N-1; n++) {
				//다음 당근이 내것보다 크다면?
				if(carrot[n] < carrot[n+1]) {
					count++;
				} else { //그렇지 않으면 다시 count 값을 1로 돌려놔주셈!
					count = 1;
				}
				//돌면서 계속 카운트의 max값을 갱신
				max = Math.max(max, count);
			}

			System.out.println("#" + tc + " " + max);
		} // 테케끝
	}// 메인 끝
}
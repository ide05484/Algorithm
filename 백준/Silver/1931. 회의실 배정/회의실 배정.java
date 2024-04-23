import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //회의의 수
		int[][] arr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			arr[n][0] = sc.nextInt(); //시작시간
			arr[n][1] = sc.nextInt(); //종료시간
			
			//종료 시간 순으로 정렬 --- 같다면 시작 시간 순으로 정렬
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0]; //종료시간이 같다면 시작시간
				}
				return o1[1] - o2[1];
			}
			
		});
		
		int count = 0;
		int end = -1; //종료시간
		
		for(int i = 0 ; i < N; i ++) {
			if(arr[i][0] >= end) {
				//종료시간이 겹치지 않는 다음 회의가 나오면 ? ? ? 
				count++;
				end = arr[i][1]; //종료시간 업데이트
			}
		}
		
		System.out.println(count);
		
	}
}
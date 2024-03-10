import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int max = 0; //max값
		int idx = 0;//몇번째 수
		
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt(); //숫자를 받아줍니다
			
			max = Math.max(max, arr[i]);
			
			if(max == arr[i]) {
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
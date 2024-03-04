import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		int[] remain = new int[42];
		
		for(int i = 0; i<10; i++) {
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		for(int i = 0; i<10; i++) {
			int num;
			num = arr[i] % 42;
			remain[num]++;
		}
		
		int count = 0;
		
		for(int i =0; i<42; i++) {
			if(remain[i] != 0) {
				count++;
			}
		}
				
		
		System.out.println(count);
		sc.close();
	}
}
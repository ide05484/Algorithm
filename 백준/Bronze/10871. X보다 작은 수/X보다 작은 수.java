import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		int[] num = new int[N];
		
		for (int a = 0; a<N; a++) {
			int element = sc.nextInt();
			num[a] = element;
		}
		
		for (int i = 0; i<N; i++) {
			if(num[i] < X) {
				System.out.print(num[i]+" ");
			}
			
		}
		
	}
}

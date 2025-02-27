import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int n = 1; n <= 9; n++) {
			sb.append(N).append(" * ").append(n).append(" = ").append(N*n).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
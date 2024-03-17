import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] count = new int[10];
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		String finalNum = String.valueOf(num1*num2*num3);
		
		for(int i = 0; i < finalNum.length(); i++) {
			count[finalNum.charAt(i) - '0']++;
		}
		
		for(int c = 0; c<10; c++) {
			System.out.println(count[c]);
		}
	}
}
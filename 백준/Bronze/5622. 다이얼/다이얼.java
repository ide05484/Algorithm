import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); // 문자열
		
		int time = str.length(); // 1돌리는데 걸리는 시간

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			switch (c) {
			case 'A': {
				time += 2;
				break;
			}
			case 'B': {
				time += 2;
				break;
			}
			case 'C': {
				time += 2;
				break;
			}
			case 'D': {
				time += 3;
				break;
			}
			case 'E': {
				time += 3;
				break;
			}
			case 'F': {
				time += 3;
				break;
			}
			case 'G': {
				time += 4;
				break;
			}
			case 'H': {
				time += 4;
				break;
			}
			case 'I': {
				time += 4;
				break;
			}
			case 'J': {
				time += 5;
				break;
			}
			case 'K': {
				time += 5;
				break;
			}
			case 'L': {
				time += 5;
				break;
			}
			case 'M': {
				time += 6;
				break;
			}
			case 'N': {
				time += 6;
				break;
			}
			case 'O': {
				time += 6;
				break;
			}
			case 'P': {
				time += 7;
				break;
			}
			case 'Q': {
				time += 7;
				break;
			}
			case 'R': {
				time += 7;
				break;
			}
			case 'S': {
				time += 7;
				break;
			}
			case 'T': {
				time += 8;
				break;
			}
			case 'U': {
				time += 8;
				break;
			}
			case 'V': {
				time += 8;
				break;
			}
			case 'W': {
				time += 9;
				break;
			}
			case 'X': {
				time += 9;
				break;
			}
			case 'Y': {
				time += 9;
				break;
			}
			case 'Z': {
				time += 9;
				break;
			}
			}
		} //문자열 다돔
		
		System.out.println(time);

	}
}
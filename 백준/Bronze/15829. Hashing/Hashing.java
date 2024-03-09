import java.util.Scanner;

public class Main {
	
	static int r = 31;
	static int M = 1234567891;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); //문자열 길이
		String str = sc.next(); //문자열 받아줌
		
		int sum = 0; //시그마함수 적용하기 위함
		
		//문자열을 돌면서 해쉬함수
		for(int s = 0; s < str.length(); s++) {
			
			//해당 글자의 숫자를 먼저 찾는다.
			int hash = findNum(str.charAt(s));
			sum += hash * Math.pow(r, s); //그리고 그것을 계수에 맞춰서 곱해서 더해줌
		}
		
		System.out.println(sum%M);
	}

	public static int findNum(char s) {
		
		switch(s) {
		case 'a' : return 1;
		case 'b' : return 2;
		case 'c' : return 3;
		case 'd' : return 4;
		case 'e' : return 5;
		case 'f' : return 6;
		case 'g' : return 7;
		case 'h' : return 8;
		case 'i' : return 9;
		case 'j' : return 10;
		case 'k' : return 11;
		case 'l' : return 12;
		case 'm' : return 13;
		case 'n' : return 14;
		case 'o' : return 15;
		case 'p' : return 16;
		case 'q' : return 17;
		case 'r' : return 18;
		case 's' : return 19;
		case 't' : return 20;
		case 'u' : return 21;
		case 'v' : return 22;
		case 'w' : return 23;
		case 'x' : return 24;
		case 'y' : return 25;
		case 'z' : return 26;
		}
		return 0;
	}
}
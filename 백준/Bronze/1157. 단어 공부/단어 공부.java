import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();// 문자열 받기
		
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		int[] count = new int[27]; // 숫자 셀 수 있는 배열을 만든다
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			count[changeNum(c)]++;
		}
		
		int max = 0; //최대값 찾기
		int idx = 0; //최대값일 때 인덱스값 찾기
		int countMax = 0;
		
		for(int j = 1; j < 27; j++) {
			max = Math.max(max, count[j]); //제일 많이 쓰인 알파벳찾기
		}
		
		for(int j = 1; j < 27; j++) {
			if(max == count[j]) { //max랑 카운트가 일치하면
				idx = j; //인덱스값 저장하고
				countMax++; //최대값 갯수세기
			}
		}
		
		if(countMax == 1) { //1개면 출력
			System.out.println(alphabet[idx-1]);
		} else { //여러개면 ?출력
			System.out.println("?");
		}
	}

	// 문자를 숫자로 바꿔주는 메서드
	public static int changeNum(char c) {
		
		switch(c) {
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
		
		case 'A' : return 1;
		case 'B' : return 2;
		case 'C' : return 3;
		case 'D' : return 4;
		case 'E' : return 5;
		case 'F' : return 6;
		case 'G' : return 7;
		case 'H' : return 8;
		case 'I' : return 9;
		case 'J' : return 10;
		case 'K' : return 11;
		case 'L' : return 12;
		case 'M' : return 13;
		case 'N' : return 14;
		case 'O' : return 15;
		case 'P' : return 16;
		case 'Q' : return 17;
		case 'R' : return 18;
		case 'S' : return 19;
		case 'T' : return 20;
		case 'U' : return 21;
		case 'V' : return 22;
		case 'W' : return 23;
		case 'X' : return 24;
		case 'Y' : return 25;
		case 'Z' : return 26;
		}
		return 0;
	}
}

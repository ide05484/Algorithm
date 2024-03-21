import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String S = sc.next(); //문자열
		
		//알파벳 배열
		char[] c = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int[] idx = new int[26];
		
		//알파벳 배열을 돌면서
		to: for(int i = 0; i < 26; i++) {
			for(int s = 0; s<S.length(); s++) {
				//해당 알파벳이 S에 있다면
				if(c[i] == S.charAt(s)) {
					idx[i] = s;
					continue to;
				}
			}
			//해당 단어에 없으면 여기에 옴!
			idx[i] = -1;
		}
		
		for(int i : idx) {
			System.out.print(i+" ");
		}
	}
}
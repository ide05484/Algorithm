import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next(); // 공백이 없으니 string으로 받앗
		int N = str.length(); // str 길이

		char[] onOff = new char[N]; // 꺼져있는지 켜져있는지

		for (int n = 0; n < str.length(); n++) {
			onOff[n] = str.charAt(n);
		} // 그리고 하나씩 떼서 배열에 넣어줘

		int count = 0; // 일단 스위치 누르는 경우의 수

		for (int n = 0; n < N; n++) {
			if (onOff[n] == 'Y') { // 꺼야 해~~
				
				for (int i = 1; i <= N / (n + 1); i++) { // 두번째부터~ 반전시켜주세옹
					if (onOff[(n + 1) * i-1] == 'Y') {
						onOff[(n + 1) * i-1] = 'N';
					} else
						onOff[(n + 1) * i-1] = 'Y';
				} // 반전끝~

//				for (int x = 0; x < N; x++) {
//					System.out.print(onOff[x] + " ");
//				}
//				System.out.println();
				
				count++;

			} // Y일때

			else
				continue; // N이라면 걍 지나쳐~~
		}
		System.out.println(count);
	}
}
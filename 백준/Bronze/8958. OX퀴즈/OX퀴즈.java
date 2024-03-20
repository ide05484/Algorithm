import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테케 갯수
		
		for(int tc = 1; tc<=T; tc++) {
			
			String str = sc.next(); //받는 문자열
			
			int sum = 0;
			int count = 1;
			
			//여기서 문자열을 돌면서 sum해줄 것임
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i)=='X') {
					count = 1;
					continue;
				}
				//X가 아니라면
				sum += count; //1을 더하고
				count ++;
			}
			
			System.out.println(sum);
		}//테케 마감
	}//main 마감
}
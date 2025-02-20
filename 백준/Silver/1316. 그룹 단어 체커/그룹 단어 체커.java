import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		to : for(int n = 0; n < N; n++) {
			
			String str = br.readLine();
			ArrayList<Character> list = new ArrayList<Character>(); 
			
			list.add(str.charAt(0)); //첫번째는 무조건 넣기
			
			for(int i = 1; i < str.length(); i++) {
				if(list.contains(str.charAt(i))){
					//이미 있는 문자열이라면
					if(str.charAt(i) == str.charAt(i-1)) {
						//둘이 같은 문자열이면
						continue;
					}
					
					//아니라면 멈춰
					continue to;
				}
				
				list.add(str.charAt(i));
			}
			
			sum++;
		} 
		
		System.out.println(sum);
	}
}
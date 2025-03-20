import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		String beat = Integer.toBinaryString(K+1).substring(1); //이진수로 변환하고 앞자리를 뗀다.
		//K+1를 하는 이유?
		//1부터 2의 제곱수만큼씩 커진다.
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < beat.length(); i++) {
			if(beat.charAt(i) == '0') {
				sb.append('4');
			} else {
				sb.append('7');
			}
		}
		
		System.out.println(sb);
	}
}
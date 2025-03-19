import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] files = new String[N];
		
		int len = 0;
		
		for(int i = 0; i < N; i++) {
			files[i] = br.readLine();
			len = files[i].length();
		}
		
		StringBuilder sb = new StringBuilder();
		
		to: for(int i = 0; i < len; i++) {
			for(int n = 0; n < N - 1; n++) {
				if(files[n].charAt(i) != files[n+1].charAt(i)) {
					sb.append("?");
					continue to;
				}
			}
			
			sb.append(files[0].charAt(i));
		}
		
		System.out.println(sb);
	}
}
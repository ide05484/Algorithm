import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //목표채널
		int M = Integer.parseInt(br.readLine()); //고장난 버튼개수
		
		boolean[] button = new boolean[10]; //0부터9
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				int num = Integer.parseInt(st.nextToken());
				
				button[num] = true; //고장남
			}
		}
		
		int now  = 100;
		
		int minPress = Math.abs(N - now);
		
		for(int channel = 0; channel <= 999999; channel++) {
			int length = check(channel, button);
			
			if(length > 0) {
				int count = Math.abs(N - channel) + length;
				minPress = Math.min(minPress, count);
			}
		}
		
		
		System.out.println(minPress);
	}

	private static int check(int channel, boolean[] button) {
		
		if(channel == 0) {
			return button[0] ? 0 : 1;
		}
		
		int len = 0;
		
		while(channel > 0) {
			int num = channel % 10;
			
			if(button[num]) return 0; //누를 수 없으니까 ....
			
			len++;
			channel /= 10;
		}
		
		return len;
	}
}
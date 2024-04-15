import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //갖고있는개수
		int[] card = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> count = new HashMap<>(); //바로바로 등장횟수를 세어서 저장해줄 수 있음
		
		for(int n = 0; n < N; n++) {
			card[n] = Integer.parseInt(st.nextToken()); //카드숫자받기
			count.put(card[n], count.getOrDefault(card[n], 0) + 1); //하나씩 추가해서 넣어주자
			//default는 없으면 0으로 시작해! 라는 뜻
		}
		
		int M = Integer.parseInt(br.readLine()); //숫자개수셀 개수
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int m = 0; m < M; m++) {
			
			int num = Integer.parseInt(st.nextToken()); //주어지는 숫자
			
			sb.append(count.getOrDefault(num, 0)).append(" "); 
			//여기도 마찬가지로 num값이 없으면 0으로 출력해줘
		}
		System.out.println(sb);
	}
}
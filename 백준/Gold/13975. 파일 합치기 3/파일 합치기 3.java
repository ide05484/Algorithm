import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int K = Integer.parseInt(br.readLine()); //개수
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>(); //오름차순 정렬 
			
			for(int k = 0; k < K; k++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long sum = 0;
			
			while(pq.size() != 1) {
				long first = pq.poll();
				long second = pq.poll();
				
				long tmp = first + second;
				sum += tmp;
				
				pq.add(tmp);
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb);
	}
}
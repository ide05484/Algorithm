import java.util.*;
import java.io.*;

public class Main {
	
	static class University {
		int cost;
		int day;
		
		public University(int cost, int day) {
			this.cost = cost;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //제시하는 대학수
		
		PriorityQueue<University> pq = new PriorityQueue<>((a, b) ->  b.day - a.day);
		
		int max = 0;
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			pq.add(new University(p, d));
			max = Math.max(max, d);
		}
		
		int sum = 0;
		
		PriorityQueue<University> costPQ = new PriorityQueue<>((a, b) -> b.cost - a.cost); 
		
		for (int day = max; day >= 1; day--) {
            // 현재 날짜(day) 이상 가능한 강연들만 costPQ에 추가
            while (!pq.isEmpty() && pq.peek().day >= day) {
                costPQ.add(pq.poll());
            }

            // 해당 날짜에 가장 수익 높은 강연 하나만 선택
            if (!costPQ.isEmpty()) {
                sum += costPQ.poll().cost;
            }
        }
		
		System.out.println(sum);
		
	}
}
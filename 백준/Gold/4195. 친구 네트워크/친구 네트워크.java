import java.util.*;
import java.io.*;

public class Main {
	
	static int[] parent;
	static int[] size;
	static Map<String, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= T; tc++) {
			int F = Integer.parseInt(br.readLine()); //친구의 수
			
			parent = new int[F*2]; //모든 친구랑 친구했을 때 최대값
			size = new int[F*2];
			map = new HashMap<>();
			
			//친구관계
			for(int i = 0; i < 2*F; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			
			int id = 0;
					
			for(int f = 0; f < F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String start = st.nextToken();
				String end = st.nextToken();
				
				if(!map.containsKey(start)) {
					map.put(start, id++);
				}
				
				if(!map.containsKey(end)) {
					map.put(end, id++);
				}
				
				//유니온 파인트 시작
				int group1 = find(map.get(start));
				int group2 = find(map.get(end));
				
				if(group1 != group2) {
					parent[group2] = group1; //총합하기
					size[group1] += size[group2];
				}
				
				sb.append(size[find(group1)]).append("\n");			
			}
		}
		
		System.out.println(sb);
	}
	
	public static int find(int x) {
		if(parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		
		return parent[x];
	}
}

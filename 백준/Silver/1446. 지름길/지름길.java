import java.io.*;
import java.util.*;

public class Main {

	static int N, D;
	static List<List<Road>> list;
	static int[] dist;

	static class Road implements Comparable<Road> {
		int end;
		int length;

		Road(int end, int length) {
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Road r) {
			return Integer.compare(this.length, r.length);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 지름길 개수
		D = Integer.parseInt(st.nextToken()); // 고속도로 길이

		list = new ArrayList<>();

		// 1씩 거리 연결 되어 있음. . . . .
		for (int i = 0; i < 10001; i++) {
			list.add(new ArrayList<>());
		}

		for (int n = 0; n < N; n++) {

			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()); // 시작점
			int e = Integer.parseInt(st.nextToken()); // 끝점
			int l = Integer.parseInt(st.nextToken()); // 길이

			list.get(s).add(new Road(e, l)); // 역주행할 수 없다.
		}

		dist = new int[10001]; // 거리
		for (int d = 0; d < dist.length; d++)
			dist[d] = d;

		dijkstra(0);

		System.out.println(dist[D]);
	}

	private static void dijkstra(int start) {

		if (start > D)
			return;

		if (dist[start + 1] > dist[start] + 1) {
			dist[start + 1] = dist[start] + 1;
		}

		for (int i = 0; i < list.get(start).size(); i++) {
			if (dist[start] + list.get(start).get(i).length < dist[list.get(start).get(i).end]) {
				dist[list.get(start).get(i).end] = dist[start] + list.get(start).get(i).length;
			}
		}

		dijkstra(start + 1);

	}
}
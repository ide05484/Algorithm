import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 세로
		int M = Integer.parseInt(st.nextToken()); // 가로
		int B = Integer.parseInt(st.nextToken()); // 들고있는 블록

		int[][] minecraft = new int[N][M]; // 마인크래프트 맵

		int minHeight = Integer.MAX_VALUE; //주어진 맵에서의 최소높이
		int maxHeight = 0; //주어진 맵에서의 최고높이
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				minecraft[r][c] = Integer.parseInt(st.nextToken());
				
				minHeight = Math.min(minHeight, minecraft[r][c]);
				maxHeight = Math.max(maxHeight, minecraft[r][c]);
			}
		}
		
		int minTime = Integer.MAX_VALUE; //최소시간
		int finalheight = 0; //출력할 높이
		
		for(int height = minHeight; height <= maxHeight; height++) {
			//모든 높이를 만들 경우의 수를 구하자
			int time = 0; //해당 높이를 만들때 필요한 시간
			int inventory = B; //인벤토리에 들어있는 개수
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < M; c++) {
					//해당 좌표가 지금 만들어야하는 높이가 같지 않다면? 같도록 해주자
					if(minecraft[r][c] > height) {
						inventory += (minecraft[r][c]-height); //둘 차이만큼 넣어주고
						time += 2*(minecraft[r][c]-height); //넣을때는 2초씩 걸리니까 넣는 돌의 2배씩
					}
					
					if(minecraft[r][c] < height) {
						inventory -= height-minecraft[r][c]; //둘 차이만큼 빼주고
						time += height-minecraft[r][c]; //시간 더해주고
					}
				}
			}
			
//			System.out.println(time + ":시간");
			
			//해당 height에 맞는 r c로 다 만들어 줬는데 B가 음수이면 안됨!
			if(inventory >= 0) {
				//B가 양수인 경우에만 최소시간 갱신
				minTime = Math.min(minTime, time);
				if(minTime == time) {
					//갱신될때에만
					finalheight = height; //해당 높이로 저장
				}
			}//B가 음수가 아닐때
		}//모든 높이 경우의 수를 다 돌았음
		
		StringBuilder sb = new StringBuilder();
		sb.append(minTime).append(" ").append(finalheight);
		System.out.println(sb);
	}
}
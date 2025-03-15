import java.io.*;
import java.util.*;

public class Main {
	
	static class Balloon {
		double dir;
		int area;
		
		Balloon(double dir, int area) {
			this.dir = dir; //기울기
			this.area = area; //몇사분면
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //풍선개수
		
		Map<String, Integer> balloon = new HashMap<>(); //풍선위치
		//기울기에 해당하는 풍선과 개수
		
		int max = 0;
		
		for(int n = 0; n < N; n++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int area = findArea(x, y);
			
			int gcd = gcd(Math.abs(x), Math.abs(y)); // x와 y의 최대공약수 찾기
			int slopeX = x / gcd; // x를 GCD로 나누기
			int slopeY = y / gcd; // y를 GCD로 나누기
			
			String key = area + ":" + slopeX + "/" + slopeY;
			balloon.put(key, balloon.getOrDefault(key, 0) + 1);
			
			max = Math.max(max, balloon.get(key));
		}
		
		System.out.println(max);
		
	}
	
	// 최대공약수(GCD)를 구하는 함수 (유클리드 호제법 사용)
	private static int gcd(int a, int b) {
	    while (b != 0) {
	        int temp = b;
	        b = a % b;
	        a = temp;
	    }
	    return a;
	}

	
	//사분면
	private static int findArea(int x, int y) {
		if(x > 0 && y > 0) return 1;
		else if(x > 0 && y < 0) return 2;
		else if(x < 0 && y < 0) return 3;
		else return 4;
	}
}
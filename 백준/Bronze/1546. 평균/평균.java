import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); //점수 개수
		double[] scorepaper = new double[num];//점수 넣을 배열
		double[] newscorepaper = new double[num];//새 점수 배열
		
		for(int i = 0; i < num; i++ ) {
			double score = sc.nextInt(); //점수갯수만큼 점수 입력
			scorepaper[i] = score;
		}
		
		//최대점수 구하기
		double max = 0;
		for(int i = 0; i <num; i++) {
			if (max<=scorepaper[i]) {
				max = scorepaper[i];
			}
		}
	
		double sum = 0; //평균 구하기 전 총점변수
		
		for (int i = 0; i <num; i++) {
			newscorepaper[i] = (scorepaper[i]/max)*100;
			sum += newscorepaper[i];
		}
				
		System.out.println(String.format("%3f", sum/num));
		
		sc.close();

	}

}

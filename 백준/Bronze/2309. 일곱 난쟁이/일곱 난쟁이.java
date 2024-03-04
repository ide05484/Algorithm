import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dwarf = new int[9]; //9명 난쟁이
		
		int sum = 0;
		
		for(int d = 0; d<9; d++) {
			dwarf[d] = sc.nextInt(); //키를 받음
			sum += dwarf[d];//9명 키의 합
		}
		
		//가짜 난쟁이의 인덱스값
		int idx1 = 0;
		int idx2 = 0;
		
		//9명 중에서 2명을 골라서 뺀 값이 100이면 배열에 넣어준다.
		out: for(int i = 0; i<8; i++) {
			for(int j = i+1; j<9; j++) {
				if(sum - (dwarf[i]+dwarf[j]) == 100) {
					idx1 = i;
					idx2 = j;
					break out; //아예 나가면 됨 암거나 출력이니까
				}
			}
		}
		//키를 0으로 바꿔줌 = 없는셈치자
		dwarf[idx1] = 0;
		dwarf[idx2] = 0;
		
		Arrays.sort(dwarf); //오름차순 정렬
		
		for(int i = 0; i<9; i++) {
			if(dwarf[i] != 0) { //0이 아닌 것만 출력
				System.out.println(dwarf[i]);
			}
		}
		
	}
}
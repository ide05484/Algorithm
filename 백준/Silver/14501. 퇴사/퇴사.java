import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 퇴사까지 남은 날짜
		
		List<Integer> days = new ArrayList<>();
		List<Integer> wages = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int day = sc.nextInt();
			int wage = sc.nextInt();
			days.add(day);
			wages.add(wage);
		}
		
//		for(int i=0; i<days.size(); i++) {
//			System.out.print(days.get(i) + " ");
//		}
//		System.out.println();
//		for(int i=0; i<days.size(); i++) {
//			System.out.print(wages.get(i) + " ");
//		} System.out.println();
		
		List<Integer> totals = new ArrayList<>();
					
		for(int i=0;i<(1<<N);i++) { // N개의 원소를 가진 집합의 부분집합 뽑기
			int[] temp = new int[days.size()]; // 임시로 days리스트를 대신할 temp 배열
			for(int tp=0; tp<days.size(); tp++) {
				if(days.get(tp)+tp > days.size()) { // 퇴사일 이후로도 일해야 하는 날 -1로 만들기
					temp[tp] = -1;
				}
			}
		    for(int j=0;j<N;j++) {
		        if(((1<<j)&i)>0) {
		        	if(temp[j] != -1) { // 부분집합 j중에서 temp[j]가 -1이 아닌 곳이라면
		        		temp[j]=1; // 1로 만들기
		        	}
		        }
		    }
		    
		    start : for(int j=0; j<days.size(); j++) {
//		    	System.out.println(Arrays.toString(temp));
		    	if(temp[j] != 1) {
		    		continue start;
		    	} else {
		    		for(int k=j+1; k<j+days.get(j); k++) {
//		    			System.out.println(k + " " + days.get(j));
			    		temp[k] = -1;
			    	}
		    	}
		    }
		    
		    int total = 0;
		    for(int j=0; j<temp.length; j++) {
		    	if(temp[j] == 1) {
		    		total = total + wages.get(j);
		    	}
		    }
		    totals.add(total);
//		    System.out.println(total);
//		    System.out.println(Arrays.toString(temp));
		} // for끝
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<totals.size(); i++) {
			if(max < totals.get(i)) {
				max = totals.get(i);
			}
		}
		
		System.out.println(max);
	}
}

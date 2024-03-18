import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> map = new HashMap<>(); //문자열들을 받아줄 배열
		//같은게 잇으면 뺄 필요가 있으니 동적으로 변환가능하게 콜렉션
		
		int num = sc.nextInt(); //들어올 문자열 갯수
		
		for(int n = 0; n < num; n++) {
			String str = sc.next();
			map.put(str, str.length()); //key를 단어로 str길이를 값으로...
			//이렇게 하면 중복되는 단어는 알아서 덮힘!
		}
		
		List<String> keySet = new ArrayList<>(map.keySet()); //키값을 기준으로 오름차순
		
		Collections.sort(keySet); //abcd 오름차순
		
		keySet.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});
		
		for(String str : keySet) {
			System.out.println(str);
		}
	}
}
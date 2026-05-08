import java.io.*;
import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int maxLen = number.length() - k;
        int[] max = new int[maxLen]; // 최대정답
        int maxIdx = 0;
        
        for(int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            // 현재 숫자가 result 배열의 마지막 숫자보다 크면 거기 말고 계속 앞으로 가야함
			while (k > 0 && maxIdx > 0 && max[maxIdx - 1] < num) {
				maxIdx--;
				k--;
			}
            
            // 현재 숫자를 result 배열에 넣음
			if (maxIdx < max.length) {
				max[maxIdx] = num;
				maxIdx++;
			} else {
				k--;
                //위의 while에서 k가 바뀌지 않은 건 지금들어올 숫자는 어디에도 들어갈 수 없다는 뜻
			}
            
        }
        
        for(int m = 0; m < maxLen; m++) {
			sb.append(max[m]);
		}
        
        return sb.toString();
	}
}
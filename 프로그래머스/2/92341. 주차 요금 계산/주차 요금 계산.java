import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int countTime = fees[2];
        int countFee = fees[3];
        
        Map<Integer, Integer> map = new HashMap<>();
        //차량번호, 누적주차시간
        Map<Integer, Integer> timeCheck = new HashMap<>();
        //차량번호, 머무른 시간
        Map<Integer, Boolean> check = new HashMap<>();
        //차량번호, IN = true, OUT = false
        
        for(int i = 0; i < records.length; i++) {
            String[] car = records[i].split(" ");
            
            int now = changeTime(car[0]);
            int carNum = Integer.parseInt(car[1]);
            
            if(car[2].equals("OUT")) {
                check.put(carNum, false);
                int nowFee = 0;
                
                //머무른 시간 계산
                int duringTime = now - timeCheck.get(carNum);
                
                //누적주차시간 합산
                map.put(carNum, map.getOrDefault(carNum, 0) + duringTime);
                
            } else {
                check.put(carNum, true);
                timeCheck.put(carNum, now);
                map.put(carNum, map.getOrDefault(carNum, 0));
            }
        }
        
        //출차기록 없는 차량
        int lastTime = changeTime("23:59");
        
        for(int carNum : check.keySet()) {
            if(check.get(carNum)) {
                int duringTime = lastTime - timeCheck.get(carNum);
                map.put(carNum, map.getOrDefault(carNum, 0) + duringTime);
            }
        }
        
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        
        int[] answer = new int[keyList.size()];
        
        //여기에서 주차요금 계산
        for(int i = 0; i < keyList.size(); i++) {
            int carNum = keyList.get(i);
            int totalTime = map.get(carNum);
            
            int nowFee = defaultFee;
            
            if(totalTime > defaultTime) {
                int overTime = totalTime - defaultTime;
                
                // 안 나눠떨어지면 올림
                int tmp = (int) Math.ceil((double) overTime / countTime);
                nowFee += tmp * countFee;
            }
            
            answer[i] = nowFee;
        }
        
        return answer;
    }
    
    public int changeTime(String s) {
        String[] time = s.split(":");
        
        int hour = Integer.parseInt(time[0]) * 60;
        int min = Integer.parseInt(time[1]);
        
        return hour + min;
    }
}
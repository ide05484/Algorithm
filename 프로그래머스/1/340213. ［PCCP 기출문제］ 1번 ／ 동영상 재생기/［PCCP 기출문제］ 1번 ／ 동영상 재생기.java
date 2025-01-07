class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        String[] video = video_len.split(":");
        String[] posTime = pos.split(":");
        String[] openingStart = op_start.split(":");
        String[] openingClose = op_end.split(":");
        
        int videoTime = calculateTime(video);
        int posNow = calculateTime(posTime);
        int opStart = calculateTime(openingStart);
        int opClose = calculateTime(openingClose);
        
        for(int i = 0; i < commands.length; i++) {
            if(opStart <= posNow && posNow <= opClose) {
                posNow = opClose;
            }
            
            if(commands[i].equals("next")) {
                posNow += 10;
                
                if(posNow > videoTime) posNow = videoTime;
            } else if(commands[i].equals("prev")) {
                posNow -= 10;
                
                if(posNow < 0) posNow = 0;
            }
            
            if(opStart <= posNow && posNow <= opClose) {
                posNow = opClose;
            }
        }
        
        int min = posNow / 60;
        int sec = posNow % 60;
        
        String minute = Integer.toString(min).length() == 1? "0" + Integer.toString(min) : Integer.toString(min);
        String second = Integer.toString(sec).length() == 1 ? "0" + Integer.toString(sec) : Integer.toString(sec);
        
        return minute + ":" + second;
    }
    
    public int calculateTime(String[] time) {
        
        int mm = Integer.parseInt(time[0]);
        int ss = Integer.parseInt(time[1]);
        
        return mm * 60 + ss;
    }
}
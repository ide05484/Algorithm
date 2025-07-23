class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletLow = Math.min(wallet[0], wallet[1]);
        int walletHigh = Math.max(wallet[0], wallet[1]);
        
        while(true) {
            int low = Math.min(bill[0], bill[1]);
            int high = Math.max(bill[0], bill[1]);
            
            if(walletLow >= low && walletHigh >= high) break;
            
            high /= 2;
            answer++;
            
            bill[0] = low;
            bill[1] = high;
        }
        
        return answer;
    }
}
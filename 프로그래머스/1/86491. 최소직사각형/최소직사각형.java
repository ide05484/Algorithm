class Solution {
    public int solution(int[][] sizes) {
        
        int maxR = 0;
        int maxC = 0;
        
        for(int r = 0; r < sizes.length; r++) {
            if(sizes[r][0] < sizes[r][1]) {
                int tmp = sizes[r][0];
                sizes[r][0] = sizes[r][1];
                sizes[r][1] = tmp;
            }
        }
                
        for(int r = 0; r < sizes.length; r++) {
           maxR = Math.max(maxR, sizes[r][0]);
           maxC = Math.max(maxC, sizes[r][1]);
        }
        
        return maxR*maxC;
    }
}
class Solution {
    public int[] solution(int brown, int yellow) {
        
        int all = brown + yellow;
        
        for(int height = 3; height <= all / 3; height++) {
            
            if (all % height == 0) {
                int width = all / height;
                
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[] {width, height};
                }
            }
        }
        
        return new int[] {};
    }
}
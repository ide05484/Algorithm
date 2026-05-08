class Solution {
    static int cnt;
    
    public int solution(int[] numbers, int target) {
        cnt = 0;
        
        dfs(numbers, 0, target, 0);
        
        return cnt;
    }
    
    public void dfs(int[] numbers, int idx, int target, int sum) {
        if(idx == numbers.length) {
            if(sum == target) cnt++;
            return;
        }
        
        int now = numbers[idx];
        dfs(numbers, idx + 1, target, sum + now);
        dfs(numbers, idx + 1, target, sum - now);
        
    }
}
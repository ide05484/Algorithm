    let dp = [];
    
    dp.push(1);
    dp.push(2);
    
    for(let i = 2; i < 60000; i++) {
        let num = (dp[i-1] + dp[i-2]) % 1000000007;
        dp.push(num);
    }

function solution(n) {
    return dp[n-1];
}
function solution(N, stages) {
    
    let game = new Array(N+2).fill(0); //게임 스테이지별 실패율 담을 배열
    
    for(let user of stages) {
        game[user]++; //개수 세기
    }
    
    let totalUsers = stages.length; // 전체 사용자 수
    let fail = [];
    
    for (let i = 1; i <= N; i++) {
        if (totalUsers === 0) {
            fail.push({ stage: i, failRate: 0 });
        } else {
            let failRate = game[i] / totalUsers; // 실패율 계산
            fail.push({ stage: i, failRate: failRate });
            totalUsers -= game[i]; // 클리어한 사용자 수 업데이트
        }
    }
    
    // for(let i = N; i >= 1; i--){
    //     let sum = 0;
    //     for(let j = N+1; j >= i; j--) {
    //         sum += game[j];
    //     }
    //     fail.push({stage: i, failrate: game[i] / sum});
    // }
    
    fail.sort((a,b) => {
        if(a.failRate === b.failRate) {
            return a.stage - b.stage;
        }
        return -(a.failRate - b.failRate);
    })
   
    
    return fail.map(item => item.stage);
}
function solution(n, works) {
    
    //n시간 내에 다 처리할 수 있을 때...
    if (works.reduce((a, b) => a + b, 0) <= n) {
        return 0;
    }

    works.sort((a, b) => b - a);

    while (n > 0) {
        if (works[0] > 0) {
            works[0]--;
            n--;
        }

        // 첫 번째 작업량이 그 다음으로 큰 작업량보다 작아졌다면, 위치를 재조정
        let i = 0;
        
        while (i < works.length - 1 && works[i] < works[i + 1]) {
            // swap 작업량의 위치
            [works[i], works[i + 1]] = [works[i + 1], works[i]];
            i++;
        }
    }
    
    return works.reduce((acc, work) => acc + Math.pow(work, 2), 0);;
}
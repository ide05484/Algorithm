function solution(numbers) {
    
    let check = []; //만들어지는 모든 배열
    
    for(let i = 0; i < numbers.length; i++){
        check.push(numbers.charAt(i)); //선택하지 않음으로 처리
    }
    
    let countArr = []; //소수판별해서 들어갈 배열
    
    //소수검사
    const isPrime = (num) => {
        if (num < 2) return false;
        if (num === 2) return true;
        
          for(let i = 2; i < num; i++){
                if(num % i === 0){
                    //나누어 떨어지면
                    return false;
                }
            }
        return true;
    }
    
    // 순열 만들기
    const getPermutation = (arr, fixNum) => {
        //넘겨온 배열이 있을 때만!
        if(arr.length >= 1) {
            
            for (let i=0; i<arr.length; i++) {
                const newNum = fixNum + arr[i]; //만들어진 새 숫자
                
                const copyArr = [...arr];                
                copyArr.splice(i, 1);
                
                if (!countArr.includes(+newNum) && isPrime(+newNum)){
                    countArr.push(+newNum) 
                }
                
                getPermutation(copyArr, newNum); 
            }
        }
    }
    
    getPermutation(check, '');

    return countArr.length;
}
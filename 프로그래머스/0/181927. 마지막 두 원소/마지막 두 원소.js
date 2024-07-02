function solution(num_list) {
    let arr = num_list; //입력받고
    
    //배열 변경해줍니다
    if(arr[arr.length - 1] > arr[arr.length - 2]){
        arr.push(arr[arr.length - 1] - arr[arr.length - 2]);
    } else {
        arr.push(2*arr[arr.length - 1]);
    };
    
    return arr;
}
# [[11931]수 정렬하기 4](https://www.acmicpc.net/problem/11931)

## Sort를 이용한 풀이

- 첫 시도는 `List`의 내장함수 `sort`를 이용하여 풀었으나 ~~시간 초과로 실패~~ 

- 두번째 시도

    - 입력값의 범위인 -1000000 ~ 1000000 만큼의 배열을 만들어줍니다.
    
        ```java
         int[] arr = new int[2000001];
        ```
    
    - 만약 입력값이 들어오면 배열을 카운트 해줍니다.
    
        ```java
        arr[tmpInt+1000000]++;
        ```
      
    - 배열의 끝부터 맨 앞까지 탐색하며 값이 1인 경우(중복 없음), StringBuffer에 넣어줍니다.
    
        ```java
        for (int i=1000000;i>=-1000000;i--) {
            if (arr[i+1000000]!=0) {
                sb.append(i);
                sb.append("\n");
            }
        }
        ```
    
### 출력 시 주의사항<br>

`System.out.println`을 계속 사용하는 것은 시간 초과를 발생합니다.<br>
`StringBuffer`를 사용해 출력할 결과물을 계속 추가하고, 마지막에 `toString()`으로 출력해주는 방식을 이용합니다.<br>
# [[1722]순열의 순서](https://www.acmicpc.net/problem/1722)

## Mathematics을 이용한 풀이

### 소문제 번호 1<br>

- N = 5라고 가정했을 때 첫자리수가 결정되고 올 수 있는 순열의 수는 `(N-1)!`이다.

    ```java
    1 x x x x  ==> 4!
    2 x x x x  ==> 4!
    3 x x x x  ==> 4!
    4 x x x x  ==> 4!
    5 x x x x  ==> 4!
    
    1 2 x x x  ==> 3!
    1 2 3 x x  ==> 2!
    ...
    ```
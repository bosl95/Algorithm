# [[1021]회전하는 큐](https://www.acmicpc.net/problem/1021)

## Stack을 이용한 풀이

### 문제 해결 방식<br>

1. deque를 이용하여 큐를 만들어 1 ~ N까지의 수를 넣어준다.
2. 현재 찾는 숫자인 a<sub>i</sub>의 인덱스를 구해준다.
    1. 현재 인덱스 idx > 배열길이 - idx 이면 오른쪽으로 이동 (rotate(-idx))
    2. 현재 인덱스 idx < 배열길이 - idx 이면 왼쪽으로 이동 (rotate(n-idx))
3. 현재 인덱스 0인 숫자를 pop한다.(찾는 숫자가 인덱스 0인 상태이므로)
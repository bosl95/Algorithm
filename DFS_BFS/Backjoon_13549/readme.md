# [[13549]숨바꼭질](https://www.acmicpc.net/problem/13549)

## BFS/DFS를 이용한 풀이

- BFS를 이용하여 풀면 되는 문제
- 하지만 예외사항을 잘 고려해야한다.

<br>

### 주의사항<br>

- 수빈이와 동생의 위치가 동일한 경우 예외처리
- 방문 배열 `visit`의 크기 : `0<=n, k<= 100,000`이므로 200001로 지정
- `visit[mx] = visit[x] + 1`에서 재방문을 피하는 방법
  - `visit`을 `Integer.MAX_VALUE`로 초기화한다.
  - `visit[n] = 0`으로 지정해주고, `visit[mx] > visit[x] + 1 or visit[x]` 인 경우에 방문해준다.
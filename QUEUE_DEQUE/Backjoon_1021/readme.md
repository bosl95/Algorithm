# [[1021]회전하는 큐](https://www.acmicpc.net/problem/1021)

## Queue를 이용한 풀이

- 뽑아내려고 하는 수들을 `StringTokenizer`를 통해 하나씩 탐색한다.
- 왼쪽으로 이동, 오른쪽으로 이동 중 최소 이동 거리를 구해준다.

```java
move += Math.min(tmp, queue.size()-tmp);
```

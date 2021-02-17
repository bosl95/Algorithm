# [[7569]토마토](https://www.acmicpc.net/problem/7569)

## BFS/DFS를 이용한 풀이

- [[7576]토마토](https://www.acmicpc.net/problem/7576)를 3차원으로 구현하는 문제
- 상자 앞 뒤를 체크해주는 범위를 추가해주면 된다.

```java
int[] dx = {-1, 1, 0, 0, 0, 0};
int[] dy = {0, 0, -1, 0, 1, 0};
int[] dz = {0, 0, 0, -1, 0, 1};
```
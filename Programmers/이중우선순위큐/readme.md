# [이중우선순위큐](https://programmers.co.kr/learn/courses/30/lessons/42628)

## 풀이

- 처음에는 우선순위큐 하나로 풀려고 했으나, 리프 노드에만 접근이 가능하고 루트 노드는 접근할 수 있는 방법이 없었다.
- 따라서 최소 -> 최대순으로 정렬된 우선순위큐와 최대 -> 최소순으로 정렬된 우선순위큐를 사용
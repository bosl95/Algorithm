# [[11279]최대힙](https://www.acmicpc.net/problem/11279)

## Heap을 이용한 풀이

### [[1927]최소힙](https://github.com/bosl95/Algorithm/tree/master/HASH_BINARY%20SEARCH_HEAP/%5B1927%5D%EC%B5%9C%EC%86%8C%ED%9E%99) 과 매우 유사한 문제<br>
### 다만, 파이썬의 heapq 모듈은 최소힙인데 이를 최대 힙으로 쓰기 위해서는 값을 삽입할 때 `-value`형태로 넣으면 값이 거꾸로 들어가기 때문에 최대값을 먼저 구해줄 수 있다.<br>
### 값을 pop할 때 다시 음수를 붙여서 처리해주는 것이 주의하자.
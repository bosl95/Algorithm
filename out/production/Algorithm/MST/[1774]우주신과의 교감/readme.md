# [1774] 우주신과의 교감

## Kruskal 알고리즘을 이용한 풀이

#### 풀이는 크루스칼 알고리즘을 그대로 적용하면 되는 문제이다.
#### 계속 시간 초과가 났는데, 

	 for i in range(n):
	        for j in range(i+1, n):
	            if [i+1, j+1] in ms or [j+1, i+1] in ms:
	                a, b = find(i), find(j)
	                if a != b:
	                    union(a, b)
	                    cnt += 1
	                continue
	            w = calc(ns[i][0], ns[i][1], ns[j][0], ns[j][1])
	            heapq.heappush(h, (w, i, j))

#### 정점들을 방문하면서 이미 연결된 노드를 찾는 if문에서 시간 초과가 발생한다.
#### ``if  [u, v] in arr``을 사용하지 않도록,<br>
#### 연결된 노드들을 입력 받으면서 바로  union 함수에 넣어주고, 방문하지 않은 나머지 노드들만 우선순위 큐에 넣어서 가장 빠른 연결 통로를 구해주는 방식으로 푸니 통과하였다.
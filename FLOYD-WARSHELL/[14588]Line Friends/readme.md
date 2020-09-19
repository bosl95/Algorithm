# [[14588]Line Friends](https://www.acmicpc.net/problem/14588)

## Floyd를 이용한 풀이

<image src="https://lh4.googleusercontent.com/ZIp5hEP4uDcgUmYakZNrSN0gpLbpsndTQ9EacBRXwVlwssZ1liEJ1o8trqh3r1aAJ-6PQODkascu_-i3wzXDGB4rhAQLX_q_yo2aGbfv9696U02oQu0qpSsyCI5SDDEyySC9YGRy" width="70%">

### 우선, 처음 접근하려고 했던 방법은 Graph 알고리즘 + BFS를 떠올렸다.<br>
#### 그러나 각 캐릭터마다 만나는 친구들을 배열에 저장하는 부분에서 ``위의 포함되지 않는 경우``를 바로 떠올리지 못했다.

<br>

### 그리고 보게 된 풀이는 아래와 같다.

### 1. 노드를 담는 배열과 선분을 나타낼 배열을 만들어준다. (이때, ``connect[i][i] = 0으로 만들어줘야함에 주의한다. ``⇒ 플로이드 알고리즘에서 0이 아니면 오류가 발생한다.)

	N = int(input())  
	Nodes, connect = [], []  
	Max = sys.maxsize  
	  
	for i in range(N):  
	    L, R = map(int, input().split())  
	    Nodes.append([L, R])  
	    connect.append([Max]*N)  
	    connect[i][i] = 0

### 2. 서로 교차하는 노드들, 즉 친구인 애들의 connect 배열(선분)을 1로 설정한다.

	for i in range(N):  
	    for j in range(N):  
	        if i==j or Nodes[i][1] < Nodes[j][0] or Nodes[j][1] < Nodes[i][0]: continue  
			connect[j][i] = 1  
			connect[i][j] = 1

### 3. 플로이드 알고리즘 통해 최단 경로를 구한다.

	for k in range(N):  
	    for i in range(N):  
	        for j in range(N):  
	            if connect[i][j] > connect[i][k] + connect[k][j]:  
	                connect[i][j] = connect[i][k] + connect[k][j]
	                
### 4. 각 캐릭터 두명을 입력받고 두 캐릭터가 친구인지 확인한다. (친구가 아닌 경우 무한대 값을 가지고 있을 것이며 -1로 출력한다.)

	Q = int(input())  
	for _ in range(Q):  
	    A, B = map(int, input().split())  
	    print(-1 if connect[A-1][B-1]==Max else connect[A-1][B-1])

### 결과적으로는 Python에서 시간초과가 발생했다. Pypy로 풀어 통과 할 수 있었다.

<br>

## Graph를 이용한 또 다른 풀이

### 이 방법이 처음에 내가 구현하고자 했던 Graph+BFS를 이용한 방식



	import sys  
	from collections import deque  
	  
	input =sys.stdin.readline  
	  
	N = int(input())  
	Nodes = [0] + [list(map(int, input().split())) for _ in range(N)]  
	  
	con = [[] for _ in range(N+1)]  
	for i in range(1, N+1):  
	    for j in range(1, N+1):  
	        if Nodes[i][1] >= Nodes[j][0] or Nodes[j][1] >= Nodes[i][0]:  
	            con[i].append(j)  
	  
	  
	def solution(l, r):  
	    stack = deque([l])  
	    chk = [0] * (N+1)  
	    chk[l] = 1  
		while stack:  
	        x = stack.popleft()  
	        for v in con[x]:  
	            if chk[v] == 0:  
	                chk[v] = chk[x]+1  
					stack.append(v)  
	                if v==r:  
	                    return chk[x]  
	    return -1  
	  
	  
	Q = int(input())  
	for _ in range(Q):  
	    A, B = map(int, input().split())  
	    print(solution(A, B))

### 선분 배열에 해당하는 조건을 알게 되고 나서 구현하는 것은 쉬웠다. <br>
### Graph+BFS로 풀면 python에서 통과할 수 있었다.
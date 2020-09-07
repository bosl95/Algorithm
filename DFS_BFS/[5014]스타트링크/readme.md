> ### [[5014]스타트링크](https://www.acmicpc.net/problem/5014)

> #### 입력
	10 1 10 2 1
> #### 출력
	6
> #### 입력 2
	100 2 1 1 0	
> #### 출력 2
	use the stairs

> #### BFS를 이용한 알고리즘
> ##### 풀이는 그냥 일반적인 BFS를 이용한 방식이었다. 처음에 답이 틀렸을 때, 대신 위로 U만큼 가는 경우와 아래로 D만큼 가는 경우에서 두 경우가 각각 동시에 이뤄질 수 있다는 점만 수정하여 풀었다.

> #### code 
	from collections import deque  
  
	def solution(F, S, G, U, D):  
	    visit = [0]*(F+1)  
	    stack = deque([S])  
	    while stack:  
	        x = stack.popleft()  
	        v = visit[x]  
	        if x == G:  
	            return visit[x]  
	        if x+U <= F and visit[x+U]==0:  
	            visit[x+U] = v+1  # 처음에 v대신 visit[x]를 그대로 써주었더니 계속 값이 변경되어 오답이 처리되었다.
	  stack.append(x+U)  
	        if x-D > 0 and visit[x-D]==0:  
	            visit[x-D] = v+1  
	  stack.append(x-D)  
	    return "use the stairs"  
	  
	f, s, g, u, d = map(int, input().split())  
	print(solution(f, s, g, u, d))
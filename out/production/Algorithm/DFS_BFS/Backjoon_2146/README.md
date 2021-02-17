> [[2146]다리만들기](https://www.acmicpc.net/problem/2146)

>  #### 입력
	10
	1 1 1 0 0 0 0 1 1 1
	1 1 1 1 0 0 0 0 1 1
	1 0 1 1 0 0 0 0 1 1
	0 0 1 1 1 0 0 0 0 1
	0 0 0 1 0 0 0 0 0 1
	0 0 0 0 0 0 0 0 0 1
	0 0 0 0 0 0 0 0 0 0
	0 0 0 0 1 1 0 0 0 0
	0 0 0 0 1 1 1 0 0 0
	0 0 0 0 0 0 0 0 0 0
> #### 출력
	3
> #### BFS를 이용한 알고리즘
 1. 존재하는 섬이 몇개인지 파악
 2. 각 섬마다 다른 섬에 도착하는 최단 거리를 확인한다. (BFS)
<br>
이 방법을 통해서 푸는 것을 시도, visit 배열과 arr배열을 전역으로 선언해줘 푸는 경우는 통과
그러나 solution 함수를 지정하여 푸는 경우 이동하는 배열이 많고, 메모리 초과가 발생. ( 다시 한번 체크하기)
<br>

> #### code
	import sys  
	from collections import deque  
	  
	input = sys.stdin.readline  
	  
	dx = [0, 0, 1, -1]  
	dy = [1, -1, 0, 0]  
	  
	  
	def bfs(start, cnt):  
	    visit[start[0]][start[1]] = cnt  
	    q = deque([start])  
	    tmp = deque()  
	  
	    while q:  
	        x, y = q.popleft()  
	        for i in range(4):  
	            mx = x + dx[i]  
	            my = y + dy[i]  
	            if 0 <= mx < n and 0 <= my < n:  
	                if visit[mx][my] == 0:  
	                    if arr[mx][my] == 1:  
	                        visit[mx][my] = cnt  
	                        q.append([mx, my])  
	                    elif arr[mx][my] == 0 and [x, y] not in tmp:  
	                        tmp.append([x, y])  
	    return tmp  
	  
	  
	def bfs2(stack, cnt):  
	    visit2 = [[0] * n for _ in range(n)]  
	  
	    while stack:  
	        x, y = stack.popleft()  
	        for i in range(4):  
	            mx = x + dx[i]  
	            my = y + dy[i]  
	            if 0 <= mx < n and 0 <= my < n:  
	                if arr[mx][my] == 1 and visit[mx][my] != cnt:  
	                    return visit2[x][y]  
	                if arr[mx][my] == 0 and visit2[mx][my] == 0:  
	                    visit2[mx][my] = visit2[x][y] + 1  
	  stack.append([mx, my])  
	  
	  
	def solution(m, world):  
	    i_cnt = 1  
	  start = []  
	  
	    for i in range(m):  
	        for j in range(m):  
	            if world[i][j] == 1 and visit[i][j] == 0:  
	                start.append(bfs((i, j), i_cnt))  
	                i_cnt += 1  
	  
	  
	  res = bfs2(start[0], 1)  
	    for i in range(1, i_cnt - 1):  
	       res = min(res, bfs2(start[i], i + 1))  
	  
	    return res  
	  
	n = int(input())  
	arr = [list(map(int, input().split())) for _ in range(n)]  
	visit = [[0] * n for _ in range(n)]  
	print(solution(n, arr))  

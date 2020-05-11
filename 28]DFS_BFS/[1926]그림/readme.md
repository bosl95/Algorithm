> ### [[1926]그림](https://www.acmicpc.net/problem/1926)
> 어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.

> #### 입력
	6 5
	1 1 0 1 1
	0 1 1 0 0
	0 0 0 0 0
	1 0 1 1 1
	0 0 1 1 1
	0 0 1 1 1
> #### 출력
	4
	9	
> #### DFS를 이용한 알고리즘
* 방문한 곳을 체크해주는 배열 visit (방문했으면 1 아니면 0 )
* 도화지 배열 arr=1이면 그때의 해당 인덱스를 시작으로 DFS를 실행한다
* 이때, 방문한 만큼 count해주고 최대 넓이를 찾아 max에 지정해준다.

> #### code
	import sys; input = sys.stdin.readline  
	n, m = map(int, input().split())  
	arr = [ list(map(int, input().split())) for _ in range(n) ]  
	  
	def solution(n, m, arr):  
	    visit = [[0]*m for _ in range(n)]  
	    count = 0; max=0  
	  for i in range(n):  
	        for j in range(m):  
	            if visit[i][j]==0 and arr[i][j]==1:  
	                cnt = DFS(i, j, n, m, visit, arr)  
	                if max < cnt:  
	                    max = cnt  
	                count += 1  
	  return (count, max)  
	  
	def DFS(i, j, n, m, visit, arr):  
	    stack = [(i, j)]  
	    count = 0  
	  while stack :  
	        i, j = stack.pop()  
	        if visit[i][j]==0: count+=1  
	  visit[i][j] = 1  
	  
	  for mx, my in [0, 1], [1, 0], [-1, 0], [0, -1]:  
	            mi = i + mx  
	            mj = j+ my  
	            if 0<=mi<n and 0<= mj <m and visit[mi][mj]==0 and arr[mi][mj]==1:  
	                stack.append((mi, mj))  
	    return count  
	  
	a, b = solution(n, m, arr)  
	print("{}\n{}".format(a, b))
##### 코딩 테스트와 유사하게 만들어 해보았는데 시간차는 얼마 나지 않았다.
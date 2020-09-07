> ### [[2468]안전영역](https://www.acmicpc.net/problem/2468)

> #### 입력
	5
	6 8 2 6 2
	3 2 3 4 6
	6 7 3 3 2
	7 2 5 3 6
	8 9 5 2 7
> #### 출력
	5
> #### DFS를 이용한 알고리즘
*  seta : 배열의 원소값을 set() 형태로 가짐
* cnt : 안전 영역의 개수 중 최대값 (default = 1)
* cnt의 디폴트값을 1로 둔 이유는 안전영역의 모든 값이 하나의 수로 통일된다면 1개의 영역을 가지므로 cnt는 최소 1을 가진다.
* 영역을 구해주는 부분은 DFS를 이용하여 풀 수 있다.
> #### code

    import sys; input=sys.stdin.readline  
	def area(arr, h, n):  
	    cnt = 0  
		visit = [[0] * n for _ in range(n)]  
  
    for i in range(n):  
        for j in range(n):  
            if arr[i][j] > h and visit[i][j]==0:  
                cnt += 1  
				stack = [(i, j)]  
                while stack:  
                    x, y = stack.pop()  
                    visit[x][y] = 1  
					for m1, m2 in (-1, 0), (0, -1), (1, 0), (0, 1):  
	                        mx = x + m1  
	                        my = y + m2  
	                        if 0<=mx<n and 0<=my<n and arr[mx][my] > h and visit[mx][my]==0:  
	                            stack.append((mx, my))  
	    return cnt  
	  
	def solution(n, arr):  
	    cnt = 1  
		seta = set()  
  
    for a in arr:  
        seta = seta | set(a)  
  
    for s in seta:  
        x = area(arr, s, n)  
        if cnt < x:  
            cnt = x  
    return cnt  
  
	n = int(input())  
	arr = [list(map(int, input().split())) for _ in range(n)]  
	print(solution(n, arr))
> ### [[1074]Z](https://www.acmicpc.net/problem/1074)
N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.
![enter image description here](https://www.acmicpc.net/upload/201003/z2.JPG)
> #### 입력
	2 3 1
> #### 출력
	11
> #### 입력2
	3 7 7
> #### 출력2
	63
> #### 재귀를 이용한 알고리즘
##### 처음 재귀를 풀어보았을 때, 출력 초과가 떴다. (보통 출력 초과는 무한루프 돌거나 틀린 경우라고 함.)
	import sys; input = sys.stdin.readline  
	n, r, c = map(int, input().split())  
	  
	def visit(start , search, cnt, n):  
	    x, y = map(int, start)  
	    r, c = map(int, search)  
	    m = n//2  
	  
	  if m==1:  
	        for a, b in [0, 0], [0, 1], [1, 0], [1, 1]:  
	            if [r, c] == [x+a, y+b]:  
	                print(cnt)  
	                return  
	  cnt += 1  
	  
	  if r < x+m and c < y+m:  
	        visit([x,y], search, cnt+(2**m)*0, m)  
	    elif r < x + m and y + m <= c:  
	        visit([x, y+m], search, cnt+(2**m)*1, m)  
	    elif x + m <= r and c < y + m:  
	        visit([x+m, y], search, cnt+(2**m)*2, m)  
	    else:  
	        visit([x+m, y+m], search, cnt+(2**m)*3, m)  
	  
	visit([0, 0], [r, c], 0, 2**n)
> #### 분할정복을 이용한 알고리즘
* 1, 2, 3, 4사분면 중 어디에 해당되는 지 찾아가면서 그에 해당하는 숫자를 구해주는 방식.
* 반복문을 통해서 몇 사분면인지 찾아주고 그 사분면 첫번째 값에 해당하는 숫자를 찾아줬다.
* 마지막으로 2*2행렬이 되었을때(n=1) 1, 2, 3, 4분면중 위치를 찾아 그 값을 리턴 
> #### code
	def f(n, r, c):  
	    num = 0  
	  while True:  
	        if n == 1 or n // 2 == 1:  
	            if (r, c) == (0, 0):  
	                return num  
	            elif (r, c) == (0, 1):  
	                return num + 1  
	  elif (r, c) == (1, 0):  
	                return num + 2  
	  else:  
	                return num + 3  
	  n //= 2  
	  if r < n and n <= c:  # 2사  
	  c -= n  
	            num += (n ** 2) * 1  
	  elif n <= r and c < n:  # 3사  
	  r -= n  
	            num += (n ** 2) * 2  
	  elif n <= r and n <= c:  # 4사  
	  c -= n;  
	            r -= n  
	            num += (n ** 2) * 3  
	  
	n, r, c = map(int, input().split())  
	print(f(2 ** n, r, c))
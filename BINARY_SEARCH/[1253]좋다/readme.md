# [[1253]좋다](https://www.acmicpc.net/problem/1253)

## Two Pointer를 이용한 풀이

### 처음 풀었던 코드는 dictionary와 set을 이용해서 개수를 구해주려고 했는데, 문제를 잘못이해했던 것이었다.

	import sys
	input = sys.stdin.readline

	def solution(N, a):
	    check, ans = dict(), set()

	    for _a in a:
	        check[_a] = True

	    for i in range(n):
	        for j in range(i+1, n):
	            x = a[i]+a[j]
	            if check.get(x):
	                ans.add(x)
	    return len(ans)

	n = int(input())
	A = list(map(int, input().split()))
	print(solution(n, A))

### 문제를 보다 쉽게 이해하기 위해 바로 반례 3가지를 이야기하자면,

	# 반례 1  
	8  
	1 2 3 4 5 5 5 5 ==> 답 : 6  
	  
	# 반례 2  
	7  
	0 0 0 3 3 3 3 ==> 답 : 7  
	
	# 반례 3  
	6  
	0 0 3 3 3 3 ==> 답 : 4

### 1. 각 배열의 숫자들이 "좋은" 숫자가 될 수 있는 지 체크해야하고,<br>
### 2. c라는 원소가 "좋은" 숫자인지 체크할 때, 비교할 두 대상 a, b가 c이면 안된다. (반례2와 반례3을 통해 알 수 있다.)<br>
### 3. c라는 원소가 "좋은" 숫자인지가 체크되면 "좋은 숫자"로 해당되는 두 대상 a,b가 몇개가 였든지 상관없다.<br>

<br>

### 1번을 체크하는 과정을 투 포인터를 이용하였고 <br>
### 주의사항 : "배열이 내림차순이 아니다"
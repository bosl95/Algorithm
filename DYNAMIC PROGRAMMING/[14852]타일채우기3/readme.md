# [[14852]타일 채우기3](https://www.acmicpc.net/problem/14852)

## Dynamic Programming을 이용한 풀이

<image src="https://lh5.googleusercontent.com/8YG0EKsa2WCfqboKVlj2nN7Hfr7wGs-VLGfTm5yaxydUJSiW5rvLr5peAgUrYl3MuM369oW5twYL-mj30EozmFfPetoJ7Pt0fEtyPwJllAkOfcLiicxB8BCyEszSlSs-1D4Nnavh" width="70%">

### 난이도가 높았던 문제.<br>
###  우선 DP[i]를 DP[i-1] ~ DP[0]를 통해서 접근하기 위해서는 i+1이 될 때마다 추가되는 블록을 확인해야한다. <br>
### 위의 그림을 보면, DP[N-2] 와 2x2 블록으로 나누어졌을 때 ``2x2 블록이 새로운 블록 3개를 가지고 나머지는 2개를 갖는다.`` <br>
### 따라서 DP[n-3] ~ DP[0] 까지를 묶어서 i+1 될때마다 합을 DP2라는 변수에 저장하였다.

<br>

### 런타임 에러가 발생 
#### 1. 재귀 함수 사용 불가능
#### 2. 반복문 실행 시 ⇒ DP를 계속 인덱스를 통해 탐색하는 과정도 시간이 오래 걸려서 인지 런타임 에러가 발생했다.

<br>

### 해결 방법

	import sys  
	input=sys.stdin.readline  
	  
	def solution(n):  
	    a, b, c = 1, 2, 7  
	  dp2 = a  
	    if n==0: return a  
	    if n==1: return b  
	    if n==2: return c  
	  
	    for i in range(3, n+1):  
	        a, b, c = b, c, (2*c+3*b+2*dp2) % 1000000007  
	  dp2 = (dp2 + a) % 1000000007  
	  
	  return c % 1000000007  
	  
	N = int(input())  
	print(solution(N))

### DP를 배열로 따로 쓰지 않고, 변수를 사용해 그때그때 값을 변경해주어 계산하였더니 통과
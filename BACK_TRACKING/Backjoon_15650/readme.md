## [[15650]N과M(2)](https://www.acmicpc.net/problem/15650)

> 입력

	3 1

> 출력

	1
	2
	3

> 입력

	4 2

> 출력

	1 2
	1 3
	1 4
	2 3
	2 4
	3 4

> ####  backtracking을 이용한 풀이
앞의 [15649]번 문제에서 증가 수열인 값만 출력해주는 문제였기 때문에
반복문에서

	if i not in a and a[-1] < i:

뒤에 문장을 추가하였다.
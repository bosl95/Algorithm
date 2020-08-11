## [[12865]평범한 배낭](https://www.acmicpc.net/problem/12865)

> 입력

	4 7
	6 13
	4 8
	3 6
	5 12

> 출력

	14

> #### Dynamic Programming을 이용한 풀이
**![](https://lh4.googleusercontent.com/7eLoAI5hqrUI7KnwbB6f0uKOY5_NWZDxV9c7RfKOH4XuPwWI-bEqPiisXjAt3wHUAMdcwCV-WMx4V6a1s53F866VvWA8gTVolLs-ZSA1RNY-Fzjoq5jLpWbt8pbGZffCBNBagSek)**

처음에 재귀함수를 이용해서 풀었으나 시간초과가 발생했다.
이어서 DP로 시도.
처음에 
	
	for i in range(w, k+1):
                dp[i] = max(dp[i], v+dp[i-w])

dp의 앞부분터 들어가서 뒤의 dp가 앞에서 바뀐 dp의 값에 영향을 받아 잘못된 결과값이 나왔다.
⇒ dp의 맨뒤부터 앞쪽으로 탐색하도록 바꿔주었다.

그리고 처음에

	dp[i] = max(dp[i], v+max(dp[:i-w+1]))

이렇게 설정해주었는데, 뒤에 max함수는 굳이 쓰지 않아도 dp[i-w] 값이 제일 큰 값을 가졌다.

[예시]

	# 입력값
	5 10
	1 4
	1 5
	1 3
	1 1
	1 2
	
	# dp 값
	[0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
	[0, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3]
	[0, 3, 5, 6, 6, 6, 6, 6, 6, 6, 6]
	[0, 4, 7, 9, 10, 10, 10, 10, 10, 10, 10]
	[0, 5, 9, 12, 14, 15, 15, 15, 15, 15, 15]
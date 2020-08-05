
## [[9663]N-Queen](https://www.acmicpc.net/problem/9663)

> 입력

	8

> 출력

	92

> Backtracking 알고리즘을 이용한 풀이.
1) 열 / 대각선들의 규칙을 체크해주는 방법.
![image](https://user-images.githubusercontent.com/34594339/89256474-263d2500-d65f-11ea-8934-194fd8fb360c.png)
2) backtracking

		if left[k+l] + right[n+k-l-1] + col[l] == 0:  
		    left[k+l], right[n+k-l-1], col[l] = 1, 1, 1  
		    queen(k)  
		    left[k + l], right[n + k - l - 1], col[l] = 0, 0, 0

3) 파이썬의 문제.
파이썬으로 backtracking을 이용해 푸는 것은 시간 초과가 발생한다.
pypy3로 하면 통과.
backtracking 문제는 파이썬을 피하는 것이 좋음.

~~56ms로 푼 사람들은 N이 0에서 15의 값을 가지기 때문에 정답값을 그냥 배열에 넣어서 결과값을 출력했다.~~
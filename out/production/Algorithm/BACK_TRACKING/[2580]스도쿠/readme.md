## [[2580]스도쿠](https://www.acmicpc.net/problem/2580)

> 입력

	0 3 5 4 6 9 2 7 8
	7 8 2 1 0 5 6 0 9
	0 6 0 2 7 8 1 3 5
	3 2 1 0 4 6 8 9 7
	8 0 4 9 1 3 5 0 6
	5 9 6 8 2 0 4 1 3
	9 1 7 6 5 2 0 8 0
	6 0 3 7 0 1 9 5 2
	2 5 8 3 9 4 7 6 0

> 출력

	1 3 5 4 6 9 2 7 8
	7 8 2 1 3 5 6 4 9
	4 6 9 2 7 8 1 3 5
	3 2 1 5 4 6 8 9 7
	8 7 4 9 1 3 5 2 6
	5 9 6 8 2 7 4 1 3
	9 1 7 6 5 2 3 8 4
	6 4 3 7 8 1 9 5 2
	2 5 8 3 9 4 7 6 1

> ### BackTracking을 이용한 알고리즘

**![](https://lh6.googleusercontent.com/9x_VJGrAPnDTw9S5M3KtX5CxKWy3EXdEIQCq5huH6yKEVwiROe69RzaUk7SI1rd8AtYr1KxwlKl1mGZsvdHAkv1YfSrMQu7qgP2roLpynH2NZAD3ZfcSU4luPMbB1nY9k_T_ocUl)**

9X9 판을 입력받고 그 중 0인 값 즉 비어있는 칸의  인덱스 i, j를 따로 배열 zero에 저장한다.

1) 이때 빈칸의 인덱스를 저장한 배열 zero에서 하나씩 leftpop() 하면서 그 안에 들어갈 수 있는 숫자가 있으면 삽입하고 없는 경우 인덱스를 zero 배열 맨 뒤에 다시 추가하는 방식으로 코드를 짰다.
⇒ ~~Python도 pypy3도 시간초과 발생~~
2) 빈칸의 인덱스에 삽입할 수 있는 숫자를 받아와 삽입한 상태로 다음 빈칸으로 넘어가는 방식. 만약에 삽입할 수 있는 인덱스가 없는 경우 다시 돌아와 다른 숫자를 대입하는 작업을 반복해서 실행한다.

		for p in chkList:  	# 유망한 숫자 리스트 chkList
		    b[i][j] = p  			# 숫자 삽입
		    dfs(x+1, b, z)  	# 다음 빈칸으로 이동하기
		    b[i][j] = 0				# 스도쿠를 완료하지 못했다면 다시 값을 원위치로 

⇒ Python은 90%에서 시간초과가 발생했다. 그러나 Pypy3에서는 통과하긴 함.

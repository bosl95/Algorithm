### [1018] 체스판 다시 칠하기

> 입력

	8 8
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBBBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW

> 출력

	1

> 입력

	10 13
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	BBBBBBBBWBWBW
	BBBBBBBBBWBWB
	WWWWWWWWWWBWB
	WWWWWWWWWWBWB

> 출력

	12

> #### brute force를 이용한 풀이
8*8에서 문제의 규칙을 적용한 체스판은 

	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW

혹은

	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB
	BWBWBWBW
	WBWBWBWB

두 경우이다.
두 배열의 차이는 첫번째줄이 ``BWBWBWBW`` 으로 시작해서 ``WBWBWBWB``로 이어지는 패턴과 반대 패턴, 두가지 경우 이므로 

	chess = [wb, bw, wb, bw, wb, bw, wb, bw, wb]

chess 배열의 0행~8행까지를 위의 첫번째 배열
1행부터 9행까지를 두번째 배열로 두고 8*8 배열을 사용하였다.
그리고 주어진 입력값에서 8*8만큼씩 저 두 배열과 함께 비교하면서 최소값을 찾는 brute force문제였다.
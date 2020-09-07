> ### [[1874]스택 수열](https://www.acmicpc.net/problem/1874)

> 입력

	8
	4
	3
	6
	8
	7
	5
	2
	1

> 출력

	+
	+
	+
	+
	-
	-
	+
	+
	-
	+
	+
	-
	-
	-
	-
	-

> 스택을 이용한 풀이
- x : 1 ~ n 까지의 순차적인 배열
- arr : 찾고자 하는 수열을 나타내는 입력값 배열
- result : push하면 '+', pop하면 '-'를 저장

1. stack에 x를 push하기 전에 arr[i] 값이 있는 지 확인하며 stack에서 pop해주기.
	 1-1. stack에서 pop을 하는 경우 result에 '-' 삽입
2. x를 stack에 push. ( result에 '+' 삽입)
4. 만약 stack에 더이상 push할 게 없다면 루프를 빠져오나오는데,
	3-1. stack에 값이 존재하면서 stack에서 pop한 값이 arr 배열의 순서와 일치하지 않다면 "NO"
	3-2. stack과 arr이 모두 일치하거나 stack에 값이 없으면 return result
> ## [[10845]큐](https://www.acmicpc.net/problem/10845)
-   push X: 정수 X를 큐에 넣는 연산이다.
-   pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
-   size: 큐에 들어있는 정수의 개수를 출력한다.
-   empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
-   front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
-   back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
> #### 입력
	15
	push 1
	push 2
	front
	back
	size
	empty
	pop
	pop
	pop
	size
	empty
	pop
	push 3
	empty
	front
> #### 출력
	1
	2
	2
	0
	1
	2
	-1
	0
	1
	-1
	0
	3
##### input() -> 시간 초과
##### sys.stdin.readline 으로 해결 
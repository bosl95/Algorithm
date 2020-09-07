> ### [[10773]제로](https://www.acmicpc.net/problem/10773)

> 입력

	4
	3
	0
	4
	0
> 출력

	0

> ### 풀이
**스택을 이용한 간단한 문제.**
다만, 입력값을 받을 때 input()이 아닌 sys.stdin.readline을 통해서 입력받는 경우 시간이 단축.
- input()과 sys.stdin.readline의 차이?
	- sys.stdin.readline()
	띄어쓰기와 \n을 포함하므로 split()을 쓰는 것이 좋다.
	EOF에서 빈 문자열을 반환한다.
	- input() 
	개행문자 \n을 제거해준다. 
	그러나 더 이상 입력을 하지 않을 때 (입력의 끝) EOF error가 발생한다. 
>## [4949]  균형잡힌 세상

> #### 입력
##### 하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 각 문자열은 영문 알파벳, 공백, 소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.
##### 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.

	So when I die (the [first] I will see in (heaven) is a score list).
	[ first in ] ( first out ).
	Half Moon tonight (At least it is better than no Moon at all].
	A rope may form )( a trail in a maze.
	Help( I[m being held prisoner in a fortune cookie factory)].
	([ (([( [ ] ) ( ) (( ))] )) ]).
	 .
	.
 >#### 출력
	yes
	yes
	no
	no
	no
	yes
	yes
> ### 스택을 이용한 알고리즘
1. "(", "[" 가 들어온 경우 push
2. ")", "]"가 들어온 경우
	* 스택이 비어있다 -> "no"
	* 짝이 아니다 -> "no"
	* 짝이 맞다 -> pass
3. 탐색이 완료된 경우(".")
	* 스택이 비어있다 -> "yes"
	* 스택이 비어있지않다 -> "no"
> ### code
	import sys; input=sys.stdin.readline
	left = ["(", "["]; right=[")", "]"]
	def f(line):
	    s = []  # stack
	  for w in line:
	        if w in left:
	            s.append(w)
	        elif w in right:
	            if not s: return "no"
	  idx = 0 if w==")" else 1
	  if s.pop()==left[idx]: continue
	 else: return "no"
	  elif w==".":
	            return "no" if s else "yes"

	while True:
	    line = input()
	    if line[0]==".":
	        break
	  print(f(line))
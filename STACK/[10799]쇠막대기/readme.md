> ## [10799] 쇠막대기
[enter link description here](https://www.acmicpc.net/problem/10799)
> #### 입력
	()(((()())(())()))(())
> #### 출력
	17
> ### 스택으로 푸는 알고리즘
> bar : 쇠막대기 개수, result : 총 쇠막대기 수
* "(" 다음에 바로 ")" ==> 레이저 :  result += bar
* "(" 다음에 "(" ==> 쇠막대기 시작 : bar +=1
* ")" 다음에 ")"가 나오는 경우 ==> 쇠막대기 끝(pop) : result += 1, bar-=1
* 1개의 쇠막대기에 존재하는 레이저 n개라고 할 때, 총 쇠막대기는 n+1개이다.

> #### ~~code ( 시간 초과~~)
	def bar(line):
	    s = []; l=0
	  pre =line[0]
	    res = 0
	  for w in line[1:]:
	        if pre=="(":
	            if w ==")":
	                for i in range(l):
	                    s[i] += 1
	  elif w=="(": s.append(1); l+=1
	  elif pre==")" and w==")":
	            res += s.pop(); l-=1
	  pre = w
	    return res
	print(bar(list(input())))
###### 스택에 쇠막대기의 각각 총 개수를 구해주었는데 for문이 두번 돌면서 O($n^{2}$)이 됨
> ### code
	def f(line):
	    bar = 0; res = 0
	  pre = line[0]
	    for w in line[1:]:
	        if pre=="(":
	            if w==")":
	                res += bar
	            elif w=="(":
	                bar +=1
	  elif pre==")" and w==")":
	            res +=1
	  bar -=1
	  pre = w
	    return res

	print(f(list(input())))
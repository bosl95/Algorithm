> ## [[2504] 괄호의 값](https://www.acmicpc.net/problem/2504)
1.  ‘()’ 인 괄호열의 값은 2이다.
2.  ‘[]’ 인 괄호열의 값은 3이다.
3.  ‘(X)’ 의 괄호값은 2×값(X) 으로 계산된다.
4.  ‘[X]’ 의 괄호값은 3×값(X) 으로 계산된다.
5.  올바른 괄호열 X와 Y가 결합된 XY의 괄호값은 값(XY)= 값(X)+값(Y) 로 계산된다.
6. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.
> #### 입력
	(()[[]])([])
> #### 출력
	28
> ### 스택을 이용한 알고리즘
* **search 함수**에서 스택을 먼저 탐색해준다 
	* ex) ( ( ) [ [ ] ] ) ( [ ] )
	* stack = ( 2 [ 3 ] ) ( 3 )
	* 이때, 잘못된 입력값이 들어오면 0을  return
* 제대로 입력된 값의 스택 결과를 계산해준다.
	* stack에서 ]가 발견되면 [가 나올때까지 더한 결과값에 3으로 곱해서 push
	* stack에서 )가 발견되면 (가 나올때까지 더한 결과값에 2를 곱해서 push
	* 마지막에 스택에 있는 모든 숫자를 더해서 출력한다. 
> ### code
	def search(line):  
	    s = []; left_stack = [] # 왼쪽과 오른쪽 쌍이 대칭인지 확인할 left stack  
	  pre=""  
	  
	  for w in line:  
	        if w in ["(", "["]:     # 왼쪽 괄호일 때  
	  s.append(w)  
	            left_stack.append(w)  
	        else:                      # 오른쪽 괄호일 때  
	  if left_stack:  
	                if s[-1]=="(" and w==")":  
	                    s.pop(); left_stack.pop()  
	                    s.append(2)  
	                elif s[-1]=="[" and w=="]":  
	                    s.pop(); left_stack.pop()  
	                    s.append(3)  
	                else:   # s[-1] = ], ), int  
	  if left_stack[-1]=="(" and w==")":  
	                        s.append(w)  
	                        left_stack.pop()  
	                    elif left_stack[-1]=="[" and w=="]":  
	                        s.append(w)  
	                        left_stack.pop()  
	                    else:  
	                        return [0]  
	            else:  
	                return [0]  
	    return [0] if left_stack else s  
	  
	ans = search(input())  
	if ans[0]==0:  
	    print(0)  
	else:  
	    left = []  
	    for a in ans:  
	        if a in [")", "]"]:  
	            x = "(" if a==")" else "["  
	  tmp = 0  
	  while left[-1]!=x:  
	                tmp += left.pop()  
	            left.pop()  
	            left.append(tmp*2 if x=="(" else tmp*3)  
	        else:  
	            left.append(a)  
	    print(sum(left))
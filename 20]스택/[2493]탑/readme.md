> ## [[2493]탑](https://www.acmicpc.net/problem/2493)
예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고, 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자. 그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.

탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.
> #### 입력
	5
	6 9 5 7 4
> #### 출력
	0 0 2 2 4
> #### ~~code~~ 
	import sys; input=sys.stdin.readline  
	n = int(input())  
	s = list(map(int, input().split()))  
	for i in range(n):  
	    flag = True  
	 for j in range(i-1, -1, -1):   
	        if s[j] > s[i]:  
	            flag = False  
	  print(j+1, end=" ")  
	            break  
	 if flag:  
	        print(0, end=" ")
#####  완전 탐색 : 시간 초과 O($n^2$)
> ### 스택을 이용한 알고리즘
* stack 
	* 현재 탑에서 신호를 줄 수 있는 탑이면 index를 출력
	* 가장 큰 값의 탑 순으로 push
	* stack의 top에 있는 값보다 큰 값이 들어오려면 top을 pop해주고 push ( stack의 top에 있는 값은 이제 필요없기 때문)
##### ex) arr = [ 5, 1, 4, 3, 9 ], s = [ 5 ]
1. [1]은 s의 top인 [5]보다 작으므로 push ⇒ s = [ 5, 1 ], 1 출력 (1번탑)
2. [4]는 s의 top인 [1]보다 크므로 [1]을 pop ⇒ 1은 더이상 뒤에 나올 탑들과도 비교 되지 않기때문 (4보다 큰 경우만 만나게 될거기 때문에)
	[4]는 s의 top인 [5]보다 작으므로 push ⇒ s = [ 5, 4 ], 1 출력
3. [3]은 s의 top인 [4]보다 작으르모 push ⇒ s = [5, 4, 3 ], 3 출력
##### 이런 방식을 반복
> #### code
    import sys; 
    input=sys.stdin.readline
    n = int(input())
    tower = list(map(int, input().split()))
    s = []
    for i in range(n):
        while s:
            if s[-1][1] < tower[i]:
                s.pop()
            else:
                print(s[-1][0], end=" ")
                s.append( (i+1, tower[i]))
                break
        if not s:
            print(0, end=" ")
            s.append( (i+1, tower[i]))
## [[14888]연산자 끼워넣기](https://www.acmicpc.net/problem/14888)

> 입력

	2
	5 6
	0 0 1 0

> 출력

	30
	30

> ### Backtracking 알고리즘을 이용한 풀이

Backtracking으로 분류되어있기는 하나 결국 다 방문하는 문제였다.
내가 짠 코드는 eval을 사용해서 연산을 계산해주었는데, eval을 사용한 경우가 메모리와 시간 모두 성능이 하락했다.

![image](https://user-images.githubusercontent.com/34594339/89272906-cb64f700-d679-11ea-9d37-14983f47c72f.png)

그리고 구해야할 최소값과 최대값을 처음에 -1로 지정해서, 
값이 -1인 경우 초기화 값이라고 생각하고 들어오는 결과값을 무조건 최소/최대값 변수에 삽입해 주었는데 최소/최대값이 -1일 수도 있는 것이기 때문에 이 초기화 설정은 완전한 오류였다.

몇개월전에 풀었을 당시에는 손도 못대서 구글링을 통해서 코드를 구현했는데,
그 코드는 메모리는 비슷하지만 시간을 **88ms** 로 나의 최종 코드보다 빠르다.

내 코드와 다른 점이 있다면,
내 코드에서는 연산자 배열 op에 재귀+DFS로 방문하면 증감하는 방식으로 탐색했지만
구글링한 코드는 현재 사용가능한 연산자 갯수와 현재까지 진행한 연산 결과값을 그대로 재귀를 돌려서 탐색을 하였다는 점이다.

> 구글링한 코드 

	import sys
	input = sys.stdin.readline

	def calc(num, idx, add, sub, multi, division):
	    global maxv, minv
	    if idx == n:
	        maxv = max(num, maxv)
	        minv = min(num, minv)
	    else:
	        if add:
	            calc(num + num_list[idx], idx+1, add-1, sub, multi, division)
	        if sub:
	            calc(num - num_list[idx], idx + 1, add, sub-1, multi, division)
	        if multi:
	            calc(num * num_list[idx], idx + 1, add, sub, multi-1, division)
	        if division:
	            calc(int(num/num_list[idx]), idx + 1, add, sub, multi, division-1)

	if __name__ == "__main__":
	    maxv = -sys.maxsize - 1
	    minv = sys.maxsize
	    n = int(input().strip())
	    num_list = list(map(int, input().strip().split()))
	    a, b, c, d = map(int, input().strip().split())
	    calc(num_list[0], 1, a, b, c, d)
	    print(maxv)
	    print(minv)
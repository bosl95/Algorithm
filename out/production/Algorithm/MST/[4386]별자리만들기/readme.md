# [[4386]별자리 만들기](https://www.acmicpc.net/problem/4386)

## MST를 이용한 알고리즘

<image src="https://lh5.googleusercontent.com/CQTGoqF4TwvGZqvs0la-Fyn_zJjo0nsTl94EPF8T2gK43sXlUR8f07C0uWM0DT_cc08dG_g1JgmCPWB3NDgUB1v1J5RXl03Hs43bpEoXiHQDj_GaYztPWUxLfoaGAZpvQwHzZkM0" width="
80%">
<br>

크루스칼 알고리즘이 감이 잘 오지 않아 다른 사람의 풀이를 살펴보았다.

- 다른 사람들의 풀이

		def find(x)
			if x==p[x]: return x
			p[x] = find(p[x])
			return p[x]
		
		def merge(x, y):
			x = find(x); y=find(y);
			p[y] = p[x]

		def Length(x1,y1,x2,y2):
			return ((x2-x1)**2+(y2-y1)**2)**0.5

		n = int(input())
		start = []
		p = [i for i in range(n)]
		for i in range(n):
			start.append([*map(float, input().split())])

		D = []
		for i in range(n):
			x, y = start[i]
			for j in range(i, n):
				nx, ny = start[j]
				if i!=j: D.append([Length(x, y, nx, ny), i, j])
		D = sorted(D)
		ans = 0
		for i in range(len(D)):
			if find(D[i][1])!=find(D[i][2]):
				ans += D[i][0]
				merge(D[i][1], D[i][2])
				
		print(ans)


#### 내 코드의 union 함수 / find 함수에 비해
#### 위 코드의 merge 함수 / find 함수가 좀 더 간략하게 구현되어져있다. (시간차이는 없는 것 같다.)
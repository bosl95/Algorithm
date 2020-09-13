 # [[11724]연결 요소의 개수](https://www.acmicpc.net/problem/11724)

## Graph를 이용한 풀이

<image src="https://lh4.googleusercontent.com/yszv2jcYzZCtwoKfR643JbMnNneBLMGDjBKQdLmxxlIPu3k5bIr9nOZ_jNjuLa8yvfGU7KJzll5vFAtMsfV1o6gjV-8uNvmx_DfvdQreDkjgY0I5q3RAIfzqcL_LW7wS_2MlfXa2" width="70%">
<br>

#### 새로운 시작점이 나올 때마다 카운트를 증가시키는 방식으로 푼다.
#### 주의할 점은 연결 그래프이므로 정점 u, v 각각의 인접 배열에 삽입을 해줘야한다는 것이다.

	for _ in range(M):  
	    a, b = map(int, input().split())  
	    edges[a].append(b)  
	    edges[b].append(a)
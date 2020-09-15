# [[11780]플로이드 2](https://www.acmicpc.net/problem/11780)

## Floyd를 이용한 풀이
### [[11404]플로이드](https://github.com/bosl95/Algorithm/tree/master/FLOYD-WARSHELL/%5B11404%5D%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C) 문제와 유사하지만 살짝 다른 문제 <br>
### 최단 경로를 구해주어야하는데, 이때 
	
	for k in range(N):  
    for i in range(N):  
        for j in range(N):  
            if i!=j and city[i][j] > city[i][k]+city[k][j]:  
                city[i][j] = city[i][k]+city[k][j]

### 이 부분에서 도시 k를 route[i][j]에 추가해주는 방법으로 풀었으나, 이렇게 되면 도시 k로 이동하였을 때 짧아질 이동 경로는 고려하지 않게 되기 때문에 최소 비용일지 언정 최단 이동 경로는 구할 수 없다.

	예를 들어,
	2 ⇒ 1 로 가는 경우
	1. 2 ⇒ 4 ⇒ 5 ⇒ 1 (정답)
	2. 2 ⇒ 4 ⇒ 1 ( 5가 생략되버리는 경우 발생 )

### 따라서 최단 이동 경로를 구해주기 위하여, <br>
### 다음 도시를 나타내도록 route[i][j] = k 로 설정하여 i ⇒ j 까지 도달할때까지 반복문을 돌며 경로를 구한다.

	path = []  
	st = i  
	while st!=j:  
	    path.append(str(st+1))  
	    st = route[st][j]  
	path.append(str(j+1))  
	print(len(path), ' '.join(path))
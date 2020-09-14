# Floyd-Warshell

## :pushpin: Concept  

### 거쳐가는 정점을 기준으로 최단 거리를 구하는 알고리즘<br>
### 플로이드 알고리즘은 기본적으로 다이나믹 프로그래밍에 의거<br>

<br>


<image src="https://user-images.githubusercontent.com/34594339/93100656-5fe45f80-f6e4-11ea-9a79-0e33c0262481.png" width="80%">

### 2 ⇒ 4로 가는 최단 거리를 구하는 경우
 - 바로 2에서 4로 갈 수 있는 경우는 없기 때문에 무한대
 - 1을 거쳐서 가면 2⇒1⇒ 4 로 이동하면서 4+1 = 5의 거리로 갈 수 있다.
 <br>
 
- ### ``D[s][t] = D[s][1] + D[1][t]``

<br>

[플로이드 예제](https://github.com/bosl95/Algorithm/tree/master/Floyd-Warshell/%5B11404%5D%ED%94%8C%EB%A1%9C%EC%9D%B4%EB%93%9C)

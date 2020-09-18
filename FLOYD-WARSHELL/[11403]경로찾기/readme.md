# [[11403]경로찾기](https://www.acmicpc.net/problem/11403)

## Floyd를 이용한 풀이

<image src="https://lh3.googleusercontent.com/fxXLTkNwnpXNENEnYR4RdxEU05W1GPzqhvNDXUoSVHkYv3bYUYGfuMaM6Zsco1GhW7BVd7mr_E10_-ywupD_TOTqUGATkxDFBObMcp1MeG-58m22wT2A5Y0zQrEeTpQytfKeAdS1" width="70%">

### 가중치가 없는 그래프 문제<br>
### 정점이 총 N개로 정점마다 방문 가능한 정점들을 확인하기 위하여 while문을 형성<br>
### stack과 visit 배열을 이용하여 각 정점에서 도달할 수 있는 다른 정점을 구해 reach[i][j] = 1 로 저장하였다.


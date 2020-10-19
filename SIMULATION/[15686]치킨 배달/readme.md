# [[15686]치킨 배달](https://www.acmicpc.net/problem/15686)

## Simulation을 이용한 풀이

<image src="https://lh6.googleusercontent.com/_qvsFX1nYMhh2dkg1Aa1KeTSzaXMTBJG-5Ibldyv2WBc2Qj_EHins1RMn5R52BWtGKhl_mdfmoIW-ry7SV2HErKq06HX3s3vdQy2KytybgrvNd5TSSbOiRzx9c51BQiPOZjgI-29" width="70%">

### 문제 해결 방식
1. 최대 M개의 치킨 집에 대한 조합을 구한다. (Combination)
2. 구한 조합 배열을 각 집들과의 치킨 거리를 구해 가장 작은 치킨거리 합을 가지는 값을 ans에 업데이트 해준다.

<br>

### 처음에 중복 조합을 활용하여 풀고자 했는데, 집마다의 치킨 거리를 구하는 과정에서 가장 중복 조합 배열이 갖는 치킨집 i 중 최소를 갖는 아무거나 선택하면 중복 조합이 되는 결과도 갖게 되기 때문에 굳이 중복조합을 사용할 필요가 없었다.
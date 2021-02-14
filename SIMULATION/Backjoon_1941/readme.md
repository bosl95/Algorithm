# [[1941]소문난 칠공주](https://www.acmicpc.net/problem/1941)

## Simulation을 이용한 풀이

<image src='https://lh3.googleusercontent.com/rcA_yXxhh0vSMnLJoeRbfytOlhbogJvBHxtdb80ZeyQbjl-v8b_6AnDGlFCPnYyPoUGW-ce-zGcRAKw7v2-fKmVrsu1UgJB6nmJC4UOrr5Yiui7cdpNIzUquY-Gg0yrr6Vv2c3CL' width='70%'>
<image src='https://lh4.googleusercontent.com/zqIrOEti3AzeiZa0pCxFN_hXzwkee6JrSBmCjKI3AaRX2FNHs3a3RtcFszAPXivpjHx3IAskJV6NswgLhoNkOPvjYglo7LVfJx7YEpKEVrqGtuA2jEaEe7uE_iIeXz4bPwxLUWN9' width='70%'>

### DFS를 사용할 때 주의해야한다. <br>
### 탐색 시 방문할 수 있는 방향이 현재 위치에서 4 방향 뿐만 아니라 이전에 탐색했었던 노드에서 가능하다. 따라서 새로 DFS를 들어갈 때마다 이전에 탐색했던 모든 노드들의 4방향을 다 체크해주어야한다.

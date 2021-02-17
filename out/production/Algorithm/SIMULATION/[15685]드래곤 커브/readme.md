# [[15685]드래곤 커브](https://www.acmicpc.net/problem/15685)

## Simulation을 이용한 풀이

문제를 이해할 수 없어 다른 사람의 풀이를 봤고, 다른 사람의 풀이를 보며 문제를 이해하였다. (..?)<br>

<br>

<image src='https://lh3.googleusercontent.com/KHz7N3jRL2lnCL8dF1i1mj7jiLzd2pae8AAPD9YmuNEsbXMCMqenrQUOMClTd2bnlXKDEAXA0ulOHrHQHkahES6GIroEUO1If_iW6AYAZWcHXpu-8jMuC3w6xqn9OeLOALRHS2DY' width='70%'>

### 문제 해결 방식 <br>
1. N-1 세대의 선분을 가지고 있는 배열 list1
2. list1의 마지막 부터 꺼내어 `방향+1` 하여 90도 회전 시킨 선분을 새로운 선분으로 추가해준다. (sub 배열에)
3. sub 배열 (새로운 선분을 담은 배열)을 다시 list1에 추가하고 다음 세대를 반복한다.

<br>

### 주의할 점  <br>
- 애시당초에 드래곤 커브가 무조건 0세대부터 시작해서 입력값이 g세대까지 도달하는 거라고 생각을 못 했다.
- 다시 꼼꼼히 읽어보고, 풀이도 다시 살펴보니 그런 맥락이라는 것을 이해할 수 있었다.
- 풀이 자체는 어렵지 않고, 범위도 작아서 문제만 잘 이해한다면 풀 수 있을 거 같다.
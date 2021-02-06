# [[13335]트럭](https://www.acmicpc.net/problem/13335)

## Simulation을 이용한 풀이

<image src="https://lh4.googleusercontent.com/4kktVxRi91yUDyflmcY0YrC9LwcxEuI9zsQ4ooUY6giuRxRqdoz_3cvF621d-AsDqVoAhGKVJur5NhbG8GPdTU9IZr31Kgjl8ICgrRK88SEDIDW1UGcq_xJcdQU_PGsyIc6Zf7xw" width="70%">

<br>

- 매 시간마다 다리에 있는 트럭을 찾아주어야한다.
- 매 시간에 다리의 하중을 기록한다.
- 현재 다리 위에 있는 트럭들을 1씩 이동시켜주고, 다리의 길이를 초과한(=다리를 건넌) 트럭은 더이상 체크하지 않는다.
- 만약 1씩 이동시켜줄 트럭이 없다면 모든 트럭이 이동했으므로 종료시킨다.
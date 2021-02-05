# [[14499]주사위 굴리기](https://www.acmicpc.net/problem/14499)

## Simulation을 이용한 풀이

<image src="https://lh5.googleusercontent.com/_fpE3-aOEJOAXOQhSs4LokoSQIy4FGaleAipmtIIjWavGZ7metZz2ZY7UHm9x3KN-OQX5QCFZEOZw3xjaH_ybZXw3WZx_nMDCLbC-PS6M-Df3y5Utqc-MnEWOkDJI5HnXZHSt-yN" width="70%">

### 주의사항
### 1. 주사위가 지도 밖으로 나가는 경우 이동 X, 출력 X
### 2. 이동한 지도 바닥의 값을 주사위의 바닥면에 복사 (만약, 지도 바닥면이 0이면 주사위 값을 지도 바닥면에 복사,  지도 바닥면이 0이 아니면 주사위 바닥에 지도 바닥면 값을 복사 후 지도 바닥면의 값을 0으로 만든다.)	⇒ 이부분을 제대로 읽지 않고 시간이 오래 걸렸다.

<br>

### 항상 문제의 조건에 주의하자.
# [[9251]LCS](https://www.acmicpc.net/problem/9251)

## Dynamic Programming을 이용한 풀이

참고 사이트 : [https://twinw.tistory.com/126](https://twinw.tistory.com/126) <br>

<image src="https://lh6.googleusercontent.com/iFk1Mlh9PVVp3TnET7vOqXDjoPK2hFi0tQAFSyOQjanqilblL_SmOsZ_1ROE5HzXEQ5N-qHAg-oZEP7h_OZNIujUXa4t--fU-E1ZXbqTSfqoggGFRbID32S4VrdeGeoAsNZcmklx" width="80%">

<br>
	
DP문제 중에서도 어려운 문제<br>
규칙을 찾기 위해서 직접 표를 그려봐야 했다.<br>
몇달 전 풀었던 코드를 보지 않고 직접 코드를 짰는데, 속도는 훨씬 빨라졌다.<br>

<br>

### 문제 해결 방식

1) 행의 값 = 열의 값인 경우 ⇒ 왼쪽 대각선 + 1
    - 왼쪽 대각선 : 현재 행과 열을 포함하지 않는 값 중 최대길이를 가지는 위치
2) 행의 값 != 열의 값인 경우 ⇒ 왼쪽 값과 위쪽 값 중 최대값을 선택.
    - 왼쪽값 : 현재 열의 값을 포함하지 않는 최대 길이
    - 위쪽값 : 현재 행의 값을 포함하지 않는 최대 길이
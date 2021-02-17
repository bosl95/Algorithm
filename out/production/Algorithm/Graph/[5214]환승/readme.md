# [[5214]환승](https://www.acmicpc.net/problem/5214)

## Graph 알고리즘을 이용한 풀이

<image src="https://lh5.googleusercontent.com/8X5EkulQxRKoV7QTWWPmCmK4D-6pwfNhKoMZ55IJe8oARVdNZ7NSKx8qLJeK3USfMl6V2zA6fwEh1JuJqNJgv_3FEXHispQm-Nj_By5vg9uaYsiXy2scah5qnqs65DifVlexTF6R" width="70%">
<image src="https://lh4.googleusercontent.com/CU0lKAtkmRLovbYa6G3lnsmj8gKvzvFBxZKAaqQmEG-vVSIcWev84Wo0eN078ezC_52qdQUDWTWejHM-8ygKaOu3l25nS1nPTpwFwHgE5tcLOzsRiMgizZcdC0uyra7-OPkf9k0k" width="70%">
<br>

#### 1<=N<=100,000, 1<=M<=1000 의 범위로 설정되어 하이퍼튜브마다의 정점들을 모두 확인하면서 경로 배열을 만들어 주면 메모리 초과가 발생한다.<br>
### ⇒ 경로 배열을 *N+M+1* 의 길이로 설정하여, 역의 경로를 넣어준 뒤에 하이퍼튜브 경로를 넣어준다. <br>
### BFS를 통해서 방문하며 경로 길이를 구하면 되는데, ``이때 하이퍼튜브에 들어가는 경우는 길이를 더하지 않는다.``<br>

<br>

### - 반례
	
	1 1 1
	1

#### 위의 그림에선 ``if j==n``을 for문 안에서 사용하였는데, 이럴 경우 반례가 성립하지 않는다.<br>
#### 따라서 저 if문을 for문 밖& while 문 안에서 체크해줘야한다.

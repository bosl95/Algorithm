> ## [[2583]영역 구하기](https://www.acmicpc.net/problem/2583)

<image src='https://lh6.googleusercontent.com/TAAu22wLlvfLMGqSWxsZqBnJ6uL55JHDp-4GjTQn12jvbA5zWq3flDkREvKzvXIjjNwXhOCd7CeXVzpl8YCUCGbrHtZhq4TPjRWz4pxz22eSci21gLbCD7B471nRN5I0LF4jFC8u' width='70%'>

>  #### 입력
	5 7 3
	0 2 4 4
	1 1 2 5
	4 0 6 2
>  #### 출력
	3
	1 7 13
> #### 알고리즘
* 입력 받은 좌표의 y : 행
* 입력 받은 좌표의 x : 열
* 오른쪽 위 꼭지점은 -1씩 해주어야 한다.
#### 먼저 직사각형들을 배열에서 1로 지정해주고,  DFS를 이용하여 0인 지점 (직사각형이 아닌 지점)들을 방문하며 넓이를 구해준다.
##### 이때 visit배열을 사용하여 방문여부를 확인해준다. (방문했으면 visit=1 아니면 0)
##### not in visit 보다 visit[i][j]를 통해 찾아주는 것이 훨씬 빠르게 탐색할 수 있으므로 스택 보단 배열로 사용한다.

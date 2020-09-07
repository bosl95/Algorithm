
## [[16236]아기상어](https://www.acmicpc.net/problem/16236)

<image src="https://lh3.googleusercontent.com/qwSi-3RWsI67oXetGKXrTm7flir5rwCARvGSfAn_up9c7zS-b1sZvAurqpXjVM6W0zpZQxXuLM8eic23xyX9o7BJnZ8DoH2mvV4Sx0_CCCwn-IoTpPjiwYS0cnOnhNow-wyFGCIj" width="70%">

---
- ### 알고리즘

	 1초당 BFS 탐색을 하여,
	 아기 상어보다 크기가 작은 물고기를 발견하면 그 위치를 반환하도록 설정
	
	
	오답이 발생한 요소들
	1. 현재 위치는 9로 나타내는 데 이것을 이동하기 이전에 0으로 바꿔주면 이동 경로를 탐색하는 과정에서 현 위치를 재방문하게 될 수 있다.
	2. 먹을 수 있는 물고기의 위치를 발견한 이후에,
		시간 += (물고기 위치 - 현위치) 로 해주었었는데 이렇게 되면
		중간에 큰 물고기가 있어 돌아서 물고기 위치로 가야하는 경우의 반례가 생긴다.
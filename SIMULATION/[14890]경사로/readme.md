# [[14890]경사길](https://www.acmicpc.net/problem/14890)


## Simulation을 이용한 풀이

### 문제 해결 방식

1. 행과 열을 나누어 각각의 길을 만든다.
2. 각각의 길을 검사한다. 
	1. 길을 0번째 칸부터 ~ n-2번째 칸까지 방문한다.
		1. 길[i] == 길[i+1]이면 다음 칸으로 넘어간다.
		2. 길[i]와 길[i+1]의 층이 2칸 이상이면 경사길을 둘 수 없으므로 return False
		3. 만약 길[i] > 길[i+1] 이면 내리막 경사길을 놓아야하는 경우이다.
			1. 만약 경사길을 놓아야하는 i ~ i+l 칸이 존재하지 않는다면 return False
			2. 경사길이 평평하지 않다면 return False
			3. 이미 경사길이 놓여진 곳을 탐색(chk)한다면 return False
			4. 두 경우가 해당되지 않으면 선택된 칸을 경사길에 놓는다. (chk[j] = True)
		4. 나머지는 오르막 경사길을 놓아야하는 경우이다.
			1. 경사길을 놓아야하는 i-l ~ i 칸이 존재하지 않는다면 return False
			2. 나머지는` 3-2` ~ `3-4`와 동일하다.
	2. 탐색이 정상적으로 끝난 경우 경사로를 놓아 지나갈 수있는 길이므로 return True

<br>

## 주의사항

- 처음에 내가 작성한 코드를 보면 고려하지않은 기본 사항들이 있다.

<image src='https://lh5.googleusercontent.com/07TqNF9hyKmUO4-AH-OX9zs4DdXfx_H1hkGXMOv3Z8ghBqe8yCnb40gCwd_iuNiRcKT17pcSPjoUXP8eMphmlwXoR1vbYKfDv2lUdAru2bsv7ts9MXw6Wts6qoP0Fnz2hPZb42dd' width='70%'>
	
	1. 경사로를 놓는 길을 평평해야한다.
	2. 이미 경사길이 놓여진 곳은 재탐색하면 안된다.

⇒ 내가 작성한  코드를 보면 경사로를 놓을 길을 합계로 확인하는데 이 작업에서 1번의 오류가 발생한다. <br>

### 항상 조건을 꼼꼼히 보고 순차적으로 문제 해결 방식을 작성할 수 있도록 주의해야겠다.
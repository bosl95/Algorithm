# [[1541]잃어버린 괄호](https://www.acmicpc.net/problem/1541)


## Greedy Algorithm을 이용한 풀이
- 최소값을 만들기 위해서는 음수값이 커져야한다. 
	- input값을 '-'를 기준으로 1차 split
- '-'를 기준으로 split된 배열 tmp안의 값들을 '+'으로 2차 split하여 각 인덱스별 합계를 구한다.
	- 이때, tmp[0]는 합을 양수값으로, tmp[1]~tmp[n-1]까지의 합은 음수값으로 저장해준다.  ~~(여기서 int(tmp[0])로 바로 설정해줘서 런타임 오류가 발생했었다.)~~
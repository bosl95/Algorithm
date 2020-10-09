# [[14921]용액합성하기](https://www.acmicpc.net/problem/14921)

## Two Pointer를 이용한 풀이
### 이 문제는 앞서 풀었던  [[2467]용액](https://github.com/bosl95/Algorithm/tree/master/BINARY%20SEARCH/%5B2467%5D%EC%9A%A9%EC%95%A1) 문제와 거의 동일하다!<br>
### 다른 점은 전 문제와 달리 두 용액의 합쳐진 값을 물어보기 때문에 별도의 배열의 인덱스 값 저장은 할 필요가 없는 더 간단한 문제이다.<br>

<br>

## :pushpin: 내가 찾은 반례

	3
	-3 -2 -1

처음 코드를 작성하였을 때, 
	
	if abs(approx) > abs(x):  
	    approx = x

이 부분과,

	if low>=high: return approx

이 부분의 코드를 순서대로 작성하였는데, 이렇게 되면 approx 값을 업데이트 하기 전에 return 되므로 오류가 발생한다. <br>
그렇기 때문에 두 문장의 순서를 바꾸어 주어야한다.


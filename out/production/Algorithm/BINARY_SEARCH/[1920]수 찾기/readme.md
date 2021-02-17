# [[1920]수 찾기](https://www.acmicpc.net/problem/1920)

## Binary Search를 이용한 풀이
### 이진 탐색 알고리즘을 사용해서 풀긴 했으나, 그냥 *For x in Arr* 로 해서 푸는 것이 훨씬 빠르게 나온다.<br>

<br>

## 다른 사람의 풀이
	import sys
	input = sys.stdin.readline

	def BOJ_1920():
	    n,A,m = input(),set(input().split()),input()
	    res=""
	    for i in input().split():
	        res += "1\n" if i in A else "0\n"
	    print(res)
# :tada: Algorithm:tada:  
 
 ### Todo
 - [ ] [15683]감시 풀기
 - [ ] [1786] 찾기 다시 풀기  
 
 <br> 
  
## :heavy_check_mark: Contents  
### :dart: Algorithm  
- [*Back Tracking*](https://github.com/bosl95/Algorithm/tree/master/BACK%20TRACKING)  
- [*Brute Force*](https://github.com/bosl95/Algorithm/tree/master/BRUTE%20FORCE)  
- [*BINARY SEARCH*](https://github.com/bosl95/Algorithm/tree/master/BINARY%20SEARCH)
- [*DFS/BFS*](https://github.com/bosl95/Algorithm/tree/master/DFS_BFS)  
- [*Divide and Conquer*](https://github.com/bosl95/Algorithm/tree/master/DIVIDE%20AND%20CONQUER)  
- [*Dynamic Programming*](https://github.com/bosl95/Algorithm/tree/master/DYNAMIC%20PROGRAMMING)  
- [*Function*](https://github.com/bosl95/Algorithm/tree/master/FUNCTION)  
- [*Floyd-Warshell*](https://github.com/bosl95/Algorithm/tree/master/Floyd-Warshell)   
- [*Greedy*](https://github.com/bosl95/Algorithm/tree/master/GREEDY)  
- [*Graph*](https://github.com/bosl95/Algorithm/tree/master/Graph)  
- [*Mathematics 1*](https://github.com/bosl95/Algorithm/tree/master/MATHEMATICS%201)
- [*Hash&Binary Search&Heap*](https://github.com/bosl95/Algorithm/tree/master/HASH_BINARY%20SEARCH_HEAP)  
- [*MST*](https://github.com/bosl95/Algorithm/tree/master/MST)  
- [*Recursion*](https://github.com/bosl95/Algorithm/tree/master/RECURSION)
- [*Simulation*](https://github.com/bosl95/Algorithm/tree/master/SIMULATION)
- [*Sort*](https://github.com/bosl95/Algorithm/tree/master/SORT)  
- *[IF](https://github.com/bosl95/Algorithm/tree/master/IF)/[For](https://github.com/bosl95/Algorithm/tree/master/FOR)/[While](https://github.com/bosl95/Algorithm/tree/master/WHILE)*  
- [*String*](https://github.com/bosl95/Algorithm/tree/master/STRING)  
- [*Tree*](https://github.com/bosl95/Algorithm/tree/master/TREE)
  
 ### :dart: Data Structure  
- [*Array*](https://github.com/bosl95/Algorithm/tree/master/ARRAY)  
- [*Stack*](https://github.com/bosl95/Algorithm/tree/master/STACK)  
- [*Queue/Deque*](https://github.com/bosl95/Algorithm/tree/master/QUEUE_DEQUE)  
  
  
### :dart: Etc.  
- [*Samsung Software Expert Academy*](https://github.com/bosl95/Algorithm/tree/master/SW%20Expert%20Academy)

<br>
  
---

## :pushpin: Time Complexity

|*Size of N*| *Maximum Time Complexity* |
|:--:|:--:|
| *N ≤ 11* |*O(N!)*|
|*N ≤ 25*|*O(2<sup>N</sup>)*|
|*N ≤ 100*|*O(N<sup>4</sup>)*|
|*N ≤ 500*|*O(N<sup>3</sup>)*|
|*N ≤ 3,000*|*O(N<sup>2</sup>logN)*|
|*N ≤ 5,000*|*O(N<sup>2</sup>)*|
|*N ≤ 1,000,000*|*O(NlogN)*|
|*N ≤ 10,000,000*|*O(N)*|
|*10,000,000~*|*O(logN)*, *O(1)*|

<br>

### 컴퓨터는 1초에 대략 3-5억 개정도의 연산을 처리한다. <br>
### 단, 연산이 AND, OR, 비교, 덧셈 등과 같은 단순 연산인지 아니면 나눗셈, 곱셈, 대입, 함수  호출과 같은 복잡한 연산인지에 따라 차이가 날 수있다.<br>

<br>

## :pushpin: Space Complexity

### int는 4byte의 메모리를 가진다. <br>
### 512MB는 1.2 억개의 int를 가진다.<br>
### 만약,  풀이가 5억인 배열이 필요하다면 주어진 메모리 제한을 만족하지 못하므로 다른 풀이를 찾아야한다.

<br>

## :pushpin: Python EOF

### #1

	while True:
		try:
			a, b = map(int, input().split())
			print(a+b)
		except:
			break
			
### #2
	
	import sys
	for line in sys.stdin:
		a, b = map(int, line.split())
		print(a + b)
		
### cf
#### sys.stdin.readline은 \n을 포함하는 것에 주의 ==> strip()을 통해 공백을 제거 
		
<br>

## :pushpin: Python KeyError
	
	X = dict()
	if not X[i]:	# KeyError
	
	if X.get(i):	# OK
	
<br>
	
## :pushpin: 완전 탐색 시 시간 초과가 나는 경우

1. 투 포인터 알고리즘 시도해보기
2. 이분 탐색 시도해보기(binary search)
3. dp(Dynamic programming) 시도해보기
4. 그리디(Greedy) 시도해보기
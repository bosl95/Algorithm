# Hash

## :pushpin: Concept

### 해쉬 함수란? 

> 임의의 길이의 데이터를 고정된 길이의 데이터로 대응시키는 함수
> 해쉬 함수를 이용해 만든 테이블을 **해쉬 테이블**이라고 한다.

<br>

<image src="https://user-images.githubusercontent.com/34594339/95672409-75fa1880-0bdb-11eb-9571-9f27ff4abc3a.png" width="70%">

<br>

### 해쉬 함수의 문제점 

<image src="https://user-images.githubusercontent.com/34594339/95672422-94601400-0bdb-11eb-872f-6da49703ed15.png" width="70%">

#### ⇒ 이와 같이 해쉬 함수의 특성상 충돌은 발생할 수 밖에 없다.<br>

- 해결 방법
	1. Open Addressing : 충돌이 발생했을 때 원소를 저장하는 인덱스를 바꾸는 충돌 회피 방법.
		
		<image src="https://user-images.githubusercontent.com/34594339/95672465-f3be2400-0bdb-11eb-9937-9421fd8f6489.png" width="70%">
	
		⇒ **카드번호가 "1237 9672 3313 4752"인 사람이 누구냐는 질문에는 Kim을 답하고, "1237 0000 0000 0000"이 누구냐는 질문에는 그런 사람이 없다고 답을 해야하는데 카드 번호를 같이 적어두지 않는다면 둘을 구분할 수 없기 때문**
		
		- Linear probing : 중복되는 인덱스가 있으면 한칸 옆으로 이동하는 방식
		- Quadratic probing : 처음 칸에서 1의 제곱, 2의 제곱, 3의 제곱 떨어진 칸으로 이동하는 방식.
		- Double hashing 등..

	2. Chaining : Linked List 구조로 여러 원소를 담고 있는 방식. (꼭 연결리스트일 필요는 없고, 동적 배열이어도 상관없다.)
	
	<image src="https://user-images.githubusercontent.com/34594339/95672844-e22a4b80-0bde-11eb-8054-d1ecf8a0075c.png" width="70%">

	- 이때, 주의할 점은 맨 뒤에 붙이면 노드 개수만큼 이동해야하므로 맨앞에 삽입하면 O(1)에 삽입이 가능하다.

- 해쉬에서 삽입, 삭제, 검색은 모두  O(1)이지만 충돌이 빈번히 발생할 수록 실제 시간 복잡도는 나빠진다.
- 코딩테스트에서 해쉬 테이블을 구현해야 할 일은 거의 없다.

<br>

# Binary Search Tree

## :pushpin: Concept
<image src="https://user-images.githubusercontent.com/34594339/95673051-51546f80-0be0-11eb-8e2e-6562c849f5be.png" width="70%">
<image src="https://user-images.githubusercontent.com/34594339/95673071-7e088700-0be0-11eb-96c8-59612b868c2b.png" width="70%">

#### <좌> Balanced Tree(균형 트리)		<우> Degenerated Tree(편향된 트리)<br>
### ⇒ 시간 복잡도는 *O(logN)* 에서 *O(N)* 도 될 수 있다.<br>
### 그러나 연산을 O(logN)을 수행하기 위해 트리를 사용하므로 트리가 편향되어 있으면 트리를 쓰는 이유가 없다. <br>

<br>

### 이진 트리에서 삭제 할 때는, <br>
1. 자식이 없는 노드 : 그냥 삭제 가능
2. 자식이 1개인 노드 : 자식을 지워진 노드 자리에 올린다.
3. 자식이 2개인 노드 : 적절한 노드를 이동시킬 수 있도록 한다.

	<image src="https://user-images.githubusercontent.com/34594339/95673109-dc356a00-0be0-11eb-802c-626caf59815c.png" width="70%">

<br>

### 이진 탐색 트리를 직접 구현해야하는 상황은 거의 없다. 라이브러리를 이용하면 된다.<br>

<br>

# Heap
## :pushpin: Concept
### 최소힙<br>

<image src="https://user-images.githubusercontent.com/34594339/95673233-e146e900-0be1-11eb-8a7f-b42ccf831fcd.png" width="70%">

### ⇒ 최소 힙의 경우 부모는 자식 보다 작아야 하고, 최대 힙의 경우 부모는 자식보다 커야한다. 이때 루트가 최솟값 혹은 최대값이 된다.

- ### 최솟값 삭제 

	1. 8을 삭제

		<image src="https://user-images.githubusercontent.com/34594339/95673332-70540100-0be2-11eb-8e1e-779e6fe6edb3.png" width="70%">

	2. 8과 52를 바꾸고 8을 제거

		<image src="https://user-images.githubusercontent.com/34594339/95673352-a0030900-0be2-11eb-8720-0db022a56396.png" width="70%">

	3. 가장 작은 12를 52와 위치를 바꾼다.

		<image src="https://user-images.githubusercontent.com/34594339/95673366-b6a96000-0be2-11eb-8b9d-11a0edd204e9.png" width="70%">

	4. 가장 작은 16을 부모로 올린다. (이때 둘다 같으면 오른쪽 노드를 올림)

		<image src="https://user-images.githubusercontent.com/34594339/95673381-e0628700-0be2-11eb-9fdd-504f2b132238.png" width="70%">

	5. 가장 작은 22를 부모로 올린다.
	
		<image src="https://user-images.githubusercontent.com/34594339/95673394-fd975580-0be2-11eb-936b-5c425edc2c55.png" width="70%">
		
<br>

# :pushpin: 총정리
1. ###  Hash : 삽입, 삭제, 검색 모두 이론적으론 *O(1)*, 그러나 충돌이 많이 발생함에 따라 실제 시간 복잡도는 더 나쁠 수 있다.
2. ### Binary Search Tree : 삽입, 삭제, 검색 모두 *O(logN)*, 그러나 트리가 편향됨에 따라 최악의 시간 복잡도는 *O(N)* 이 될 수도 있고, 이를 위해 자가 균현 트리가 존재한다.
3. ### Heap : 삽입, 최소(최대)값 삭제는 *O(logN)*, 최소(최대)값 확인은 *O(1)* 이고 Hash나 Binary Search Tree와 달리 구조적으로 시간 복잡도가 보장된다.





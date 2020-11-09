# :tada: Algorithm:tada:  
 
 ### Todo
 - Simulation
     - [x] [15683]감시 풀기 두번째
        - [ ] [15683]감시 풀기 세번째
     - [ ] [1786] 찾기 다시 풀기  
     - [ ] [15989]피아의 아틀리에 java로 풀어보기
     - [ ] [13460]구슬 탈출2
     - [ ] [15684]사다리조작 내 로직 구현해보기
 
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
- [*Programmers*](https://github.com/bosl95/Algorithm/tree/master/Programmers)

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

- #### 컴퓨터는 1초에 대략 3-5억 개정도의 연산을 처리한다. <br>
- #### 단, 연산이 AND, OR, 비교, 덧셈 등과 같은 단순 연산인지 아니면 나눗셈, 곱셈, 대입, 함수  호출과 같은 복잡한 연산인지에 따라 차이가 날 수있다.<br>

<br>

## :pushpin: Space Complexity

- #### int는 4byte의 메모리를 가진다. <br>
- #### 512MB는 1.2 억개의 int를 가진다.<br>
- #### 만약, 풀이가 5억인 배열이 필요하다면 주어진 메모리 제한을 만족하지 못하므로 다른 풀이를 찾아야한다.

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

<br>

## :pushpin: Python에서 많이 쓰이지만 헷갈리는 Lambda 함수에 대해 알아보기

      # 일반 함수
      def ten(x):
        return x+10
       
      ten(1)       # 11
      
      # lambda 함수
      ten = lambda x: x+10
      ten(1)        # 11

- 일반 함수를 한 줄로 짧게 쓸 수 있다.

<br>

- result라는 dictionary가 있다고 가정해보자.

      sorted(result, key=lambda x:result[x], reverse=True)
      
   1. result는 [result의 키]로 이루어진 리스트 형태이다.
   2. 키값을 하나씩 꺼낸 것이 x이다.
   3. result[x]는 결국 키가 x인 딕셔너리의 값이다. 즉, '값'을 기준으로 거꾸로 정렬한다는 의미이다
   4. 대신 결과값으로는 키 값만 다시 되돌아온다. 1번에서 키로 주어졌기 때문이다.
  
- 같은 결과를 가지는 코드는 아래와 같다.

      sorted(result.items(), key=lambda x:result[x[0]], reverse=True)

<br>

<details>
<summary> 자바 알아보기 </summary>

## Array 배열 정렬


```JAVA
int[] arr = {2,3,1,378,19,25};
Arrays.sort(arr);

System.out.println(Arrays.toString(arr));
```

<br>

## Swap 함수

``` JAVA
public static void swap(final int[] arr, final int pos1, final int pos2){
    final int temp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = temp;
}
```
<br>

## 문자열 비교

```JAVA
String s1 = "Joos";
String s2 = "Joos";
String s3 = new String ("Joos");
String s4 = "Juilet"

System.out.println(s1.equals(s2)); //true
System.out.println(s1.equals(s3)); //true
System.out.println(s1.equals(s4)); //false
```

<br>

## 가장 빠른 입력 받기 & 문자열 자르기

``` JAVA
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	// 사용자로부터 한 줄 입력을 받는다.
		
		// 어떤 기준으로 문자열을 자르고 싶은 경우 String Tokenizer를 사용한다. 생성자로 자르고 싶은 string을 넣는다. 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");	// 기본 생성자는 공백을 기준으로 자른다. <"안녕 하세요" 입력>
//		System.out.println(st.nextToken());		// 안녕
//		System.out.println(st.nextToken());		// 하세요	
//		System.out.println(st.nextToken());		// error
		
		
		// 반복문으로 출력하기 
		int n = st.countTokens();		// 처음에 st의 개수를 입력 받음.
		for (int i=0;i<n;i++) {
//		while(st.countTokens()!=0) {	// counttokens을 여러번 하는거보단 st의 개수를 처음부터 입력받는 것이 나을 것 같다.
			System.out.println(st.nextToken());
		}
	}
}

```

<br>

## ArrayList

```JAVA
import java.util.ArrayList;
import java.util.List;

public class pr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List idolList = new ArrayList();


		idolList.add("첫번째 요소");
		idolList.add("두번째 요소");
		idolList.add(new String("세번째 요소"));
		idolList.add(1, "인덱스 1에 삽입 요소");


		System.out.println(idolList.get(0).toString());	// 첫번째 요소
		System.out.println(idolList.get(1).toString());	// 인덱스 1에 삽입 요소
		System.out.println(idolList.get(2).toString());	// 두번째 요소
		
		
	}

}
```
<br>

- ### ArrayList 정렬

	```JAVA
	List idolList = new ArrayList();


	idolList.add("1");
	idolList.add("2");
	idolList.add(new String("3"));
	idolList.add(1, "1.5");

	Collections.sort(idolList);

	for (Object obj : idolList) {
		System.out.println(obj.toString());		// 1 - 1.5 - 2 - 3
	}
	```

<br>

- ### ArrayList의 Iterator를 통한 전체 조회

	``` JAVA
	Iterator iterator = list.iterator();
	while (iterator.hasNext()) {
		System.out.println((String)iterator.next());
	}
	/* 
	- 출력 결과 -
	첫번째 요소
	인덱스 1에 삽입 요소
	두번째 요소
	세번째 요소
	*/
	```

<br>

- ### ArrayList의 for-loop를 통한 전체 조회

	``` JAVA
	for(Object obj : list) {
		System.out.println((String)obj);
	}
	```

<br>

- ### 인덱스 찾기

	```JAVA
	int idx = list.indexOf("두번째 요소");
	System.out.println(list.get(idx).toString());
	```

<br>

- ### 요소가 존재 하는 지 확인

	``` JAVA
	System.out.println(list.contains("두번째 요소"));	// true
	System.out.println(list.contains("네번째 요소"));	// false
	```

<br>

## Hashmap (파이썬의 dict)

```JAVA

HashMap<String, Integer> map = new HashMap();

map.put("아이유", 25);
map.put("아이린", 27);
map.put("설현", 40);

System.out.println(map.get("아이유"));	// 35
System.out.println(map.values()); 		// [40, 25, 27]
```

<br>

- ### Hashmap 하나씩 출력하기

	``` JAVA
	Set<Entry<String, Integer>> set = map.entrySet();
	Iterator<Entry<String, Integer>> itr = set.iterator();

	while (itr.hasNext()) {
		Entry<String, Integer> e = (Entry<String, Integer>)itr.next();
		System.out.println("이름 : "+e.getKey()+", 나이 : "+e.getValue());
	}
	```

<br>

## Array

- ### Array 초기화

	``` JAVA
	boolean [] bitlist;
	bitlist = new boolean[10];

	Arrays.fill(bitlist, false);

	for (boolean obj : bitlist) {
		System.out.println(obj);	// false
	}
	System.out.println(bitlist.length);
	```

<br>

- ### 2차원 배열 
	``` JAVA
	int[][] intArray = new int[5][3];

	System.out.println(intArray.length);	// 행의 개수
	System.out.println(intArray[0].length); // 열의 개수

	//다차원 배열의 할당 선언
	boolean [] [] booleanArrays = { {true, true}, {false, false, false}, ... };
	```

<br>

## Stack
``` JAVA
Stack<String> s = new  Stack<String>();

s.push("A");
s.push("B");
s.push("C");
s.push("D");

System.out.println(s.peek());		// D

while(!s.empty()) {
	System.out.println(s.pop());	// D - C - B - A
}
```

<br>

## Queue

``` JAVA
Queue<String> q = new LinkedList<String>();

q.offer("A");
q.offer("B");
q.offer("c");
q.offer("D");

System.out.println(q.peek());	// A 
System.out.println(q.remove());	// A (queue에서 사라짐)


while (!q.isEmpty()) {
	System.out.println(q.poll());	// B - C - D
}
```
<br>

## Stack과 Queue

<image src='https://user-images.githubusercontent.com/34594339/97065460-6a99ea80-15e8-11eb-86a5-bbeb9fb6f2a9.png' width='70%'>

<br>

## 문자열 정수로 바꾸기

``` JAVA
Integer.parseInt("23")	// Valueof 보다 빠르다.
```

<br>

### 문자열 요소 접근하기

```JAVA
String str = "일이삼사오";

System.out.println(str.charAt(3));
```

</details>

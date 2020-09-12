

# MST(Minimum Spanning Tree)  
  
## :pushpin: Concept  
  
- ### Spanning Tree란  
  
   > 그래프 내의 모든 정점을 포함하는 트리  
  
    <br>  
   <image src="https://gmlwjd9405.github.io/images/algorithm-mst/spanning-tree.png" width="70%">  
  
   :point_right:  spanning tree는 모든 정점들이 연결되어 있어야하고 Cycle을 포함해서는 안된다.  
   :point_right: 그래프에 n개의 정점을 (n-1)개의 간선으로 연결한다.  
<br>  
  
- ### MST = 최소 신장 트리  
  
   **Greedy Algorithm**을 기초로 당장 눈앞의 최소 비용을 선택해, 결과적으로 최적의 솔루션을 찾는 알고리즘  
   <br>  
  
   > 네트워크에 있는 모든 정점들을 가장 적은 수의 간선과 비용으로 연결하는 트리  
  
   :point_right: 간선 가중치의 합이 최소여야함 <br>  
   :point_right: n개의 정점에서 반드시 (n-1)개의 간선만을 사용<br>  
   :point_right: Cycle이 포함되서는 안된다.<br>  
  
---  
  
## :pushpin: Kruskal MST Algorithm  
  
#### 가장 가중치가 작은 간선부터 선택하면서 MST를 구하는 방식  
  
<br>  
<br>  
  
<image src="https://programmingpraxis.files.wordpress.com/2010/04/kruskal.png?w=460" width="50%" height="40%">  
<br>  
  
### :pencil2: *Union-Find Algorithm*  
  
- 노드들 중에 연결된 노드를 찾거나 노드들을 서로 연결할 때 사용<br>  
  
#### :gem: **Distjoint Set이란**  
- 서로 중복되지 않는 부분 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조  
- 서로소 집합 자료구조  
  
  
#### :mag: Process  
1. **초기화** : n 개의 원소가 개별 집합으로 이뤄지도록 초기화  
  
   <image src="https://www.fun-coding.org/00_Images/initial_findunion.png" width="60%">  
  
2. **Union** : 두 개별 집합을 하나의 집합으로 합친다. 두 트리를 하나의 트리로 만듬  
  
   <image src="https://www.fun-coding.org/00_Images/union_findunion.png" width="60%">  
  
3. **Find** : 여러 노드가 존재할 때, 두 개의 노드를 선택해 두 노드가 서로 같은 그래프에 속하는 지 판별하기 위해 각 그룹의 루트 노드를 확인.  
  
   <image src="https://www.fun-coding.org/00_Images/find_findunion.png" width="60%">  
<br>  
  
#### :fire: 주의할 점 :fire:  
- Union 순서에 따라 최악의 경우 ``Linked List`` 와 같은 형태가 될 수 있음  ⇒ **O(N)의 최악의 시간 복잡도**  
  
  
### :bulb:  Resolution  
- #### union-by-rank  
  각 트리에 대한 높이(rank)를 기억<br>  
   Union 시 두 트리의 높이가 다르다면 높이가 작은 트리를 높이가 큰 트리에 붙인다.<br>  
   (즉, **높이가 큰 트리의 루트 노드가 합친 트리의 루트노드가 됨**)  
  
   <image src="https://www.fun-coding.org/00_Images/unionbyrank_findunion.png" width="70%">  
  
<br>  
  
- 높이가 h인 트리가 만들어지려면 높이 h-1인 두개의 트리가 합쳐져야 한다.  
- 높이가 h-1인 트리를 만들기 위해 최소 n개의 원소가 필요하다면, 높이가 h인 트리가 만들어지기 위해서는 최소 2n개의 원소가 필요하다.  
- 따라서 ``union-by-rank``를 사용하면<br>  
   :point_right: **O(N) ⇒ O(*logN*)로 낮출 수 있다.**  
  
  
- #### path compression  
  
   - Find를 실행한 노드에서 거쳐간 노드를 루트에 다이렉트로 연결하는 기법.  
   - Find를 실행한 노드 이후부터는 루트 노드를 한번에 알 수 있다.  
  
#### :point_right: **Union-by-rank**+ **Path Compression** 시간 복잡도 : O(M*logN*)  
<br>  
 
 <details>
<summary>  :point_right: 예제 </summary>
<br> 
  
<image src="https://lh5.googleusercontent.com/27mvNFS1SLjQMzYuGBxkyCjOeTwe3-hWxOSevks7Mt-9z42vcRNEyFZ690oF9EJWAWEP9NlxSQcwlQ_xA2NlyW2ltQPCFckiFjj0JqLBXNuzIBdumshK55tQUeFvFRybFA0VrGso" width="70%">  
  
<image src="https://lh4.googleusercontent.com/Hq_nqK7mcTA2OXJxoOK4rk7BCVhesothi8tekVPc5SF0nWgJSFccnX9vUBiN4wUm8KTHVsBw_SLc7DUGls5tLKuYVz9F3U05mFVZeb2tYNoEdB-R88ssHMsmtUJFyVPHjAkWeD2g" width="70%">  
  
</div>
</details>
<br>  
  
## :pushpin: Prim Mst Algorithm  
  
#### 특정 정점에서 시작, 해당 정점에 연결된 가장 가중치가 작은 간선을 선택, 간선으로 연결된 간선 중에 가장 가중치가 작은 간선을 택하는 방식  
<br>  
  
<image src="https://www.fun-coding.org/00_Images/prim1.png"  width="70%">  
<image src="https://www.fun-coding.org/00_Images/prim2.png" width="70%">  
<image src="https://www.fun-coding.org/00_Images/prim3.png" width="70%">  
<br>  
  
#### :mag: Process  
1. 임의의 정점 선택, '연결된 노드 집합'에 삽입
2. 선택된 정점에 연결된 간선들을 간선 리스트에 삽입
3. 간선 리스트에 최소 가중치를 가지는 간선부터 추출해서,
	- if 해당 간선에 연결된 인접 정점 in  '연결된 노드 집합' ⇒ SKIP (cycle을 막기위함)
	- if 해당 간선에 연결된 인접 정점 not in '연결된 노드 집합' <br>
		⇒ 해당 간선을 선택, 해당 간선 정보를 'MST' 배열에 저장
4. 추출한 간선은 간선 리스트에서 제거
5. 간선 리스트에 더 이상 간선이 없을 때까지 반복

<br>  
 
 <details>
<summary>  :point_right: 우선 순위 큐 사용하기 </summary>
<br> 

	import heapq

	h = []
	heapq.heappush(h, (3, "a"))
	heapq.heappush(h, (5, "b"))
	heapq.heappush(h, (1, "d"))
	heapq.heappush(h, (4, "e"))

	print(heapq.heappop(h)) # (1, "d")
	print(heapq.heappop(h)) # (3, "a")
	print(heapq.heappop(h)) # (4, "e")
	print(heapq.heappop(h)) # (5, "b")

</div>
</details>
<br>  

<br>

### :pencil2: 우선 순위 큐 활용하기

- ``heapq``를 이용하여 우선 순위 큐 만들기

		myedges = [  
		    (7, 'A', 'B'), (5, 'A', 'D'),  
		  (8, 'B', 'C'), (9, 'B', 'D'), (7, 'B', 'E'),  
		  (5, 'C', 'E'),  
		  (7, 'D', 'E'), (6, 'D', 'F'),  
		  (8, 'E', 'F'), (9, 'E', 'G'),  
		  (11, 'F', 'G')  
		]  
		  
		import heapq  
		  
		graph = [[7, 'A'], [5, 'B'], [3, 'C']]  
		  
		heapq.heapify(graph)  
		  
		for index in range(len(graph)):  
		    print(heapq.heappop(graph))  
		  
		print(graph)
		'''  
		[3, 'C']
		[5, 'B']
		[7, 'A']
		[]
		'''



# TREE

## :pushpin: Concept
### 트리란? <br>
### ⇒ 무방향이면서 사이클이 없는 연결 그래프 (Undirected Acyclic Connected Graph) <br>

<br>

### :pushpin: Tree의 특징
1. 무방향이면서 사이클이 없는 연결 그래프
2. 연결 그래프이면서 임의의 간선을 제거하면 연결 그래프가 아니게 되는 그래프
3. 임의의 두 점을 연결하는 simple path(정점이 중복해서 나오지 않는 경로)가 유일한 그래프
4. V개의 정점을 가지고 V-1개의 간선을 가지는 연결 그래프
5. 사이클이 없는 연결 그래프이면서 임의의 간선을 추가하면 연결 그래프가 되는 그래프
6. V개의 정점을 가지고 V-1개의 간선을 가지는 Acyclic(=사이클이 없는) 그래프

<br>

- ### 트리에서는 임의의 노드를 루트로 만들 수 있다!

	<image src="https://user-images.githubusercontent.com/34594339/95649651-8c3fa000-0b19-11eb-80ae-8cf4b7471c79.png" width="80%">

- ### 트리는 BFS와 DFS를 적용 시킬 수 있다.
	- ``BFS의 경우`` 시작점을 잡고 BFS를 시행하면 트리를 재배치했을 때 **높이순**으로 방문하게 된다.
	- 한 임의의 노드에서 BFS를 시행할 때, 이미 부모노드는 방문했음을 알 수 있기 때문에 자식 노드만 모두 큐에 넣으면 된다. (즉, vis 배열이 필요 없다. 부모가 누구인지만 알면 된다.)
		
		  p = [0] * n
		  
          def  bfs(root):
	          q = [root]
			  while q:
				  cur = a.pop(0)
				  for nxt in adj[cur]:
					  if p[cur] == nxt: continue
					  q.append(nxt)
					  p[nxt] = cur

		###	⇒  If문을 통해 cur의 부모인지 확인해 부모일 경우 건너뛴다. 부모가 아니면 큐에 넣고, 맨 마지막 문장을 통해 부모노드로 설정해준다. <br>
		### 시간 복잡도 : *O(V+E)* ( *E=V-1* 이므로 *O(V)* 가 된다.)
	
	<br>

	- ``DFS의 경우`` 부모 배열과  depth 배열을 채우며 처리가 가능하다.
	
		  def dfs(root):
			  stack = [root]
			  while stack:
				  cur = stack.pop()
				  for nxt in adj[cur]:
				    if p[cur] == nxt: continue
				    stack.append(nxt)
				    p[nxt] = cur
				    depth[nxt] = depth[cur] + 1

	- 스택 메모리가 1MB로 제한되어있을 땐 V가 3만 이상일 때 일자 트리 모양에서 스택 메모리 한계를 넘어설 수 있기 때문에 **V가 클 때 재귀로 DFS를 돌려서는 안된다.**

		  def dfs(cur, par):
			  for nxt in adj[cur]:
			  if par==nxt: continue
			  dfs(nxt, cur)
	
		  # call dfs(1, 0)

<br>

## :pushpin: 이진 트리의 순회
### 이진트리 : 정점의 자식이 최대 2개인 트리<br>

<image src="https://user-images.githubusercontent.com/34594339/95651022-36bbc100-0b22-11eb-80d6-79cedd35897e.png" width="80%">

<br>

- 전위 순회
	1. 현재 정점을 방문한다.
	2. 왼쪽 서브 트리를 전위 순회 한다.
	3. 오른쪽 서브 트리를 전위 순회한다.
<br>
		
	  lc = [0, 2, 4, 6, 0, 0, 0, 0, 0]
	  rc = [0, 3, 5, 7, 0, 8, 0, 0, 0]
	  def  preorder(cur):
		  print(cur)
		  if (lc[cur] !=0) preorder(lc[cur])
		  if (rc[cur] !=0) preorder(rc[cur])
		
	  # preorder(1)
	
<br>
 
- 중위 순회
	1. 왼쪽 서브 트리를 중위 순회한다.
	2. 현재 정점을 방문한다.
	3. 오른쪽 서브 트리를 중위 순회한다.
<br>

	  lc = [0, 2, 4, 6, 0, 0, 0, 0, 0]
	  rc = [0, 3, 5, 7, 0, 8, 0, 0, 0]
	  def  inorder(cur):
		  if (lc[cur] !=0) inorder(lc[cur])
		  print(cur)
		  if (rc[cur] !=0) inorder(rc[cur])
		
	  # inorder(1)
	
<br>

- 후위 순회
	1. 왼쪽 서브 트리를 후위 순회한다.
	2. 오른쪽 서브 트리를 후위 순회한다.
	3. 현재 정점을 방문한다.
<br>

	  lc = [0, 2, 4, 6, 0, 0, 0, 0, 0]
	  rc = [0, 3, 5, 7, 0, 8, 0, 0, 0]
	  def  postorder(cur):
		  if (lc[cur] !=0) postorder(lc[cur])
		  if (rc[cur] !=0) postorder(rc[cur])
		  print(cur)
		
	  # inorder(1)
	
<br>

parent = dict()
rank = dict()

def make_set(node):
    parent[node] = node
    rank[node] = 0

def find(node):
    # path compression 기법
    if parent[node] != node:    # 자기 자신을 부모 노드로 갖는 노드 (루트 노드) 나올 때까지 찾는다.
        parent[node] = find(parent[node])
    return parent[node] # root node

def union(node1, node2):
    root1 = find(node1)
    root2 = find(node2)

    # union-by-rank 기법

    if rank[root1] > rank[root2]:   # node1의 루트 노드가 node2의 루트 노드보다 큰 트리라면
        parent[root2] = root1       # node2 트리가 node1트리에 합쳐져 node1의 루트 노드가 합친 전체 트리의 루트 노드가 된다.

    else:
        parent[root1] = root2

        if rank[root1] == rank[root2]:  # 만약 두 트리가 같은 높이라면
            rank[root2] += 1            # node1 트리가 node2 트리에 합쳐졌으므로 node2 트리의 높이를 1 증가시킨다.

def kruskal(graph):
    mst = list()

    # 1. 초기화
    for node in graph['vertices']:
        make_set(node)

    # 2. 가중치 기준 정렬
    edges = graph['edges']
    edges.sort()

    # 3. 간선 연결 (No Cycles)
    for edge in edges:
        w, v, u = edge
        if find(v) != find(u): # 서로 루트 노드가 다르다면
            union(v, u)        # 두 트리를 합친다.
            mst.append(edge)

    return mst

mygraph = {
    'vertices': ['A', 'B', 'C', 'D', 'E', 'F', 'G'],
    'edges': [
        (7, 'A', 'B'),
        (5, 'A', 'D'),
        (7, 'B', 'A'),
        (8, 'B', 'C'),
        (9, 'B', 'D'),
        (7, 'B', 'E'),
        (8, 'C', 'B'),
        (5, 'C', 'E'),
        (5, 'D', 'A'),
        (9, 'D', 'B'),
        (7, 'D', 'E'),
        (6, 'D', 'F'),
        (7, 'E', 'B'),
        (5, 'E', 'C'),
        (7, 'E', 'D'),
        (8, 'E', 'F'),
        (9, 'E', 'G'),
        (6, 'F', 'D'),
        (8, 'F', 'E'),
        (11, 'F', 'G'),
        (9, 'G', 'E'),
        (11, 'G', 'F')
    ]
}

print(kruskal(mygraph))
# result : [(5, 'A', 'D'), (5, 'C', 'E'), (6, 'D', 'F'), (7, 'A', 'B'), (7, 'B', 'E'), (9, 'E', 'G')]
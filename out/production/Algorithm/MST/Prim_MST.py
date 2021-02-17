from collections import defaultdict
from heapq import *

def prim(start_node, edges):
    mst = list()

    # 인접한 정점을 갖는 dict 형태
    adjacent_edges = defaultdict(list)
    for w, u, v in edges:
        adjacent_edges[u].append((w, u, v))
        adjacent_edges[v].append((w, v, u))


    connected_nodes = set(start_node)                   # 연결된 노드 = 처음 노드로 초기화
    candidate_edge_list = adjacent_edges[start_node]    # 첫 노드에 인접한 노드를 후보 노드 리스트에 삽입
    heapify(candidate_edge_list)                        # 우선 순위 큐로 변환

    while candidate_edge_list:                          # 후보 노드 리스트 방문
        w, u, v = heappop(candidate_edge_list)          # 가장 가중치가 낮은 순으로 꺼내온다.
        if v not in connected_nodes:                    # 후보 노드가 아직 연결되지 않았다면
            connected_nodes.add(v)                      # 연결된 노드 리스트에 삽입
            mst.append((w, u, v))                       # mst 배열에 삽입

            for edge in adjacent_edges[v]:              # 선택된 후보 노드에서 이어 방문할 노드가
                if edge[2] not in connected_nodes:      # 연결된 노드가 아니라면
                    heappush(candidate_edge_list, edge) # 후보 노드 리스트에 삽입

    return mst


myedges = [
    (7, 'A', 'B'), (5, 'A', 'D'),
    (8, 'B', 'C'), (9, 'B', 'D'), (7, 'B', 'E'),
    (5, 'C', 'E'),
    (7, 'D', 'E'), (6, 'D', 'F'),
    (8, 'E', 'F'), (9, 'E', 'G'),
    (11, 'F', 'G')
]

print(prim('A', myedges))

'''
[(5, 'A', 'D'), 
(6, 'D', 'F'), 
(7, 'A', 'B'), 
(7, 'B', 'E'), 
(5, 'E', 'C'), 
(9, 'E', 'G')]
'''
import sys
from collections import deque

input=sys.stdin.readline


N = int(input())
tree = [ [] for i in range(N+1)]
parents = [0] * (N+1)
for _  in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

stack = deque([1])
while stack:
    cur = stack.popleft()
    for nxt in tree[cur]:
        if parents[cur] == nxt: continue    # 부모 노드가 아니면 자식 노드이다!
        stack.append(nxt)
        parents[nxt] = cur

for i in range(2, N+1):
    print(parents[i])
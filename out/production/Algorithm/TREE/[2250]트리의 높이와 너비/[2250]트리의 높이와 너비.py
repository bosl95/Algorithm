import sys
input=sys.stdin.readline

class node:
    def __init__(self):
        self.left=-1
        self.right=-1

def inorder(cur, depth):
    if nodes[cur].left>0: inorder(nodes[cur].left, depth+1)
    global idx
    left[depth] = min(left[depth], idx)
    idx += 1
    right[depth] = max(right[depth], idx)

    if nodes[cur].right>0: inorder(nodes[cur].right, depth+1)

N = int(input())
parent = [0]*(N+1)
nodes = [node() for _ in range(N+1)]
left, right = [sys.maxsize]*(N+1), [0]*(N+1)  # depth는 최대 N일 수 있으므로
for _ in range(N):
    a, b, c = map(int, input().split())
    if b!=-1:
        nodes[a].left = b
        parent[b] += 1
    if c!=-1:
        nodes[a].right = c
        parent[c] += 1

root = parent.index(0, 1)
idx = 1
inorder(root, 1)
idx, x = 0, 0
for i in range(N+1):
    if left[i]==sys.maxsize or right[i]==0:
        continue
    _x = right[i]-left[i]
    if x < _x:
        x = _x
        idx = i
print(idx, x)
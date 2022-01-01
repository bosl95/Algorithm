import sys
input=sys.stdin.readline

pre = [[], [], []]

def preorder(cur):
    pre[0].append(cur)
    if lc.get(cur): preorder(lc[cur])
    if rc.get(cur): preorder(rc[cur])

def inorder(cur):
    if lc.get(cur): inorder(lc[cur])
    pre[1].append(cur)
    if rc.get(cur): inorder(rc[cur])

def postorder(cur):
    if lc.get(cur): postorder(lc[cur])
    if rc.get(cur): postorder(rc[cur])
    pre[2].append(cur)

N = int(input())
lc = dict()
rc = dict()
for _ in range(N):
    x, l, r = input().split()
    if l != ".": lc[x] = l
    if r != ".": rc[x] = r
preorder('A')
inorder('A')
postorder('A')
for i in range(3):
    print(''.join(pre[i]))

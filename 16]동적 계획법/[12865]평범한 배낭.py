import sys; input=sys.stdin.readline
n, k = map(int, input().split())
bag = [ tuple(map(int, input().split())) for _ in range(n) ]
knap = [0]*(k+1)

for i in range(n):
    tmp = knap.copy()
    for j in range(bag[i][0], k+1):
        tmp[j] = max(knap[j], bag[i][1], knap[j-bag[i][0]]+bag[i][1])
    knap = tmp
print(knap[-1])
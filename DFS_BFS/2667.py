import sys;input=sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split()[0])) for _ in range(n) ]
dfs = []; visit = []; count=[]

def DFS(a, b):
    dfs.append((a, b))
    depth = 0
    while dfs:
        a, b = dfs.pop()
        if (a, b) not in visit:
            visit.append((a, b))
            depth+=1
            if a-1>=0 and arr[a-1][b]==1 and (a-1, b) not in visit: dfs.append((a-1, b))
            if a+1<n and arr[a+1][b]==1 and (a+1, b) not in visit: dfs.append((a+1, b))
            if b-1>=0 and arr[a][b-1]==1 and (a, b-1) not in visit: dfs.append((a, b-1))
            if b+1<n and arr[a][b+1]==1 and (a, b+1) not in visit: dfs.append((a, b+1))
    return depth

for i in range(n):
    for j in range(n):
        if arr[i][j]==1:
            result = DFS(i, j)
            if result != 0 : count.append(result)

print(len(count)); count.sort()
for c in count:
    print(c)

'''
맞았어요ㅜㅜㅜㅜ 감격쓰
'''
import sys; input = sys.stdin.readline
n, m = map(int, input().split())
arr = [ list(map(int, input().split())) for _ in range(n) ]

def solution(n, m, arr):
    visit = [[0]*m for _ in range(n)]
    count = 0; max=0
    for i in range(n):
        for j in range(m):
            if visit[i][j]==0 and arr[i][j]==1:
                cnt = DFS(i, j, n, m, visit, arr)
                if max < cnt:
                    max = cnt
                count += 1
    return (count, max)

def DFS(i, j, n, m, visit,  arr):
    stack = [(i, j)]
    count = 0
    while stack :
        i, j = stack.pop()
        if visit[i][j]==0: count+=1
        visit[i][j] = 1

        for mx, my in [0, 1], [1, 0], [-1, 0], [0, -1]:
            mi = i + mx
            mj = j+ my
            if 0<=mi<n and 0<= mj <m and visit[mi][mj]==0 and arr[mi][mj]==1:
                stack.append((mi, mj))
    return count

a, b = solution(n, m, arr)
print("{}\n{}".format(a, b))
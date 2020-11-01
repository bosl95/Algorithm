import sys
input=sys.stdin.readline

def chk(n, arr, l):
    ch = [False for _ in range(n)]
    for i in range(n-1):
        if arr[i] == arr[i+1]:  continue
        if abs(arr[i]-arr[i+1]) > 1: return False # 층이 2 이상이면
        if arr[i] > arr[i+1]:   # 내리막 경사길
            temp = arr[i+1]
            for j in range(i+1, i+1+l):
                if 0 <= j < n:
                    if arr[j] != temp: return False # 경사길을 놔야 할 곳이 평평하지 않으면
                    if ch[j]: return False          # 이미 경사길이 놓여져 있다면
                    ch[j] = True
                else:
                    return False
        else:                   # 오르막 경사길
            temp = arr[i]
            for j in range(i, i-l, -1):
                if 0 <= j < n:
                    if arr[j]!=temp: return False
                    if ch[j]: return False
                    ch[j] = True
                else:
                    return False
    return True

def solution(n, l, rows, cols):
    ans = 0
    for i in range(n):
       if chk(n, rows[i], l): ans += 1
       if chk(n, cols[i], l): ans += 1
    return ans

N, L = map(int, input().split())
cols, rows = [[] for _ in range(N)], []
for i in range(N):
    tmp = list(map(int, input().split()))
    for j in range(N):
        cols[j].append(tmp[j])
    rows.append(tmp)
print(solution(N, L, rows, cols))

'''
4 3
6 5 4 6
9 7 1 3
7 3 5 4
1 4 6 8

'''
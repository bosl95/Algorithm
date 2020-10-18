import sys
from copy import deepcopy

input=sys.stdin.readline

def check(x, y, v, nm, sticker):
    v = deepcopy(v)
    for i in range(nm[0]):
        for j in range(nm[1]):
            if sticker[i][j] == 1:
                if v[x+i][y+j]==1:
                    return (False, None)
                elif v[x+i][y+j]==0:
                    v[x+i][y+j] = 1
    return (True, v)

def DFS(i, x, note, cnt):
    if i == K :
        print(cnt)
        sys.exit()
    if x == 0:
        ch = False
        for a in range(N-st_nm[i][0]):
            for b in range(M-st_nm[i][1]):
                (ch, _v) = check(a, b, note, st_nm[i], sticker[i][x])
                if ch: break
        if ch:
            for k in range(4):
                DFS(i+1, k, _v, num[i]+cnt)
        else:
            for k in range(4):
                DFS(i+1, k, note, cnt)
    elif x == 1:
        ch = False
        for a in range(M-st_nm[i][1]):
            for b in range(N-st_nm[i][0]):
                (ch, _v) = check(a, b, note, st_nm[i], sticker[i][x])
                if ch: break
        if ch:
            for k in range(4):
                DFS(i + 1, k, _v, num[i] + cnt)
        else:
            for k in range(4):
                DFS(i + 1, k, note, cnt)



N, M, K = map(int, input().split())
sticker = []; st_nm = []; num = []  # 스티커 배열(0도/90도/180도/270), 스티커 n1, m1, 스티커 "1"의 개수
for _ in range(K):
    x, y = map(int, input().split())
    st_nm.append((x, y))
    count,  tmp = 0, []     # 스티커 개수 카운트
    for _ in range(x):
        z = list(map(int, input().split()))
        count += z.count(1)
        tmp.append(z)
    num.append(count)

notebook = [[0]*M for _ in range(N)]
DFS(0, 0, notebook, 0)
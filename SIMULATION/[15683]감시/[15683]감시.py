import sys, heapq as hp
input=sys.stdin.readline

def top(a, b, visit):
    count = 0
    for i in range(1, a + 1):
        if room[a - i][b] == 6 : break
        if room[a - i][b] ==0:
            visit[a - i][b] += 1
            count += 1
    return count

def bottom(a, b, visit):
    count = 0
    for i in range(a + 1, N):
        if room[i][b] == 6 : break
        if room[i][b] == 0:
            visit[i][b] += 1
            count += 1
    return count

def left(a, b, visit):
    count = 0
    for i in range(1, b + 1):
        if room[a][b - i] == 6 : break
        if room[a][b - i] == 0:
            visit[a][b - i] += 1
            count += 1
    return count

def right(a, b, visit):
    count = 0
    for i in range(b + 1, M):
        if room[a][i] == 6 : break
        if room[a][i] == 0 :
            visit[a][i] += 1
            count += 1
    return count

def back(a, b, dir, visit):    # 되돌리기
    if dir == 0:
        for i in range(1, a + 1):
            if room[a - i][b] == 6: break
            visit[a-i][b] = 0
    elif dir == 1:
        for i in range(a+1, N):
            if room[i][b] == 6: break
            visit[i][b] = 0
    elif dir == 2:
        for j in range(1, b+1):
            if room[a][b-j] == 6: break
            visit[a][b-j] = 0
    elif dir == 3:
        for j in range(b+1, M):
            if room[a][j] == 6: break
            visit[a][j] = 0

def cctv3(a, b, visit):
    chk = [-1] * 4

    chk[0] = top(a, b, visit)
    chk[1] = bottom(a, b, visit)
    chk[2] = left(a, b, visit)
    chk[3] = right(a, b, visit)

    x = chk[0]+chk[1]; i, j = 0, 1
    if x > chk[0]+chk[1]:



def cctv4(a, b, visit):
    chk = [-1] * 4

    chk[0] = top(a, b, visit)
    chk[1] = bottom(a, b, visit)
    chk[2] = left(a, b, visit)
    chk[3] = right(a, b, visit)

    idx = -1
    for i in range(4):
        if chk[i] == -1 or idx == -1: idx = i
        if chk[idx] > chk[i]: idx = i

    if chk[idx] != -1:
        back(a, b, idx, visit)

def cctv5(a, b, visit):
    top(a, b, visit)
    bottom(a, b, visit)
    left(a, b, visit)
    right(a, b, visit)


def solution(n, m, cctv):
    visit = [[0]*m for _ in range(n)]

    for num, a, b in cctv:
        # check
        visit[a][b] = 1
        if num==-5: cctv5(a, b, visit)
        elif num==-4: cctv4(a, b, visit)
    for v in visit:
        print(v)


N, M = map(int, input().split())
room = []; CCTV = []
for i in range(N):
    t = list(map(int, input().split()))
    for j in range(M):
        if 0<t[j]<6:
            hp.heappush(CCTV, (-t[j], i, j))
    room.append(t)
solution(N, M, CCTV)
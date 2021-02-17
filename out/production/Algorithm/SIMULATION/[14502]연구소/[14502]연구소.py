import sys
from copy import deepcopy
from itertools import combinations
input=sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def chkArea(close):
    room = deepcopy(Room)
    for c in close:
        x, y = c//M, c%M
        room[x][y] = 1
    stack = virus.copy()
    while stack:
        m = stack.pop()
        x, y = m//M, m%M
        for i in range(4):
            mx, my = x+dx[i], y+dy[i]
            if 0<=mx<N and 0<=my<M and room[mx][my]==0:
                stack.append(M*mx+my)
                room[mx][my] = 1
    ans = 0
    for r in room:
        ans += r.count(0)
    return ans, room

def solution():
    Answer = 0
    for coms in combinations(wall, 3):
        tmp_ans, r = chkArea(coms)
        if tmp_ans > Answer:
            Answer = tmp_ans
    return Answer

N, M = map(int, input().split())
Room = []; virus = []; wall = []
for i in range(N):
    tmp = list(map(int, input().split()))
    Room.append(tmp)
    for j in range(M):
        num = i * M + j
        if tmp[j]==2:
            virus.append(num)
            Room[i][j] = 1
        elif tmp[j]==0:
            wall.append(num)
print(solution())
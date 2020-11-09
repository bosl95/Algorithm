import sys
from copy import deepcopy
input=sys.stdin.readline


def check(area, dirs, a, b, cnt):
    area = deepcopy(area)
    for d in dirs:
        if d == 0 and b < m-1 :  # 오
            for j in range(b+1, m):
                if area[a][j] == 0:
                    area[a][j] = '#'
                    cnt -= 1
                elif area[a][j] == 6: break
        elif d == 1 and b > 0:    # 왼
            for j in range(b-1, -1, -1):
                if area[a][j] == 0:
                    area[a][j] = '#'
                    cnt -= 1
                elif area[a][j] == 6: break
        elif d == 2 and a < n-1:    # 아래
            for i in range(a+1, n):
                if area[i][b] == 0:
                    area[i][b] = '#'
                    cnt -= 1
                elif area[i][b] == 6: break
        elif d == 3 and a > 0:      # 위
            for i in range(a-1, -1, -1):
                if area[i][b] == 0:
                    area[i][b] = '#'
                    cnt -= 1
                elif area[i][b] == 6: break

    return area, cnt


def solution(room, cnt, idx):
    global ans
    if idx == len(cctv):
        if ans > cnt: ans = cnt
        return
    x, y, num = cctv[idx]

    # 오 왼 아래 위
    if num == 1:
        for i in range(4):
            nxt_room, nxt_cnt = check(room, [i], x, y, cnt)
            solution(nxt_room, nxt_cnt, idx + 1)
    elif num == 2:
        for i in [[0, 1], [2, 3]]:
            nxt_room, nxt_cnt = check(room, i, x, y, cnt)
            solution(nxt_room, nxt_cnt, idx + 1)
    elif num == 3:
        for i in [[0, 2], [1, 2], [1, 3], [0, 3]]:
            nxt_room, nxt_cnt = check(room, i, x, y, cnt)
            solution(nxt_room, nxt_cnt, idx + 1)
    elif num == 4:
        for i in [[0, 1, 2], [0, 2, 3], [0, 1, 3], [1, 2, 3]]:
            nxt_room, nxt_cnt = check(room, i, x, y, cnt)
            solution(nxt_room, nxt_cnt, idx+1)
    else:
        nxt_room, nxt_cnt = check(room, [0, 1, 2, 3], x, y, cnt)
        solution(nxt_room, nxt_cnt, idx+1)


n, m = map(int, input().split())
Room = []; cctv, cnt = [], 0
ans = sys.maxsize
for i in range(n):
    tmp = list(map(int, input().split()))
    for j in range(m):
        if tmp[j] == 0: cnt += 1; continue
        elif tmp[j] == 6: continue
        cctv.append((i, j, tmp[j]))
    Room.append(tmp)
solution(Room, cnt, 0)
print(ans)
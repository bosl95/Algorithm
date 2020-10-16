import sys
from copy import deepcopy

# dirs ==> 0 : 왼 / 1 : 위 / 2 : 오 / 3 : 아래

def check(area, dirs, a, b):
    area = deepcopy(area)
    for d in dirs:
        if d == 0:      # 왼
            for j in range(b, -1, -1):
                if area[a][j] == 6:
                    break
                elif area[a][j] != 0:
                    continue
                else:
                    area[a][j] = "#"

        elif d == 1:    # 위
            for j in range(a, -1, -1):
                if area[j][b] == 6: break
                elif area[j][b] != 0: continue
                else: area[j][b] = "#"
        elif d == 2:    # 오
            for j in range(b, m):
                if area[a][j] == 6:
                    break
                elif area[a][j] != 0:
                    continue
                else:
                    area[a][j] = "#"
        elif d == 3:    # 아래
            for j in range(a, n):
                if area[j][b] == 6: break
                elif area[j][b] != 0: continue
                else: area[j][b] = "#"
    return area


def dfs(areas, cctvs, idx):
    global mins
    if idx == len(cctvs):
        value = 0
        for k in range(n):
            value += areas[k].count(0)
        mins = min(mins, value)
        return

    cctv = cctvs[idx]
    a, b, kind = cctv
    if kind == 1:
        for i in range(4):
            next_area = check(areas, [i], a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 2:
        for i in [(0, 2), (1, 3)]:  # 왼 오 or 위 아래
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 3:
        for i in [(0, 1), (1, 2), (2, 3), (3, 0)]:
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 4:
        for i in [(0, 1, 2), (1, 2, 3), (2, 3, 0), (3, 0, 1)]:  # (왼, 위, 오), (위, 오, 아래), (오, 아래, 왼), (아래, 왼, 위)
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 5:
        next_area = check(areas, (0, 1, 2, 3), a, b)
        dfs(next_area, cctvs, idx+1)


n, m = map(int, sys.stdin.readline().split())
area, cctvs = [],  []; mins = sys.maxsize

for i in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if 1 <= tmp[j] <= 5:
            cctvs.append((i, j, tmp[j]))
    area.append(tmp)

dfs(area, cctvs, 0)
print(mins)
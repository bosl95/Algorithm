import sys
from itertools import combinations

input=sys.stdin.readline

def solution(n, m, city, ch, home):
    ch_num, h_num = len(ch), len(home); ans = sys.maxsize
    dis = [[0]*ch_num for _ in range(h_num)]
    for chicken_arr in list(combinations([k for k in range(ch_num)], m)):
        tmp = 0
        for i in range(h_num):      # 집마다 치킨거리 구하기
            tmp2 = sys.maxsize      # 치킨집 중에서 가장 짧은 거리를 구하기 위한 tmp2
            for j in chicken_arr:
                if dis[i][j] == 0:
                    dis[i][j] = abs(home[i][0]-ch[j][0])+abs(home[i][1]-ch[j][1])
                if tmp2 > dis[i][j]: tmp2 = dis[i][j]
            tmp += tmp2
        if ans > tmp: ans = tmp
    return ans


N, M = map(int, input().split())
City = []; chicken =[]; house = []
for i in range(N):
    t = list(map(int, input().split()))
    for j in range(N):
        if t[j] == 0: continue
        elif t[j] == 1: house.append((i, j))
        elif t[j] == 2: chicken.append((i, j))
    City.append(t)

print(solution(N, M, City, chicken, house))
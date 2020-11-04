import sys
input=sys.stdin.readline

# 0 : x 좌표 증가 / 1 : y 좌표 감소 / 2 : x 좌표 감소 / 3 : y 좌표 증가
dx = [1, 0, -1, 0]
dy = [0, -1, 0, 1]
def dragon(x, y, d, g, dic1):
    dic1[(x, y)] = 1
    list1 = [d]     # 모든 선분의 방향을 담는 배열
    x += dx[d]
    y += dy[d]
    dic1[(x, y)] = 1
    for _ in range(g):      # g세대까지 탐색
        sub = []    # 새로 생기는 선분을 담을 임시 배열
        for i in range(len(list1)-1, -1, -1):   # 가장 최근 선분 부터 방문
            x += dx[(list1[i]+1)%4]
            y += dy[(list1[i]+1)%4]
            dic1[(x, y)] = 1        # (x, y) 좌표의 꼭지점 방문
            sub.append((list1[i]+1)%4)
        list1 += sub

n = int(input())
ans = 0
dic = {}

for _ in range(n):
    x, y, d, g = map(int,input().split())
    dragon(x, y, d, g, dic)

for nx, ny in list(dic.keys()):
    count = 0
    if dic.get((nx+1, ny)) == 1:
        count += 1
    if dic.get((nx, ny+1)) == 1:
        count += 1
    if dic.get((nx + 1, ny+1)) == 1:
        count += 1
    if count == 3:  # 사각형을 이루면
        ans += 1
print(ans)


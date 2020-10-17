import sys
input=sys.stdin.readline

N, M, K = map(int, input().split())
sticker = []; st_nm = []; num = []  # 스티커 배열, 스티커 n1, m1, 스티커 "1"의 개수
for _ in range(K):
    x, y = map(int, input().split())
    st_nm.append((x, y))
    count,  tmp = 0, []     # 스티커 개수 카운트
    for _ in range(x):
        z = list(map(int, input().split()))
        count += z.count(1)
        tmp.append(z)
    num.append(count)

DFS(0, 0, )
import sys
input=sys.stdin.readline

def ladder():
    for i in range(N):
        k = i           # 사다리를 타고 이동할 k
        for j in range(H):
            if line[j][k]:
                k += 1
            elif k > 0 and line[j][k-1]:
                k -= 1
        if i != k:      # 도착한 위치가 i가 아니라면
            return False
    return True

def solution(cnt, x, y):
    global ans
    if ans <= cnt:     # ans보다 cnt가 크다면 더 검사할 필요가 없으므로 pass
        return
    if ladder():
        ans = min(ans, cnt)
    if cnt == 3:
        return
    for i in range(x, H):
        k = y if i == x else 0
        for j in range(k, N-1):
            if line[i][j]:
                j += 1
            else:
                line[i][j] = 1  # 가로줄 만들기
                solution(cnt+1, i, j+2) # j+2 번째 세로줄로 이동한다.
                line[i][j] = 0

ans = 4
N, M, H = map(int, input().split())
line = [[0]*N for _ in range(H)]
for _ in range(M):
    x, y = map(int, input().split())
    line[x-1][y-1] = 1
solution(0, 0, 0)
print(ans if ans<4 else -1)
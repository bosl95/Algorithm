## ver 1

import sys
input=sys.stdin.readline

def rotate(b):  # 90도 회전 함수
    n, m = len(b), len(b[0])
    res = [[ b[n-i-1][j] for i in range(n) ] for j in range(m)]
    return res

def check(x, y, sticker_array):
    n1, m1 = len(sticker_array), len(sticker_array[0])
    for x1 in range(n1):
        for y1 in range(m1):
            if sticker_array[x1][y1] == 0:
                continue
            elif laptop[x+x1][y+y1] == 1:
                return False
    return True

if __name__ == '__main__':
    ans = 0
    n, m, k = map(int, input().split())
    laptop = [[0]*m for _ in range(n)]
    sticker = [{} for _ in range(k)]

    for i in range(k):
        sticker[i]['r'], sticker[i]['c'] = map(int, input().split())
        sticker[i]['sticker'] = [list(map(int, input().split())) for _ in range(sticker[i]['r'])]

    for num in range(k):
        cnt = 0
        r, c = sticker[num]['r'], sticker[num]['c']
        st = sticker[num]['sticker']
        while cnt < 4:      # 회전하기
            success = 0
            for i in range(n-r+1):
                for j in range(m-c+1):
                    if not check(i, j, st): continue    # 시작점을 i, j로 board를 laptop에 붙일 수 있는지 체크
                    for a in range(r):                  # 스티커 붙일 수 있는 경우 laptop 배열에 붙이기
                        for b in range(c):
                            if st[a][b]==1:
                                laptop[i+a][j+b] = 1
                                ans += 1
                    success = 1             # 스티커 붙였음 (success=1)
                    break
                if success: break                       # 스티커 붙였으면 이중 for문 빠져나가기
            if success: break
            else:                                       # 스티커를 못 붙였다면 회전시키기
                r, c, st = c, r, rotate(st)
                cnt += 1
    print(ans)


## ver 2

import sys
input=sys.stdin.readline

def check(x, y, v, st, n1, m1):
    for i in range(n1):
        for j in range(m1):
            if st[i][j] == 0: continue
            elif v[x+i][y+j]==1: return False
    return True


def rotate(b):  # 90도 회전 함수
    n, m = len(b), len(b[0])
    res = [[ b[n-i-1][j] for i in range(n) ] for j in range(m)]
    return res

def DFS(x, note, cnt):
    if x==K:
        print(cnt)
        sys.exit()
    ch = False
    stick = sticker[x]
    n, m = len(stick), len(stick[0])
    for k in range(4):
        for i in range(N-n+1):
            for j in range(M-m+1):
                ch = check(i, j, note, stick, n, m)
                if ch:
                    for a in range(n):
                        for b in range(m):
                            if stick[a][b] == 1:
                                note[i+a][j+b] = 1
                    DFS(x+1, note, cnt+num[x])
                    return
        stick = rotate(stick)
        n, m = m, n
    DFS(x+1, note, cnt)


N, M, K = map(int, input().split())
sticker = []; st_nm = []; num = []  # 스티커 배열(0도/90도/180도/270), 스티커 n1, m1, 스티커 "1"의 개수
for i in range(K):
    x, y = map(int, input().split())
    st_nm.append((x, y))
    count,  tmp = 0, []     # 스티커 개수 카운트
    for _ in range(x):
        z = list(map(int, input().split()))
        count += z.count(1)
        tmp.append(z)
    sticker.append(tmp)
    num.append(count)


notebook = [[0]*M for _ in range(N)]
DFS(0, notebook, 0)
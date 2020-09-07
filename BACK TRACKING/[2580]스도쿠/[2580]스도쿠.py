import sys
input = sys.stdin.readline

def check(x, y, b):
    chk = [ i for i in range(1, 10) ]
    for i in range(9):
        if b[x][i] != 0 and b[x][i] in chk:      # x행에서 불가능한 숫자 제외
            chk.remove(b[x][i])

        if b[i][y] != 0 and b[i][y] in chk:     # y열에서 불가능 숫자 제외
            chk.remove(b[i][y])

    ii, jj = x//3, y//3      # 3 * 3 행렬 체크
    for i in range(3*ii, 3*ii+3):
        for j in range(3*jj, 3*jj+3):
            if b[i][j] != 0 and b[i][j] in chk:
                chk.remove(b[i][j])

    return chk

def solution(b, z):
    dfs(0, b, z)

def dfs(x, b, z):
    global flag
    if flag:
        return

    if x == len(z):
        for row in b:
            print(*row)
        flag = True
        return
    else:
        i, j = z[x]
        chkList = check(i, j, b)

        for p in chkList:
            b[i][j] = p
            dfs(x+1, b, z)
            b[i][j] = 0

board, zero = [], []
for i in range(9):
    tmp = list(map(int, input().split()))
    for j in range(9):
        if tmp[j] == 0:
            zero.append([i, j])
    board.append(tmp)
flag = False
solution(board, zero)


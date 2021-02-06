import sys
input=sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def check(i, j):
    stack, pop = [(i, j)], {(i, j)}
    col = field[i][j]; chk = set()
    while stack:
        x, y = stack.pop()
        chk.add(y)
        for i in range(4):
            mx, my = x+dx[i], y+dy[i]
            if 0<=mx<12 and 0<=my<6 and field[mx][my]==col and (mx, my) not in pop:
                stack.append((mx, my))
                pop.add((mx, my))
    return list(pop), list(chk)

def delete(pop):
    while pop:  # 뿌요 제거 및 pop된 영역 구해주기
        i, j = pop.pop()
        field[i][j] = '.'

def move(ch):
    for c in ch:
        tmp = []
        for i in range(12):
            if field[i][c] != '.':
                tmp.append(field[i][c])
                field[i][c] = '.'
        for i in range(len(tmp)):
            field[11-i][c] = tmp.pop()


def solution(f):
    cnt, flag = 0, False
    while True:
        ch = set()
        for i in range(12):
            for j in range(6):
                if f[i][j]!='.':
                    pop, chk = check(i, j)
                    if len(pop)>=4:
                        delete(pop)
                        ch.update(chk)
                        flag = True
        if flag:
            cnt += 1
            move(ch)
            flag = False
        else:
            return cnt

field = []
top_row = [11] * 6
for i in range(12):
    t = list(input().strip())
    for j in range(6):
        if t[j]!='.' and top_row[j] > i:
            top_row[j] = i
    field.append(t)
print(solution(field))
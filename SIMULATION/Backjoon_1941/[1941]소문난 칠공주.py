import sys
input=sys.stdin.readline

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
ans = set()

def dfs(line, stack):
    s = list(stack).copy()
    if len(stack)==7:
        stack = tuple(sorted(stack))
        ans.add(stack)
        return
    while s:
        m = s.pop()
        x, y = m//5, m%5
        for i in range(4):
            mx, my = dx[i]+x, dy[i]+y
            if 0<=mx<5 and 0<=my<5 and 5*mx+my not in stack:
                if (stu[mx][my]=='Y' and line.count('Y')<3) or (stu[mx][my]=='S'):
                    stack.add(5*mx+my)
                    dfs(line+stu[mx][my], stack)
                    stack.remove(5*mx+my)

def solution(stu):
    for i in range(5):
        for j in range(5):
            dfs(stu[i][j], set([5*i+j]))
    print(len(ans))

stu = [ list(input()) for i in range(5)]
solution(stu)
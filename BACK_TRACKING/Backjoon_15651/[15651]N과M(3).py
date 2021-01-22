def chk(a, visit, n, m):
    if len(a)==m:
        print(*a)
    else:
        for i in range(1, n+1):
            a.append(i)
            visit[i] = 1
            chk(a, visit, n, m)
            a.pop()
            visit[i] = 0

def solution(n, m):
    visit = [0] * (n+1)
    for i in range(1, n+1):
        visit[i] = 1
        chk([i], visit, n, m)
        visit[i] = 0

n, m = map(int, input().split())
solution(n, m)
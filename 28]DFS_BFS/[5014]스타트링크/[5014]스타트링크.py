from collections import deque

def solution(F, S, G, U, D):
    visit = [0]*(F+1)
    stack = deque([S])
    while stack:
        x = stack.popleft()
        v = visit[x]
        if x == G:
            return visit[x]
        if x+U <= F and visit[x+U]==0:
            visit[x+U] = v+1
            stack.append(x+U)
        if x-D > 0 and visit[x-D]==0:
            visit[x-D] = v+1
            stack.append(x-D)
    return "use the stairs"

f, s, g, u, d = map(int, input().split())
print(solution(f, s, g, u, d))

'''
1. 위로 U만큼
2. 아래로 D만큼
1과 2의 먼저 실행되는 순서는 없어야한다.
'''
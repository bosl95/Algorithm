import sys;
from collections import deque

input =sys.stdin.readline
def fire(stack, w, h, build):
    fcnt = [ [0]*h for _ in range(w)]

    while stack:
        i, j  = stack.popleft()
        for x, y in (-1, 0), (0, -1), (1, 0), (0, 1):
            mx = x + i
            my = y + j
            if 0<=mx<w and 0<=my<h and build[mx][my] in ['.', '@'] and fcnt[mx][my]==0:
                stack.append((mx, my))
                fcnt[mx][my] = fcnt[i][j] + 1
    return fcnt

def solution(w, h, build):
    fstack = deque()
    human = deque()
    for i in range(w):
        for j in range(h):
            if build[i][j] == '*':
                fstack.append((i, j))
            elif build[i][j] == '@':
                if i == 0 or i == w-1 or j==0 or j==h-1:
                    return 1
                human.append((i, j))

    farr = fire(fstack, w, h, build)

    hcnt = [[0]*h for _ in range(w)]
    while human:
        i, j = human.popleft()
        for x, y in (-1, 0), (0, -1), (1, 0), (0, 1):
            mx = i + x
            my = j + y
            if 0<=mx<w and 0<=my<h and build[mx][my]=='.' and hcnt[mx][my]==0 and (farr[mx][my]==0 or hcnt[i][j]+1 < farr[mx][my]):
                if mx == 0 or mx == w - 1 or my == 0 or my == h - 1:
                    return hcnt[i][j] + 2
                human.append((mx, my))
                hcnt[mx][my] = hcnt[i][j] + 1

    return "IMPOSSIBLE"

n = int(input())
for _ in range(n):
    w, h = map(int, input().split())
    tmp = [ list(input().strip()) for _ in range(h)]
    print(solution(h, w, tmp))
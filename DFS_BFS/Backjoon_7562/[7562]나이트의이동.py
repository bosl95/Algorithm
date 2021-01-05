import sys; input=sys.stdin.readline

def bfs(board, start, end, n):
    mv = [[1,2], [2,1], [2,-1], [1,-2], [-1,-2], [-2, -1], [-2, 1], [-1, 2]]
    stack = [start]
    while stack:
        i, j = stack.pop(0)
        if [i, j]== end:
            return
        for x, y in mv:
            mx = i + x
            my = j + y
            if 0<=mx<n and 0<=my<n and board[mx][my]==0:
                stack.append([mx, my])
                board[mx][my] = board[i][j] + 1

def solution(n, start, end):
    board = [[0] * n for _ in range(n)]
    bfs(board, start, end, n)
    return board[end[0]][end[1]]

m = int(input())
for _ in range(m):
    n = int(input())
    start = list(map(int, input().split()))
    end = list(map(int, input().split()))
    print(solution(n, start, end))

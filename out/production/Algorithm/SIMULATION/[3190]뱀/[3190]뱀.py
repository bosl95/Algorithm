import sys
from collections import deque

input=sys.stdin.readline

def solution(n, k, board, l, turn):
    snake = deque([(0, 0)])
    x, y = 0, 0
    time, idx, board[0][0] = 1, 0, -1

    while True:
        if idx == 0: y += 1
        elif idx == 1: x += 1
        elif idx == 2: y -= 1
        elif idx == 3: x -= 1
        if x < 0 or x >= n or y < 0 or y >= n: return time
        if turn and time == int(turn[0][0]):
            idx = idx + 1 if turn[0][1] == 'D' else idx - 1
            idx %= 4
            del turn[0]
        if board[x][y]!=-1:
            if board[x][y]==0:
                x_, y_ = snake.popleft()
                board[x_][y_] = 0
            board[x][y] = -1
            snake.append((x, y))
            time += 1
        else:
            return time

N = int(input())
K = int(input())
Board = [[0]*N for _ in range(N)]
for _ in range(K):
    x, y = map(int, input().split())
    Board[x-1][y-1] = 1
L = int(input())
Turn = [input().strip().split() for _ in range(L)]
print(solution(N, K, Board, L, Turn))
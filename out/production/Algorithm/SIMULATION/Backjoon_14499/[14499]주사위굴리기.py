import sys
input=sys.stdin.readline

def solution(x, y):
    dice = [0, 0, 0, 0, 0, 0]   # 위 앞 뒤 왼 오 아래

    for m in move:
        if m == 1:      # 동
            if y == M-1: continue
            y += 1
            dice[0], dice[3], dice[4], dice[5] = dice[3], dice[5], dice[0], dice[4]
        elif m == 2:    # 서
            if y==0: continue
            y -= 1
            dice[0], dice[3], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[3]
        elif m == 3 :   # 북
            if x==0: continue
            x -= 1
            dice[0], dice[1], dice[2], dice[5] = dice[1], dice[5], dice[0], dice[2]
        elif m == 4 :   # 남
            if x == N-1: continue
            x += 1
            dice[0], dice[1], dice[2], dice[5] = dice[2], dice[0], dice[5], dice[1]
        print(dice[0])
        if Map[x][y]:
            dice[5] = Map[x][y]
            Map[x][y] = 0
        else:
            Map[x][y] = dice[5]


N, M, x, y, k = map(int, input().split())
Map = [list(map(int, input().split())) for _ in range(N) ]
move = list(map(int, input().split()))
solution(x, y)
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]  # 왼 위 오 아래

def solution(maze):
    n = len(maze)
    vx, vy, x, y = 1, 1, 0, 0   # 왼쪽 사이드 방향
    cnt = 0

    while True:
        mx, my = x + dx[vx], y+dy[vy]   # 왼쪽 사이드 칸 인덱스
        if 0<=mx<n and 0<=my<n and maze[mx][my]==0: # 왼쪽에 벽이 없으면 왼쪽 회전
            if vx-1 == -1:
                vx, vy = 3, 3
            else:
                vx, vy = vx-1, vy-1

        if vx+1==4:
            vx1, vy1 = 0, 0
        else:
            vx1, vy1 = vx+1, vy+1
        mx, my = x + dx[vx1], y+dy[vy1]   # 직진 사이드 인덱스
        if 0<=mx<n and 0<=my<n and maze[mx][my] == 0:
            cnt += 1
            x, y = mx, my
        else:
            vx, vy = (vx+1)%4, (vy+1)%4 # 오른쪽 회전


        if (x, y) == (n-1, n-1):
            return cnt




print(solution([[0, 1, 0, 1], [0, 1, 0, 0], [0, 0, 0, 0], [1, 0, 1, 0]]	))
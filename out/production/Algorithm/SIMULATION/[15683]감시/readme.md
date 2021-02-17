
## simulation을 이용한 풀이

<image src="https://lh4.googleusercontent.com/z5V_9kIeva5WLqgaunm3ldgAnGQ2z6e3ezVrbO-m5ssNORgLclP_ERuLFh5IylN6YE5V9PB6Y9QsFi0nsoCKs4KxjUaBHxkZeP5ulC2c-34kjm2t3u8kmDf3Uon4E5ipt3ojKQ6x" width="70%">

### 1차 풀이 (~~오답~~)

    import sys, heapq as hp
    input=sys.stdin.readline
    
    def top(a, b, visit):
        count = 0
        for i in range(1, a + 1):
            if room[a - i][b] == 6 : break
            # if room[a - i][b] ==0:
            else:
                visit[a - i][b] += 1
                count += 1
        return count
    
    def bottom(a, b, visit):
        count = 0
        for i in range(a + 1, N):
            if room[i][b] == 6 : break
            # if room[i][b] == 0:
            else:
                visit[i][b] += 1
                count += 1
        return count
    
    def left(a, b, visit):
        count = 0
        for i in range(1, b + 1):
            if room[a][b - i] == 6 : break
            # if room[a][b - i] == 0:
            else:
                visit[a][b - i] += 1
                count += 1
        return count
    
    def right(a, b, visit):
        count = 0
        for i in range(b + 1, M):
            if room[a][i] == 6 : break
            # if room[a][i] == 0 :
            else:
                visit[a][i] += 1
                count += 1
        return count
    
    def back(a, b, dir, visit):    # 되돌리기
        if dir == 0:
            for i in range(1, a + 1):
                if room[a - i][b] == 6: break
                visit[a-i][b] -= 1
        elif dir == 1:
            for i in range(a+1, N):
                if room[i][b] == 6: break
                visit[i][b] -= 1
        elif dir == 2:
            for j in range(1, b+1):
                if room[a][b-j] == 6: break
                visit[a][b-j] -= 1
        elif dir == 3:
            for j in range(b+1, M):
                if room[a][j] == 6: break
                visit[a][j] -= 1
    
    def cctv1(a, b, visit):
        chk = [0] * 4;
    
        chk[0] = top(a, b, visit)
        i = 0;x = chk[0]
        chk[1] = bottom(a, b, visit)
        if x < chk[1]: i = 1; x = chk[1]
        chk[2] = left(a, b, visit)
        if x < chk[2]: i = 2; x = chk[2]
        chk[3] = right(a, b, visit)
        if x < chk[3]: i = 3; x = chk[3]
    
        for j in range(4):
            if j == i: continue
            back(a, b, j, visit)
    
    
    def cctv2(a, b, visit):
        chk = [0] * 4
    
        chk[0] = top(a, b, visit)
        chk[1] = bottom(a, b, visit)
        chk[2] = left(a, b, visit)
        chk[3] = right(a, b, visit)
    
        x, y = chk[0]+chk[1], chk[2]+chk[3]
        i, j = (0, 1) if x < y  else (2, 3)
        back(a, b, i, visit)
        back(a, b, j, visit)
    
    def cctv3(a, b, visit):
        chk = [0] * 4
    
        chk[0] = top(a, b, visit)
        chk[1] = bottom(a, b, visit)
        chk[2] = left(a, b, visit)
        chk[3] = right(a, b, visit)
    
        x = chk[0]+chk[2]; i, j = 0, 2  # 위 / 왼
        if x > chk[0]+chk[3]:   # 위 / 오
            x = chk[0]+chk[3]
            i, j = 0, 3
        if x > chk[1] + chk[2]:
            x = chk[1] + chk[2]
            i, j = 1, 2
        if x > chk[1]+chk[3]:
            i, j = 1, 3
    
        back(a, b, i, visit)
        back(a, b, j, visit)
    
    
    
    def cctv4(a, b, visit):
        chk = [-1] * 4
    
        chk[0] = top(a, b, visit)
        chk[1] = bottom(a, b, visit)
        chk[2] = left(a, b, visit)
        chk[3] = right(a, b, visit)
    
        idx = -1
        for i in range(4):
            if chk[i] == -1 or idx == -1: idx = i
            if chk[idx] > chk[i]: idx = i
    
        if chk[idx] != -1:
            back(a, b, idx, visit)
    
    def cctv5(a, b, visit):
        top(a, b, visit)
        bottom(a, b, visit)
        left(a, b, visit)
        right(a, b, visit)
    
    
    def solution(n, m, cctv):
        visit = [[0]*m for _ in range(n)]
    
        for num, a, b in cctv:
            visit[a][b] = 1
            if num==-5:
                cctv5(a, b, visit)
            elif num==-4:
                cctv4(a, b, visit)
            elif num==-3:
                cctv3(a, b, visit)
            elif num==-2:
                cctv2(a, b, visit)
            elif num==-1:
                cctv1(a, b, visit)
        ans = 0
        for v in visit:
            ans += v.count(0)
        print(ans-cnt)
    
    N, M = map(int, input().split())
    room = []; CCTV = []; cnt = 0
    for i in range(N):
        t = list(map(int, input().split()))
        for j in range(M):
            if t[j] == 6: cnt += 1
            elif 0<t[j]:
                hp.heappush(CCTV, (-t[j], i, j))
        room.append(t)
    solution(N, M, CCTV)
    
- cctv 5 ~ cctv 1 까지 순차적으로 계산하여 구했다.<br>
- 당연하게도, ~~5를 제외한~~ 어떤 cctv도 우선순위가 없다.(순서를 조합하여 가장 최소 사각지대를 가질 수 있도록 찾아야한다.)<br>

<br>

## 다른 사람의 풀이
- CCTV가 누가 먼저 들어오는 건 사실상 상관이 없다. 각 CCTV가 선택한 방향에 따라 조합이 나뉜다.<br>
- DFS를 돌면서 배열을 복사하는 것은 시간이 오래 걸릴 것이라고 생각해서 배제하였는데, 다른 사람의 풀이를 보니 시간 초과 없이 돌아간다.<br>
- DFS 구현하는 부분을 잘 보고 내 코드에 맞게 다시 고쳐봐야겠다.

<br>

    def dfs(areas, cctvs, idx):
    global mins
    if idx == len(cctvs):
        value = 0
        for k in range(n):
            value += areas[k].count(0)
        mins = min(mins, value)
        return

    cctv = cctvs[idx]
    a, b, kind = cctv
    if kind == 1:
        for i in range(4):
            next_area = check(areas, [i], a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 2:
        for i in [(0, 2), (1, 3)]:  # 왼 오 or 위 아래
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 3:
        for i in [(0, 1), (1, 2), (2, 3), (3, 0)]:
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 4:
        for i in [(0, 1, 2), (1, 2, 3), (2, 3, 0), (3, 0, 1)]:  # (왼, 위, 오), (위, 오, 아래), (오, 아래, 왼), (아래, 왼, 위)
            next_area = check(areas, i, a, b)
            dfs(next_area, cctvs, idx+1)
    if kind == 5:
        next_area = check(areas, (0, 1, 2, 3), a, b)
        dfs(next_area, cctvs, idx+1)
        
        
<br>

### 2차 시도

- cctv의 우선순위가 없다는 것을 또 인지하지 못했다!!!
- DFS 탐색을 진행함에 있어 각 cctv가 어느 방향에 놓이는 게 좋을 지 찾기 위하여 모든 cctv의 방향을 탐색하는 코드!!! (유심히 보고 다음번에는 꼭 내 힘으로 코드를 작성할 수 있도록 하자)

<br>

     if num == 1:
            for i in range(4):
                nxt_room, nxt_cnt = check(room, [i], x, y, cnt)
                solution(nxt_room, nxt_cnt, idx + 1)
        elif num == 2:
            for i in [[0, 1], [2, 3]]:
                nxt_room, nxt_cnt = check(room, i, x, y, cnt)
                solution(nxt_room, nxt_cnt, idx + 1)
        elif num == 3:
            for i in [[0, 2], [1, 2], [1, 3], [0, 3]]:
                nxt_room, nxt_cnt = check(room, i, x, y, cnt)
                solution(nxt_room, nxt_cnt, idx + 1)
        elif num == 4:
            for i in [[0, 1, 2], [0, 2, 3], [0, 1, 3], [1, 2, 3]]:
                nxt_room, nxt_cnt = check(room, i, x, y, cnt)
                solution(nxt_room, nxt_cnt, idx+1)
        else:
            nxt_room, nxt_cnt = check(room, [0, 1, 2, 3], x, y, cnt)
            solution(nxt_room, nxt_cnt, idx+1)
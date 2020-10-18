# [[18808]스티커 붙이기](https://www.acmicpc.net/problem/18808)

## Simulation을 이용한 풀이

### 문제 해결 방식
1. num번째 스티커를 선택
2. [0, n-r+1], [0, m-c+1] 범위의 i, j 시작점을 방문한다.
3. check함수를 통해 스티커를 붙일 수 있는 지 확인
4. 스티커를 붙일 수 있다면 노트북에 붙이고 success=1(붙이는 것에 성공)
	- 노트북에 붙일 때 바로 answer를 카운트해서 세준다.
5. 스티커를 붙였다면 다음 스티커로 넘어간다. ( num += 1)
6. 만약 스티커를 붙이지 못했다면 rotate함수를 통해 스티커를 회전하여 다시 시작점을 방문 (이때, cnt를 통해 회전할 수 있는 횟수를 카운트하여 회전할 수 있는지를 체크)

<br>

### 내가 풀었던 방식도 위의 방식과 거의 동일했다. <br>
### 차이점은  DFS를 이용했고, 스티커를 붙일 수 있는 지 체크하는 과정에서 바로 스티커를 붙인 배열을 새로 return 해주었고 그 return한 배열을 다음 DFS에 사용하는 방식으로 구현했다.<br>
### 이때 새로운 배열을 생성하기 위해서 n*m의 시간을 더 소모하게 되는 부분에서 시간초과가 발생하는 것을 확인했다. <br>


<br>

### 내가 푼 풀이 (~~시간초과~~)

<image src="https://lh3.googleusercontent.com/f8501HQYt-e8ADDidIAJke1ThtUkFxWhhyvFnEEbVhMRnba8pw3-6HMKyQVqOfWcUHyLiCrE4u8M79SL12aDDyQobZvYvjulM-LCF4fIE_l1Yy4wvp_PVlknIprGcM7F_zCz3gFd">

<br>

<details>    
<summary> 코드 보기 </summary>    
<br>
	
	import sys
	from copy import deepcopy

	input=sys.stdin.readline

	def check(x, y, v, st, n1, m1):
	    v = deepcopy(v)
	    for i in range(n1):
	        for j in range(m1):
	            if st[i][j] == 1:
	                if v[x+i][y+j]==1:
	                    return False, None
	                elif v[x+i][y+j]==0:
	                    v[x+i][y+j] = 1
	    return True, v

	def rotate(x, t, n1, m1):   # 회전 배열 함수
	    res = []
	    if x == 1:      # 90도 회전
	        for j in range(m1):
	            tmp = []
	            for i in range(n1-1, -1, -1):
	                tmp.append(t[i][j])
	            res.append(tmp)
	    elif x == 2:    # 180도 회전
	        for i in range(n1-1, -1, -1):
	            tmp = []
	            for j in range(m1-1, -1, -1):
	                tmp.append(t[i][j])
	            res.append(tmp)
	    elif x == 3:    # 270도 회전
	        for j in range(m1-1, -1, -1):
	            tmp = []
	            for i in range(n1):
	                tmp.append(t[i][j])
	            res.append(tmp)
	    return res

	def DFS(x, note, cnt):
	    if x==K:
	        print(cnt)
	        sys.exit()
	    ch = False
	    for k in range(4):
	        if k == 1 or k == 3:
	            n, m = st_nm[x][1], st_nm[x][0]
	        else:
	            n, m = st_nm[x][0], st_nm[x][1]


	        for i in range(N-n+1):
	            for j in range(M-m+1):
	                ch, _v = check(i, j, note, sticker[x][k], n, m)
	                if ch:
	                    DFS(x+1, _v, cnt+num[x])
	                    return
	    DFS(x+1, note, cnt)

	N, M, K = map(int, input().split())
	sticker = []; st_nm = []; num = []  # 스티커 배열(0도/90도/180도/270), 스티커 n1, m1, 스티커 "1"의 개수
	for i in range(K):
	    x, y = map(int, input().split())
	    st_nm.append((x, y))
	    count,  tmp = 0, []     # 스티커 개수 카운트
	    for _ in range(x):
	        z = list(map(int, input().split()))
	        count += z.count(1)
	        tmp.append(z)
	    sticker.append([tmp])
	    for j in range(1, 4):
	        sticker[i].append(rotate(j, tmp, x, y))
	    num.append(count)

	notebook = [[0]*M for _ in range(N)]
	DFS(0, notebook, 0)


<br>
</details>

<br>

### 다른 사람의 풀이

	import sys
	input=sys.stdin.readline

	def rotate(b):  # 90도 회전 함수
	    n, m = len(b), len(b[0])
	    res = [[ b[n-i-1][j] for i in range(n) ] for j in range(m)]
	    return res

	def check(x, y, sticker_array):
	    n1, m1 = len(sticker_array), len(sticker_array[0])
	    for x1 in range(n1):
	        for y1 in range(m1):
	            if sticker_array[x1][y1] == 0:
	                continue
	            elif laptop[x+x1][y+y1] == 1:
	                return False
	    return True

	if __name__ == '__main__':
	    ans = 0
	    n, m, k = map(int, input().split())
	    laptop = [[0]*m for _ in range(n)]
	    sticker = [{} for _ in range(k)]

	    for i in range(k):
	        sticker[i]['r'], sticker[i]['c'] = map(int, input().split())
	        sticker[i]['sticker'] = [list(map(int, input().split())) for _ in range(sticker[i]['r'])]

	    for num in range(k):
	        cnt = 0
	        r, c = sticker[num]['r'], sticker[num]['c']
	        st = sticker[num]['sticker']
	        while cnt < 4:      # 회전하기
	            success = 0
	            for i in range(n-r+1):
	                for j in range(m-c+1):
	                    if not check(i, j, st): continue    # 시작점을 i, j로 board를 laptop에 붙일 수 있는지 체크
	                    for a in range(r):                  # 스티커 붙일 수 있는 경우 laptop 배열에 붙이기
	                        for b in range(c):
	                            if st[a][b]==1:
	                                laptop[i+a][j+b] = 1
	                                ans += 1
	                    success = 1             # 스티커 붙였음 (success=1)
	                    break

	                if success: break                       # 스티커 붙였으면 이중 for문 빠져나가기
	            if success: break
	            else:                                       # 스티커를 못 붙였다면 회전시키기
	                r, c, st = c, r, rotate(st)
	                cnt += 1

	    print(ans)


<br>

### 내 코드를 수정하여 2차 시도


	import sys
	from copy import deepcopy

	input=sys.stdin.readline

	def check(x, y, v, st, n1, m1):
	    for i in range(n1):
	        for j in range(m1):
	            if st[i][j] == 0: continue
	            elif v[x+i][y+j]==1: return False
	    return True


	def rotate(b):  # 90도 회전 함수
	    n, m = len(b), len(b[0])
	    res = [[ b[n-i-1][j] for i in range(n) ] for j in range(m)]
	    return res

	def DFS(x, note, cnt):
	    if x==K:
	        print(cnt)
	        sys.exit()
	    ch = False
	    stick = sticker[x]
	    n, m = len(stick), len(stick[0])
	    for k in range(4):
	        for i in range(N-n+1):
	            for j in range(M-m+1):
	                ch = check(i, j, note, stick, n, m)
	                if ch:
	                    for a in range(n):
	                        for b in range(m):
	                            if stick[a][b] == 1:
	                                note[i+a][j+b] = 1
	                    DFS(x+1, note, cnt+num[x])
	                    return
	        stick = rotate(stick)
	        n, m = m, n
	    DFS(x+1, note, cnt)


	N, M, K = map(int, input().split())
	sticker = []; st_nm = []; num = []  # 스티커 배열(0도/90도/180도/270), 스티커 n1, m1, 스티커 "1"의 개수
	for i in range(K):
	    x, y = map(int, input().split())
	    st_nm.append((x, y))
	    count,  tmp = 0, []     # 스티커 개수 카운트
	    for _ in range(x):
	        z = list(map(int, input().split()))
	        count += z.count(1)
	        tmp.append(z)
	    sticker.append(tmp)
	    num.append(count)


	notebook = [[0]*M for _ in range(N)]
	DFS(0, notebook, 0)

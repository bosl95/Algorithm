from collections import deque

def bfs(n, k):
    if n==k:
        return (0, [n])
    visit = [0] * 100001
    visit[n] =1
    path = [0] * 100001
    stack = deque()
    stack.append([n, 0])    # 현재 위치, 시간
    while stack:
        pos, time = stack.popleft()
        if pos==k:
            tmp = [pos]
            while True:
                pos = path[pos]
                tmp.append(pos)
                if pos == n:
                    break
            return (time, tmp)
        if 0<=pos*2<100001 and visit[2*pos]==0:
            visit[2*pos] = 1
            path[2 * pos] = pos
            stack.append([2*pos, time+1])
        if 0<=pos-1<100001 and visit[pos-1]==0:
            visit[pos-1]=1
            path[pos-1] = pos
            stack.append([pos-1, time+1])
        if 0<=pos+1<100001 and visit[pos+1]==0:
            visit[pos+1]=1
            path[pos+1] = pos
            stack.append([pos+1, time+1])

n, k = map(int, input().split())
a, b = bfs(n, k)
print(a)
while b:
    print(b.pop(), end=' ')
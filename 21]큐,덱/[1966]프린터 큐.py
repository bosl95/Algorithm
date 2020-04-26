import sys; input = sys.stdin.readline
from collections import deque

def search(dq, id, m):
    cnt=0; last_index = -1
    while last_index != m:
        flag =True
        for i in range(i, len(dq)):
            if dq[i] > dq[0]:
                dq.rotate(-1);
                flag = False
                break
        if flag:
            dq.popleft();
            last_index = id.popleft();
            cnt += 1
    return cnt

t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    ID = deque([i for i in range(n)])
    DQ = deque(list(map(int, input().split())))
    print(search(DQ, ID, m))

# 데크보다 큐가 훨씬 빠름.
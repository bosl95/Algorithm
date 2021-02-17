from collections import deque

def solution(n, m, arr):
    queue = deque([i for i in range(1, n+1)])
    ans = 0

    for i in range(m):
        idx = queue.index(arr[i])
        if idx:
            leng = len(queue)
            if idx < leng-idx:
                queue.rotate(-idx)
                ans += idx
            else:
                queue.rotate(leng-idx)
                ans += (leng-idx)
        queue.popleft()
    return ans

N, M = map(int, input().split())
Arr = list(map(int, input().split()))
print(solution(N, M, Arr))
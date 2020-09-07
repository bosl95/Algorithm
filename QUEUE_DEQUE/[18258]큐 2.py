from collections import deque
import sys;

input = sys.stdin.readline
n = int(input())
arr = [input().strip() for _ in range(n)]
queue = deque()
for inp in arr:
    if 'push' in inp:
        queue.append(inp.split()[1])
    elif inp == 'pop':
        print(queue.popleft() if queue else -1)
    elif inp == 'size':
        print(len(queue))
    elif inp == 'empty':
        print(0 if queue else 1)
    elif inp == 'front':
        print(queue[0] if queue else -1)
    elif inp == 'back':
        print(queue[-1] if queue else -1)

'''
pop을 했을 때, 왼쪽에서부터 제거되기때문에 한칸씩 옮겨야하는 작업이 발생
--> 시간 초과
===> deque를 import해서 사용 

input()을 통한 입력 --> 시간 초과
===> sys.stdin.readline을 사용
'''
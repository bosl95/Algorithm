import sys; input=sys.stdin.readline
from collections import deque
stack = deque([])
arr = [ input().strip() for _ in range(int(input()))]
for str in arr:
    if str.startswith('push_front'):
        stack.appendleft(str.split()[1])
    elif str.startswith('push_back'):
        stack.append(str.split()[1])
    elif str == 'pop_front':
        print(stack.popleft() if stack else -1)
    elif str == 'pop_back':
        print(stack.pop() if stack else -1)
    elif str == 'empty':
        print(0 if stack else 1)
    elif str == 'front':
        print(stack[0] if stack else -1)
    else:
        print(stack[-1] if stack else -1)
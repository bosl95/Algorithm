from collections import deque
n, k = map(int, input().split())
queue = deque([i for i in range(1, n+1)])
stack = []

while queue:
    queue.rotate(-k+1)
    stack.append(queue.popleft())

print("<", end='')
print(*stack, sep=', ', end='')
print(">", end='')
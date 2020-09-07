import sys; input=sys.stdin.readline
n = int(input())
queue = []
for _ in range(n):
    x = input()
    if 'push' in x:
        queue.append(int(x.split()[1]))
    elif 'pop' in x:
        print(queue.pop(0) if queue else -1)
    elif 'size' in x:
        print(len(queue))
    elif 'empty' in x:
        print(0 if queue else 1)
    elif 'front' in x:
        print(queue[0] if queue else -1)
    elif 'back' in x:
        print(queue[-1] if queue else -1)

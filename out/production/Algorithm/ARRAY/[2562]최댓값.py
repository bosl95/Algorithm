import sys
a = []
for i in range(9):
    a.append(int(sys.stdin.readline().strip()))
print(max(a))
print(a.index(max(a))+1)
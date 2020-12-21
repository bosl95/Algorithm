line = input()
arr = [0] * 26
for w in line:
    n = ord(w)
    arr[n-97] += 1
print(*arr)
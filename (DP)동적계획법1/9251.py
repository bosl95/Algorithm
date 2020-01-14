A = list(input())
B = list(input())
na = len(A)
nb = len(B)
count = [ [0] * (na+1) for _ in range(nb+1) ]

for b in range(nb):
    for a in range(na):
        if A[a] == B[b]:
            count[b+1][a+1] = count[b][a] + 1
        else:
            count[b+1][a+1] = max(count[b][a+1], count[b+1][a])
print(count[-1][-1])

#    0  A   C   A   Y   K   P
# 0  0  0   0   0   0   0   0
# C  0  0   1   1   1   1   1
# A  0  1   1   2   2   2   2
# P  0  1   1   2   2   2   3
# C  0  1   2   2   2   2   3
# A  0  1   2   3   3   3   3
# K  0  1   2   3   3   4   4
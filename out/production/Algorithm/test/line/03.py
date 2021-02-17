a, b = -1, -1

def DFS(N, i, cnt):
    x, y = N[:i+1], N[i+1:]
    if y[0] == '0':
        return
    x, y = map(int, (x, y))
    plus = x+y
    cnt += 1
    if plus < 10:
        global a, b
        if (a, b) == (-1, -1) or a > cnt:
            (a, b) = cnt, plus
    else:
        plus = str(plus)
        for i in range(len(plus)-1):
            DFS(plus, i, cnt)


def solution(n):
    global a, b
    a, b = -1, -1

    if n < 10:
        return [0, n]
    n = str(n)
    for i in range(len(n)-1):
        DFS(n, i, 0)

    return [a, b]

print(solution(73425))
print(solution(10007))
print(solution(9))
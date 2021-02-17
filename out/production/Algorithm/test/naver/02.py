def check(s, py):
    x, y = s
    if y-1 >= 0 and py[x][y-1]==0:
        py[x][y-1] = py[x-1][y-1] - py[x][y]
        check((x, y-1), py)
    if y+1 <= x and py[x][y+1] == 0:
        py[x][y+1] = py[x-1][y] - py[x][y]
        check((x, y+1), py)

def solution(blocks):
    n = len(blocks)
    ans = []
    pyramid = [[0]*i for i in range(1, n+1)]

    for i,(j,v) in enumerate(blocks):
        pyramid[i][j] = v
        check((i, j), pyramid)

    for p in pyramid:
        ans += p

    return ans

print(solution([[0, 50], [0, 22], [2, 10], [1, 4], [4, -13]]))
print(solution([[0, 92], [1, 20], [2, 11], [1, -81], [3, 98]]	))
from collections import deque


def solution(r, c, arr):
    check = [[[[0]*4 for _ in range(16)] for _ in range(c)] for _ in range(r)]
    # v = [좌, 우, 상, 하]
    stack = deque([[0, 0, 0, 1]])
    while stack:
        # print(arr[i][j], i, j, m, v, check[i][j][m][v])
        i, j, m, v = stack.popleft()
        if check[i][j][m][v] == 1:
            if stack:
                continue
            else:
                return "NO"

        check[i][j][m][v] = 1

        if arr[i][j] == "@":
            return "YES"
        elif arr[i][j] in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"]:
            m = int(arr[i][j])
        elif arr[i][j] == '>':
            v = 1
        elif arr[i][j] == "<":
            v = 0
        elif arr[i][j] == "^":
            v = 2
        elif arr[i][j] == "v":
            v = 3
        elif arr[i][j] == "_":
            v = 1 if m ==0 else 0
        elif arr[i][j] == "|":
            v = 3 if m==0 else 2
        elif arr[i][j] == "+":
            m = 0 if m==15 else m+1
        elif arr[i][j] == "-":
            m = 15 if m==0 else m-1
        elif arr[i][j] == "?":
            stack.append([i, c-1 if j==0 else j-1, m, 0])
            stack.append([i, 0 if j==c-1 else j+1, m, 1])
            stack.append([r-1 if i==0 else i-1, j, m, 2])
            stack.append([0 if i==r-1 else i+1, j, m, 3])
            continue


        if v == 0: # 좌
            j = c-1 if j==0 else j-1
        elif v == 1: # 우
            j = 0 if j==c-1 else j+1
        elif v == 2: # 상
            i = r-1 if i==0 else i-1
        else: # 하
            i = 0 if i==r-1 else i+1

        stack.append([i, j, m, v])

T = int(input())

for test_case in range(1, T + 1):
    R, C = map(int, input().split())
    arr = [list(input()) for _ in range(R)]
    print("#{} {}".format(test_case, solution(R, C, arr)))
# import sys; input = sys.stdin.readline
# n, r, c = map(int, input().split())
#
# def visit(start , search, cnt, n):
#     x, y = map(int, start)
#     r, c = map(int, search)
#     m = n//2
#
#     if m==1:
#         for a, b in [0, 0], [0, 1], [1, 0], [1, 1]:
#             if [r, c] == [x+a, y+b]:
#                 print(cnt)
#                 return
#             cnt += 1
#
#     if r < x+m and c < y+m:
#         visit([x,y], search, cnt+(2**m)*0, m)
#     elif r < x + m and y + m <= c:
#         visit([x, y+m], search, cnt+(2**m)*1, m)
#     elif x + m <= r and c < y + m:
#         visit([x+m, y], search, cnt+(2**m)*2, m)
#     else:
#         visit([x+m, y+m], search, cnt+(2**m)*3, m)
#
# visit([0, 0], [r, c], 0, 2**n)

# 출력 초과 -> 파일크기가 커져서 그렇다고 함 틀린것과 동일함

def f(n, r, c):
    num = 0
    while True:
        if n == 1 or n // 2 == 1:
            if (r, c) == (0, 0):
                return num
            elif (r, c) == (0, 1):
                return num + 1
            elif (r, c) == (1, 0):
                return num + 2
            else:
                return num + 3
        n //= 2
        if r < n and n <= c:  # 2사
            c -= n
            num += (n ** 2) * 1
        elif n <= r and c < n:  # 3사
            r -= n
            num += (n ** 2) * 2
        elif n <= r and n <= c:  # 4사
            c -= n;
            r -= n
            num += (n ** 2) * 3

n, r, c = map(int, input().split())
print(f(2 ** n, r, c))

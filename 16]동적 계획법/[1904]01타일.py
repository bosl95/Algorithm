# n = int(input())
# a = [-1] * n
# def fibo(m):
#     if m == 0: return 1
#     if m == 1: return 2
#     if a[m] != -1 : return a[m]
#     a[m] = (fibo(m-2)+fibo(m-1))%15746
#     return a[m]
#
# print(fibo(n-1))
# 거창 해보였지만 그냥 fibo 문제였다
# --- 런타임 에러 -----
# 재귀 함수 호출이 너무 많으면 stack overflow가 일어나서 프로그램이 종료됨
N = int(input())
a = [-1] * N
if N ==1: print(1)
elif N==2: print(2)
else:
    a, b = 1, 2
    for _ in range(N-2):
        a, b = b, (a+b)%15746
print(b)

# 2회차
# def fibo(n):
#     a, b, c = 1, 1, 1
#     if n <= 3:
#         return 1
#     else:
#         for i in range(n-3):
#             a, b, c = b, c, a+b
#         return c
# for _ in range(int(input())):
#     n = int(input())
#     print(fibo(n))
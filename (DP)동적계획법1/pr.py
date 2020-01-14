def fibo(n):
    a, b, c = 1, 1, 1
    if n <= 3:
        return 1
    else:
        for i in range(n-3):
            a, b, c = b, c, a+b
        return c
for _ in range(int(input())):
    n = int(input())
    print(fibo(n))
import sys
a, b, c = map(int, sys.stdin.readline().split())
def f(n):
    if n==1:
        return (a % c)
    if n%2==0:
        half = f(n//2) % c
        return (half * half) % c
    else:
        return ((a%c) * (f(n-1)%c)) % c
print(f(b))


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

# 오우 그냥 분할 해봤는데 됐당
# 제곱을 구해주는 pow함수를 써도 풀리긴 함
# (시간은 이 코드와 거의 같다.)
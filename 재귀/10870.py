n = int(input())
a = [-1]*(n+1)
def fibo(n):
    if n==1 or n==0: return n
    if a[n]==-1:
        a[n] = fibo(n-1) + fibo(n-2)
    return a[n]
print(fibo(n))
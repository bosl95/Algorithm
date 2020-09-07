# 하노이 탑의 규칙
# n 개의 원판이 있을 때 n-1개의 원판을 1번-> 2번으로 옮긴 후
# 그리고 n-1개의 원판들을 다시 2번->3번으로 옮긴다.

def hanoi(n, a, b, c):
    if n==1:
        print(a, c)
    else:
        hanoi(n-1, a, c, b) # n-1개 원판을 1번 -> 2번
        print(a, c)
        hanoi(n-1, b, a, c) # n-1개 원판을 2번 -> 3번

n = int(input())
print(2**n-1)
# sum = 1
# for i in range(N-1):
# 	sum = sum*2 + 1
# 이거 훨씬 빠름.
hanoi(n, 1, 2, 3)
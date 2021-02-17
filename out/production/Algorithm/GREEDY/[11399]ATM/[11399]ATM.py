import sys; input=sys.stdin.readline

def solution(n, time):
    time.sort()
    result = 0
    for i in range(1, n+1):
        result += time.pop()*i
    return result

n = int(input())
time = list(map(int, input().split()))
print(solution(n, time))
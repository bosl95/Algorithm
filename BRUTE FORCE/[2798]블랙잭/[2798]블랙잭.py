import sys
input = sys.stdin.readline

def solution(N, M, card):
    card.sort()
    result = -1
    for i in range(N):
        for j in range(i+1, N):
            for k in range(j+1, N):
                tmp = card[i] + card[j] + card[k]
                if M >= tmp > result:
                    result = tmp
    return result

n, m = map(int, input().split())
c = list(map(int, input().split()))
print(solution(n, m, c))
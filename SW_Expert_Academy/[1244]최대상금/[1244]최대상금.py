def swap(x, y):
    tmp = card[x]
    card[x] = card[y]
    card[y] = tmp

def solution(cur, c, n):
    global result
    if c == cnt:
        result = max(result, int(''.join(card)))
        return

    for i in range(cur, n):
        for j in range(i+1, n):
            if card[i] <= card[j] :
                swap(i, j)
                solution(i, c+1, n)
                swap(i, j)

T = int(input())
for test_case in range(1, T + 1):
    card, cnt = input().split()
    card, cnt = list(card), int(cnt)
    result = 0
    n = len(card)
    solution(0, 0, n)
    if result == 0:
        if cnt%2 == 1:
            swap(n-1,n-2)
        result = int(''.join(card))
    print("#{} {}".format(test_case, result))
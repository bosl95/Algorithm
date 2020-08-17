def solution(n, score):
    DP = {0}

    for i in range(n):
        tmp = set()
        for d in DP:
            tmp.add(d+score[i])
        DP.update(tmp)
    return len(DP)

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    scores = list(map(int, input().split()))
    print("#{} {}".format(test_case, solution(n, scores)))
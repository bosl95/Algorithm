def solution(N):
    turn = True
    players = ['Alice', 'Bob']

    if N==1:
        return players[int(turn)]
    N -= 1
    i = 1
    turn = not turn

    while True:
        for _ in range(2):
            N -= (4**i)
            if N <= 0:
                return players[int(turn)]
            turn = not turn
        i += 1


T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    print("#{} {}".format(test_case, solution(N)))
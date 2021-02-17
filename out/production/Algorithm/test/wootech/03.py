def solution(money, expected, actual):
    answer = -1
    bat = 100
    n = len(expected)

    for i in range(n):
        if bat > money: bat = money     # 배팅 금액보다 돈이 모자라면 모든 돈 배팅
        if expected[i] == actual[i]:    # 배팅 성공
            money += bat
            bat = 100
        else:
            money -= bat
            bat *= 2
            if money < 0: break
    return money if money else 0

# print(solution(1000,['H', 'T', 'H', 'T', 'H', 'T', 'H']	, ['T', 'T', 'H', 'H', 'T', 'T', 'H']	))
print(solution(500, ['H', 'H', 'H', 'T'], ['T', 'T', 'T', 'H']))

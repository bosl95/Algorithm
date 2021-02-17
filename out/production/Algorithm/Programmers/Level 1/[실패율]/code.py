def solution(N, stages):
    result = {}
    num = len(stages)

    for stage in range(1, N+1):
        if num != 0:
            count = stages.count(stage)
            result[stage] = count/num
            num -= count        # 그 스테이지에 머물러있는 사람을 뺀다.
        else:
            result[stage] = 0

    # sorted(result.items(), key=lambda x:result[x[0]], reverse=True)
    return sorted(result, key=lambda x:result[x], reverse=True)

print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))

# d = {'a': 1, 'b': 2}
# values = list(map(lambda key: d[key], d.keys()))
# print(values)
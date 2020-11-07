def solution(x, n):
    answer = []
    x_ = x
    for i in range(n):
        answer.append(x)
        x += x_
    return answer

print(solution(4, 3))
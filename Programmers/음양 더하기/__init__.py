def solution(absolutes, signs):
    answer = 0

    for i in range(0, len(absolutes)):
        if signs[i]:
            value = absolutes[i]
        else:
            value = -absolutes[i]

        answer += value

    return answer
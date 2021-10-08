def solution(numbers):
    answer = 45
    number = [False] * 10

    for num in numbers:
        if number[num]:
            continue

        number[num] = True
        answer -= num

    return answer
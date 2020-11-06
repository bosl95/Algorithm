def solution(arr):
    answer = []
    x = min(arr)
    for a in arr:
        if a != x:
            answer.append(a)
    return answer if answer else [-1]
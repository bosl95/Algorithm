def solution(n):
    i = 666
    while n>0:
        if '666' in str(i):
            n -= 1
            result = i
        i += 1
    return result

print(solution(int(input())))
def solution(line):
    tmp = line.split('-')
    for i in range(len(tmp)):
        tmp2 = list(map(int, tmp[i].split('+')))
        tmp[i] = sum(tmp2) if i==0 else -sum(tmp2)
    return sum(tmp)

line = input()
print(solution(line))

def solution(penter, pexit, pescape, data):
    answer = penter         # 맨 처음 penter 삽입
    m, n = len(penter), len(data)

    for i in range(0, n, m):
        if data[i:i+m] in [penter, pexit, pescape]:     # 만약 3개 중 하나와 중복되면
            answer += pescape
        answer += data[i:i+m]
    answer += pexit     # 마지막에 pexit 삽입
    return answer

# print(solution("1100", "0010", "1001", "1101100100101111001111000000"))
print(solution("10","11","00","00011011"))
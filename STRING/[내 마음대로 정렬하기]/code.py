from collections import defaultdict

def solution(strings, n):
    answer = []
    # n번째 글자를 기준으로 오름차순
    m = len(strings)
    dic = defaultdict(list)
    for i in range(m):
        dic[ord(strings[i][n])].append(i)

    for k in sorted(dic.keys()):
        if len(dic[k]) > 1:
            tmp = [strings[d] for d in dic[k]]
            tmp.sort()
            answer.extend(tmp)
        else:
            answer.append(strings[dic[k][0]])
    return answer

print(solution(["sun", "bed", "car"], 1))
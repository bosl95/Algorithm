def solution(s):
    answer = ''
    for word in s.split(' '):
        for i, v in enumerate(word):
            answer += (v.upper() if i%2==0 else v)
        answer += ' '
    return answer[:-1]

def toWeirdCase(s):
    return ' '.join([''.join([c.upper() if i % 2 == 0 else c.lower() for i, c in enumerate(w)]) for w in s.split()])
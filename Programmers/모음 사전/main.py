alpha = ['A', 'E', 'I', 'O', 'U']
answer = 0
isEnd = False

def init():
    global answer, isEnd
    answer = 0
    isEnd = False

def solution(word):
    global answer, isEnd
    func('', word)
    return answer


def func(temp, word):
    global answer, isEnd

    if temp == word:
        isEnd = True

    n = len(temp)
    if n == 5:
        return

    for i in range(5):
        if not isEnd:
            answer += 1
            func(temp + alpha[i], word)


if __name__ == '__main__':
    print(solution("AAAAE") == 6)
    init()
    print(solution("AAAE") == 10)
    init()
    print(solution("I") == 1563)
    init()
    print(solution("EIO") == 1189)

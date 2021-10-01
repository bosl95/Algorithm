def solution(new_id):
    answer = ''

    # level 1
    new_id = new_id.lower()

    # level 2
    for i in range(len(new_id)):
        ch = new_id[i]
        if ch.isalpha() or ch.isdigit() or ch in ["-", "_", "."]:
            answer += ch

    # level 3
    while ".." in answer:
        answer = answer.replace("..", ".")

    # level 4
    answer = filterLastDot(answer)

    while answer != "" and answer[0] == ".":
        answer = answer[1:]

    # level 5
    if answer == "":
        answer = "a"

    # level 6
    if len(answer) >= 16:
        answer = answer[:15]
    answer = filterLastDot(answer)

    # level 7
    while len(answer) <= 2:
        answer = answer + answer[-1]

    return answer


def filterLastDot(answer):
    while answer != "" and answer[-1] == ".":
        answer = answer[:-1]
    return answer


# print(solution("...!@BaT#*..y.abcdefghijklm"))
# print(solution("z-+.^."))
# print(solution("=.="))
# print(solution("123_.def"))
print(solution("abcdefghijklmn.p"))
# print(solution("~!@#$%&*()=+[{]}:?,<>/"))
# print(solution(".1."))
# print(solution("......a......a......a....."))

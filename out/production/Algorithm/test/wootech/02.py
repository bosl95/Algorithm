def solution(s, op):
    answer = []
    if op == '-':
        for i in range(len(s)-1):
            answer.append(int(s[:i+1])-int(s[i+1:]))
    elif op == '+':
        for i in range(len(s)-1):
            answer.append(int(s[:i+1])+int(s[i+1:]))
    elif op == '*':
        for i in range(len(s)-1):
            answer.append(int(s[:i+1])*int(s[i+1:]))

    return answer

print(solution("987987"	, "-"))
print(solution("1234", "+"))
print(solution("31402","*"))
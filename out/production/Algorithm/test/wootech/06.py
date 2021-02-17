from collections import defaultdict

def diff(stu, stu2):
    for s in stu.keys():
        if stu2.get(s):
            if stu2[s] == stu[s]:
                continue
            return False
        else:
            return False
    return True

def solution(logs):
    answer = set()
    student = defaultdict(dict)

    for log in logs:
        std, num, score = log.split()
        student[std][num] = score


    name, n = [], 0
    for s in student.items():
        if len(s[1]) < 5: continue
        name.append(s[0])
        n += 1

    for i in range(n-1):
        for j in range(i+1, n):
            stu1, stu2 = len(student[name[i]]), len(student[name[j]])
            if stu1 == stu2 :
                if diff(student[name[i]], student[name[j]]):
                    answer.add(name[i])
                    answer.add(name[j])

    return sorted(list(answer)) if answer else ["None"]

print(solution(["0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"]))
print(solution(["1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "2001 1 100", "2001 2 100", "2001 4 100", "2001 7 95", "2001 9 100", "2002 1 95", "2002 2 100", "2002 4 100", "2002 7 100", "2002 9 100"]	))
# print(solution(["1901 10 50", "1909 10 50"]))
# print(solution(["1901 10 50"]))
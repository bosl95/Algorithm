def solution(table, languages, preference):
    answer = ''
    pref = {languages[i]: preference[i] for i in range(0, len(languages))}

    maxScore = 0
    for i in range(5):
        score = 0
        cols = table[i].split(" ")
        for j in range(1, len(cols)):
            if cols[j] in pref:
                score += (pref.get(cols[j]) * (6 - j))

        if i == 0:
            maxScore = score
            answer = cols[0]
            continue

        if maxScore < score or (maxScore == score and answer > cols[0]):
            answer = cols[0]
            maxScore = score

    return answer


if __name__ == '__main__':
    # print(solution(["SI JAVA JAVASCRIPT SQL PYTHON C#",
    #           "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
    #           "HARDWARE C C++ PYTHON JAVA JAVASCRIPT",
    #           "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
    #           "GAME C++ C# JAVASCRIPT C JAVA"],
    #          ["PYTHON", "C++", "SQL"],
    #          [7, 5, 5]))

    result = solution(["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                  "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                  "GAME C++ C# JAVASCRIPT C JAVA"], ["JAVA", "JAVASCRIPT"], [7, 5])
    print(result)
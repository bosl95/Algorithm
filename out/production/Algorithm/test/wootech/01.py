def solution(grades, weights, threshold):
    answer = 0
    gweight = {'A+':10, 'A0':9, 'B+':8, 'B0':7, 'C+':6, 'C0':5, 'D+':4, 'D0':3, 'F':0}

    for i in range(len(grades)):
        answer += (weights[i]*gweight[grades[i]])
    return answer-threshold
print(solution(["A+","D+","F","C0"]	,[2,5,10,3]	,50 ))
print(solution(["B+","A0","C+"]	,[6,7,8]	,200))
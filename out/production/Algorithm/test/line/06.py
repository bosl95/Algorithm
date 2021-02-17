from collections import defaultdict


def solution(companies, applicants):
    answer = []
    com_num = len(companies)
    c_want = dict()
    select_num = dict()
    for i in range(com_num):
        com, wants, num = companies[i].split(' ')
        c_want[com] = list(wants)
        select_num[com] = int(num)

    # print(c_want)   # {'A': ['f', 'a', 'b', 'd', 'e', 'c'], 'B': ['c', 'e', 'b', 'd', 'f', 'a'], 'C': ['e', 'c', 'f', 'a', 'd', 'b']}
    # print(select_num)   # [2, 2, 2]

    app = len(applicants)
    app_name = []
    want = []   # 지원자 : 우선 회사 순위
    enable = [0] * app
    try_app = [0] * app     # 지원자의 우선순위 인덱스 (거절 시 순위가 올라감)
    for i in range(app):
        people, wants, cnt = applicants[i].split(' ')
        app_name.append(people)
        want.append(list(wants))
        enable[i] = int(cnt)

    while True:
        reject = []
        round = defaultdict(list)
        for i in range(app):
            if try_app[i] < enable[i]: # 입사 희망 기업 수가 아직 있다면
                round[want[i][try_app[i]]].append(app_name[i])   # 해당 회사 기업을 찾아
                # 입사 지원

        # 기업마다 우선 순위를 확인하여 채용 인원만큼 선택
        for i, v in round.items():
            select = 0
            for c in c_want[i]:
                if select == select_num[i]:
                    break
                if c in round[i]:
                    round[i].remove(c)  # 채용 인원이 있으면 선택
                    select += 1

        if round.items():
            print(len(round))
        for i, v in round.items():
            for vv in v:
                try_app[app_name.index(vv)] += 1

        input()



    return answer

print(solution(["A fabdec 2", "B cebdfa 2", "C ecfadb 2"], ["a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"]))
# print(solution(["A abc 2", "B abc 1"], ["a AB 1", "b AB 1", "c AB 1"]))
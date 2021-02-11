# import sys
# from collections import deque
#
# input=sys.stdin.readline
#
# def rotate(g, idx, chk):
#     st = ''.join(str(gg) for gg in g[idx])
#     st =  st[7]+st[:7] if chk == 1 else st[1:8]+st[0]
#     g[idx] = list(map(int, list(st)))
#
# def solution(gear, turn):
#
#     for num, chk in turn:
#         if num==1:
#             if gear[0][2]^gear[1][6] == 1:    # 2번 톱니 체크 (서로 다르면)
#                 if gear[1][2]^gear[2][6] == 1:     # 3번 톱니 체크
#                         if gear[2][2]^gear[3][6]==1:
#                             rotate(gear, 3, -chk)
#                         rotate(gear, 2, chk)
#                 rotate(gear, 1, -chk)
#             rotate(gear, 0, chk)
#         if num==2:
#             if gear[1][6]^gear[0][2]==1:        # 1번 톱니 체크
#                 rotate(gear, 0, -chk)
#             if gear[1][2]^gear[2][6]==1:        # 3번 톱니 체크
#                 if gear[2][2]^gear[3][6]==1:    # 4번 톱니 체크
#                     rotate(gear, 3, chk)
#                 rotate(gear, 2, -chk)
#             rotate(gear, 1, chk)
#         if num==3:
#             if gear[2][6]^gear[1][2]==1:        # 2번 톱니 체크
#                 if gear[1][6]^gear[0][2]==1:    # 1번 톱니 체크
#                     rotate(gear, 0, chk)
#                 rotate(gear, 1, -chk)
#             if gear[2][2]^gear[3][6]==1:        # 4번 톱니 체크
#                 rotate(gear, 3, -chk)
#             rotate(gear, 2, chk)
#         if num==4:
#             if gear[3][6]^gear[2][2]==1:        # 3번 톱니 체크
#                 if gear[2][6]^gear[1][2]==1:    # 2번 톱니 체크
#                     if gear[1][6]^gear[0][2]==1:# 1번 톱니 체크
#                         rotate(gear, 0, -chk)
#                     rotate(gear, 1, chk)
#                 rotate(gear, 2, -chk)
#             rotate(gear, 3, chk)
#
#     return (gear[0][0]==1)+(gear[1][0]==1)*2+(gear[2][0]==1)*4+(gear[3][0]==1)*8
#
#
# Gear = [list(map(int, list(input().strip()))) for _ in range(4)]
# k = int(input().strip())
# Turn = [list(map(int, input().split())) for _ in range(k)]
# print(solution(Gear, Turn))

# -------------------------------------------------------------------

from collections import deque

def solution(gear, turn):

    while turn:
        num, dir = turn.popleft()
        num -= 1    # num은 인덱스로 -1해주기

        # 백업
        tmp_right = gear[num][2]
        tmp_left= gear[num][6]
        tmp_dir = dir
        gear[num].rotate(dir)

        # 톱니 왼쪽
        for i in range(num-1, -1, -1):
            if gear[i][2] != tmp_left:
                tmp_left = gear[i][6]
                gear[i].rotate(dir*-1)
                dir *= -1
            else:
                break

        # 톱니 오른쪽
        dir = tmp_dir
        for i in range(num+1, 4):
            if gear[i][6]!=tmp_right:
                tmp_right = gear[i][2]
                gear[i].rotate(dir*-1)
                dir *= -1
            else:
                break

    ans = 0
    for i in range(4):
        if gear[i][0]==1:
            ans += (2**i)
    return ans


Gear = [deque(map(int, input())) for _ in range(4)]
Turn = deque(list(map(int, input().split())) for _ in range(int(input())))
print(solution(Gear, Turn))
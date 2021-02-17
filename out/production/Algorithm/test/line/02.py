from collections import deque

def solution(ball, order):
    answer = []
    ball = deque(ball)
    n = len(order)
    save = []

    while ball:
        for i in range(n):
            if len(ball) == 0:
                break
            if order[i] == ball[0]:
                answer.append(ball.popleft())
            elif order[i] == ball[-1]:
                answer.append(ball.pop())
            else:
                save.append(order[i])

            for _ in range(len(save)):
                if not save:
                    break
                if ball[0] in save:
                    x = ball.popleft()
                    answer.append(x)
                    save.remove(x)
                elif ball[-1] in save:
                    x = ball.pop()
                    answer.append(x)
                    save.remove(x)

    return answer

# print(solution([1, 2, 3, 4, 5, 6], [6, 2, 5, 1, 4, 3]))
print(solution([11, 2, 9, 13, 24], [9, 2, 13, 24, 11]))


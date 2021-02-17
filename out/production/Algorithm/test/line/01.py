
def solution(boxes):
    n = len(boxes)
    chk = [0] * n

    for i in range(n):
        if chk[i]==1 or boxes[i][0] == boxes[i][1]:
            chk[i] = 1
        else:
            flag = False
            for j in range(n):
                if i == j:
                    continue
                elif boxes[j][0] == boxes[j][1]:
                    chk[j] = 1
                    continue
                elif boxes[i][0]==boxes[j][0]:
                    x, y, mx, my, flag = i, 0, j, 1, True
                elif boxes[i][0]==boxes[j][1]:
                    x, y, mx, my, flag = i, 0, j, 0, True
                elif boxes[i][1]==boxes[j][0]:
                    x, y, mx, my, flag = i, 1, j, 1, True
                elif boxes[i][1]==boxes[j][1]:
                    x, y, mx, my, flag = i, 1, j, 0, True

                if flag:
                    tmp = boxes[x][y]
                    boxes[x][y] = boxes[mx][my]
                    boxes[mx][my] = tmp
                    if boxes[x][0]==boxes[x][1]:
                        chk[x] = 1
                    if boxes[mx][0] == boxes[mx][1]:
                        chk[mx] =  1
                    break


    return chk.count(0)

print(solution([[1, 2], [2, 3], [3, 1]]	))
def findRowIdx(board, j, n):
    for i in range(n):
        if board[i][j] != 0:
            return i
    return n

def solution(board, moves):
    answer = 0
    stack = []
    n = len(board)
    m = len(board[0])
    lastRowIdx = [0] * m

    # 가장 위에 있는 인형의 인덱스를 담는다.
    for j in range(m):
        lastRowIdx[j] = findRowIdx(board, j, n)

    for m in moves:
        colsIdx = m - 1
        if lastRowIdx[colsIdx] == n:
            continue

        doll = board[lastRowIdx[colsIdx]][colsIdx]
        board[lastRowIdx[colsIdx]][colsIdx] = 0
        lastRowIdx[colsIdx] += 1

        if len(stack) > 0 and stack[-1] == doll:
            stack.pop()
            answer += 2
            continue
        stack.append(doll)

    return answer


if __name__ == '__main__':
    ans = solution(
        [[0, 0, 0, 0, 0],
         [0, 0, 1, 0, 3],
         [0, 2, 5, 0, 1],
         [4, 2, 4, 4, 2],
         [3, 5, 1, 3, 1]],
        [1, 5, 3, 5, 1, 2, 1, 4]
    )
    print(ans)

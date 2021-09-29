
def solution(lottos, win_nums):
    winningCount = 0
    zeroCount = 0
    for lotto in lottos:
        if lotto == 0:
            zeroCount += 1
            continue
        
        if lotto in win_nums:
            winningCount += 1
    
    if zeroCount == 6:
        return [1, 6]
    
    if winningCount == 0:
        return [6 - zeroCount, 6]
    
    return [7 - (zeroCount + winningCount), 7 - winningCount]
    

if __name__ == '__main__':
    lottos = [44, 1, 0, 0, 31, 25]
    win_nums = [31, 10, 45, 1, 6, 19]
    print(solution(lottos, win_nums))
    
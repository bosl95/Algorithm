'''
시간 제한 3초, 메모리 제한 8 MB
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
이 수는 10,000보다 작거나 같은 자연수이다.

첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
'''
import sys
n = int(sys.stdin.readline())   # for문의 range에 sys문장을 그대로 넣으면 안됨.
series = [0] * 10001

for _ in range(n):
    series[int(sys.stdin.readline())] += 1  # input을 저장하지 않고 인덱스로.

for i in range(10001):
    if series[i] != 0:
        for _ in range(series[i]):
            print(i)

'''
sort로 해서 풀면 메모리 초과가 된다.
메모리가 너무 적어서, input을 처음에 다 받아 저장하면 무조건 메모리 초과가 뜬다.
input을 따로 저장하지 않고 해결해야한다고 함.
'''
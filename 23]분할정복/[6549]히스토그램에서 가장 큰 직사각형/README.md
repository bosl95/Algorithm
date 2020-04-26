히스토그램에서 가장 넓이가 큰 직사각형을 구하는 프로그램을 작성하시오.

##### 입력
    7 2 1 4 5 1 3 3
    4 1000 1000 1000 1000
    0
##### 출력
    8
    4000

#### Algorithm
##### 현재 배열에서 최소 높이를 가지는 높이 h는 전체 밑변 w * h를 가진다.
==> 높이 오름차 순으로 분할 정복을 시행.
##### ex1) H = [2, 1, 4, 5, 1, 3, 3] 
* DAC(H)
  * H[1] = 1일 때 최소
  * DAC(H[0]), DAC(H[2]~H[6]) 호출
  * max(len(H)*H[1], DAC(H[0]), DAC(H[2]~H[6]))
##### 이 방법을 최대 넓이를 구할때 까지 반복.

#### **분할 정복을 이용한 코드**
    import sys;input = sys.stdin.readline
    h_arr = []
    while True:
        x = input()
        if x[0]=='0':
            break
        h_arr.append(list(map(int, x.split()))) # 입력
    
    def DAC(arr):
        l = len(arr)
        if l == 1: return arr[0]
        else:
            m = min(arr)
            idx = arr.index(m)
            if idx==0:
                idx += 1
            return max(DAC(arr[:idx]), DAC(arr[idx:]), l*m)
    
    for h in h_arr:
        print(DAC(h))
 예제 출력은 잘 되었지만, 메모리 초과가 발생.

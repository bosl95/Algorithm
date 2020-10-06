# [[1822]차집합](https://www.acmicpc.net/problem/1822)

## Binary Search를 이용하지 못한 풀이
### 이분 탐색을 이용하여 풀고 싶었으나, 결국 풀지 못했고 set을 이용하여 차집합을 구해 프린트하는 방식으로 해결했다.<br>
### 그리고 파이썬으로 푼 코드를 참고하려고 하였으나 다들 set을 이용하였다...(이분탐색을 이용하여 통과한 파이썬 코드는 아직까지 없는 듯 하다.)

<br>

## 다른 언어를 이용한 이분탐색 풀이

    #include <iostream>
    #include <algorithm>
    using namespace std;
    
    int N, N1, N2, cnt;
    int a[500001], b[500001];
    bool trip[500001];
    
    int binary_search(int target) {
        int st, en, mid;
        st = 0;
        en = N1;
        
        while(st < en) {
            mid = (st+en) / 2;
            if (a[mid] == target) return mid;
            else if (a[mid] < target) st = mid + 1;
            else if (a[mid] > target) en = mid;
        }
        return -1;
    }
    int main(void) {
        ios::sync_with_stdio(0);
        cin.tie(NULL);
        cout.tie(NULL);
        cin >> N1 >> N2;
        for (int i = 0; i < N1; ++i) cin >> a[i];
        for (int i = 0; i < N2; ++i) cin >> b[i];
        N = N1;
    
        sort(a, a + N1);    
        for (int i = 0; i < N2; ++i) {
            //b[i]가 a[]에 있는지 체크
            int idx = binary_search(b[i]);
            if (idx != -1) {
                trip[idx] = true;
                N--;
            }
        }
        
        cout << N << endl;
        for (int i = 0; i < N1; ++i) {
            if (trip[i] == false) 
                cout << a[i] << " ";
        }
        cout << endl;
        return 0;
    }
    
### 문제의 의도라도 이해할 수 있도록 다른 언어를 이용한 풀이를 참고하였다.
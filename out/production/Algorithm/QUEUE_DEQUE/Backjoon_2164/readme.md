# [[2164]카드2](https://www.acmicpc.net/problem/2164)

## Queue를 이용한 풀이

- `Queue`를 이용하여 풀면 되는 간단한 문제
- `Queue`  사용법에 익숙해지기 위해서 사용하였으나, 다른 방법으로 풀 수도 있다.

<br>

### 다른 사람의 풀이<br>

```java
import java.io.*;
import java.util.*;
	public class Main {
		public static void main(String[] args) throws NumberFormatException, IOException {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int cnt = Integer.parseInt(br.readLine());
	    	int arr[] = new int[1000000];
	    	int len = cnt-1;
	    	int point=0;
	    	int tmp=0;

	    	for(int i=0;i<cnt;i++)
	    	{
	    		arr[i] = i+1;
	    	}
	    	while(cnt>1)
	    	{
	    		point++;
	    		tmp = arr[point];
	    		point++;
	    		arr[++len] = tmp;
	    		cnt--;
	    	}
	    	System.out.println(arr[len]);
	}
}
``` 

이 방식은 `Queue`로 푸는 것보다 시간이 빠르다.
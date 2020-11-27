import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		for (int i=0;i<n+1;i++) {
			if (i==0) dp[i] = 0;
			else if (i==1) dp[i]=1;
			else if (i==2) dp[i]=3;
			else dp[i] = (dp[i-1]+dp[i-2]*2)%10007;
		}
		System.out.println(dp[n]);
	}

}

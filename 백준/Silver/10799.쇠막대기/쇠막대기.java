import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, ans;
	static char[] pipe;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pipe = br.readLine().toCharArray();
		N = pipe.length;
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(i<N-1 && pipe[i] == '(' && pipe[i+1] == ')') {
				ans+= cnt;
				i++;
			}
			else if (pipe[i] == '(') cnt++;
			else if (pipe[i] == ')') {
				ans++;
				cnt--;
			}
		}
		
		System.out.println(ans);
	}

}
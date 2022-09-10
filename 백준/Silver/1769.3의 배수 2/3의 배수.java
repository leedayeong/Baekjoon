import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String N;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = br.readLine();

		check(N);
		
	}
	public static void check(String sum) {
		//탈출
		if(sum.length()==1) {
			System.out.println(cnt);
			if (Integer.parseInt(sum)%3 == 0) {
				System.out.println("YES");
			}else System.out.println("NO");
			return;
		}
		
		//카운트
		cnt++;
		
		long tmpSum = 0;
		for (int i = 0; i < sum.length() ; i++) {
			tmpSum += (sum.charAt(i) - '0');
		}
	
		check(Long.toString(tmpSum));
	}
}
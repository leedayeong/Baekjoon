import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char [] str= br.readLine().toCharArray();
		int n = str.length;
		
		int cnt = 0;
		int N; //스위치 사이즈
		
		N = n+1;
		char[] switches = new char[N];
		
		for (int i = 1; i < N; i++) {
			switches[i] = str[i-1];
		}
		
	
		for (int i = 1; i < N; i++) {
			int offIdx = 0;
			if(switches[i] == 'Y') {
				cnt++;
				for (int j = i; j < N; j++) {
					if(j%i ==0) switches[j]= (switches[j]=='Y'?'N':'Y'); //i의 배수들을 모두 반전시키자!
				}
			}
			for (int j = 1; j < N; j++) {
				if(switches[j] == 'N') offIdx++; 
				else break;
			}
			if(offIdx == N-1) break;
		}
		System.out.println(cnt);
	}

}
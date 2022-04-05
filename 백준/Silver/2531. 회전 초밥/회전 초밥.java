import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, d, k, c, ans;
	static int[] visit;
	static int[] food;
	static int[] first;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		visit = new int[d+1];
		food = new int[k];
		first = new int[k];
		int cnt = 0;
		
		//쿠폰 추가
		visit[c]++;
		cnt++;
		
		for (int i = 0; i < k; i++) {
			food[i] = Integer.parseInt(br.readLine());
			first[i] = food[i];
			visit[food[i]] ++;
			if(visit[food[i]] == 1) cnt++;
		}
		
		ans = cnt;
		
		int idx = 0;
		for (int i = k; i < N; i++) {
			int num = food[idx];
			if(visit[num] == 1) cnt--; // 종류 줄어듦
			visit[num] --;
			
			food[idx] = Integer.parseInt(br.readLine());
			if(visit[food[idx]] == 0) cnt++; // 종류 추가
			visit[food[idx]] ++;
			
			idx = (idx+1) == k ? 0 : idx+1;
			
			ans = Math.max(ans, cnt);
		}
		
		// 다 돌고 뒤쪽에서 다시 앞접시! 
		for (int i = 0; i < k; i++) {
			int num = food[idx];
			if(visit[num] == 1) cnt--; // 종류 줄어듦
			visit[num] --;
			
			food[idx] = first[i];
			if(visit[food[idx]] == 0) cnt++; // 종류 추가
			visit[food[idx]] ++;
			
			idx = (idx+1) == k ? 0 : idx+1;
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, max;
	
	static int[] arr; // 일반 수열
	static int[] MIS; // 최장길이수열 )작아지는 수열)
	static int[] LIS; // 커지는 수열
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		MIS = new int[N];
		LIS = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 1;
		LIS[0] = 1;
		MIS[0] = 1;
		for (int i = 1; i < N; i++) {
			LIS[i] = 1;
			MIS[i] = 1;
			if(arr[i] >= arr[i-1] ) LIS[i] = Math.max(LIS[i], LIS[i-1] + 1);
			if(arr[i] <= arr[i-1] ) MIS[i] = Math.max(MIS[i], MIS[i-1] + 1);
			
			max = Math.max(max, Math.max(LIS[i], MIS[i]));
		}
		System.out.println(max);
	}

}
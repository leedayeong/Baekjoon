import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[] src;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//초기화
		min = 0;
		src = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(src);
		
		calc();
		System.out.println(min);
	}
	static void calc() {
		int time = 0;
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			time += src[i];
			sum += time; 
		}
		
		min = sum;
	}
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		
		int count = 0; // 죽은 사람이 생기면 하나씩 증가 => N이 되면 종료!
		int idx = 0; // 배열의 index
		int step = 1; // 살아있는 번호에 대해서만 증가  //1부터 살아있는 번호에 대해서 증가!
					    // 죽으면 그 자리를 0으로 바꾼다.
		
		
		sb.append("<");
		while(true) {
			if(count == N) break;
			
			if(input[idx % N] != 0) { //살아있는 애들에 대해서만
				
				if( (step% K) == 0) { // 죽을 대상
					sb.append(input[idx%N]).append(", ");
					input[idx%N] = 0;
					count++;
				}
				step++;	
			}
			idx++;
		}
		sb.setLength(sb.length()-2); // 마지막에 있는 ", "제거
		sb.append(">");
		System.out.println(sb);
		
	}
}
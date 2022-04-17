import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M = 1001;
	static int[][] paper;
	static int [][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map = new int[M][M];
		
		N = Integer.parseInt(br.readLine());
		
		paper = new int[N][4];
		
		StringTokenizer st = null;
		for (int t = 0; t < N; t++) {
			st = new StringTokenizer(br.readLine());
			paper[t][0] = Integer.parseInt(st.nextToken()); // sx
			paper[t][1] = Integer.parseInt(st.nextToken()); // sy
			paper[t][2] = Integer.parseInt(st.nextToken()); // col
			paper[t][3] = Integer.parseInt(st.nextToken()); // row
			
			
			
			for (int i = paper[t][1]; i <  paper[t][1] +  paper[t][3]; i++) {
				for (int j = paper[t][0]; j < paper[t][0] +  paper[t][2]; j++) {
					map[i][j] = t;
				}
			}
		}
		
		for (int t = 0; t < N; t++) {
			int cnt = 0;
			for (int i = paper[t][1]; i <  paper[t][1] +  paper[t][3]; i++) {
				for (int j = paper[t][0]; j < paper[t][0] +  paper[t][2]; j++) {
					if(map[i][j]== t) cnt++;
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
}
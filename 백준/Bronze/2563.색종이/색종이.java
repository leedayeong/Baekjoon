import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//델타
	
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int N = Integer.parseInt(br.readLine());
       
       int K = 100; //도화지 크기
       int [][] map = new int[K][K];
       
       for (int t = 0; t < N; t++) {
    	   StringTokenizer st = new StringTokenizer(br.readLine());
    	   int x = Integer.parseInt(st.nextToken());
    	   int y = 90 - Integer.parseInt(st.nextToken());
    	   
    	   for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[y+i][x+j] = 1; //(색종이가 붙은 검은 영역은 1)
			}
    	   }
       }
       
       int ans = 0; //1의 갯수 구하기(색종이가 붙은 검은 영역)
       
       for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				if(map[i][j] == 1) ans++;
			}
   	   }
       
       System.out.println(ans);
    }
}
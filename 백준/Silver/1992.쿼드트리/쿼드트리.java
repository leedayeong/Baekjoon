import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static char[][] tree;
	
	static StringBuilder sb = new StringBuilder();
	
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       
       tree = new char[N][];
       
       for (int i = 0; i < N; i++) {
    	  tree[i] = br.readLine().toCharArray(); 
       }
       
       compression(N, 0, 0);
       System.out.println(sb);
     
    }
    static void compression(int n, int y, int x) {
    	if(n < 1) return;
    	char ch = tree[y][x];
    	boolean chk = true;
    	for (int i = y; i < y+n; i++) {
			for (int j = x; j < x+n; j++) {
				if(ch != tree[i][j]) {
					chk = false;
					break;
				}
			}
		}
    	if(!chk) {
    		n/=2;
    		sb.append("(");
    		compression(n, y, x);
    		compression(n, y, x+n);
    		compression(n, y+n, x);
    		compression(n, y+n, x+n);
    		sb.append(")");
    	}
    	else {
    		sb.append(ch);
    	}
    }

}
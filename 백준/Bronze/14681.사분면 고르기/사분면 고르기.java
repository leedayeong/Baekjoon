import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int answer;
		
		if (x>0 && y>0) answer=1;
		else if (x<0 && y >0) answer = 2;
		else if (x<0 && y <0) answer = 3;
		else answer = 4;
		System.out.println(answer);
	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		char answer;
		switch(n/10) {
			case 10 : answer = 'A'; break;
			case 9 : answer = 'A'; break;
			case 8 : answer = 'B'; break;
			case 7 : answer = 'C'; break;
			case 6 : answer = 'D'; break;
			default : answer = 'F';
		}
		System.out.println(answer);
	}

}
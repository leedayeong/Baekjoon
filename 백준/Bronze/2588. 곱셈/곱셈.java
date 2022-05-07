import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int B1 = (int) str.charAt(0) - '0';
		int B2 = (int) str.charAt(1) - '0';
		int B3 = (int) str.charAt(2) - '0';
		
		System.out.println(A * B3);
		System.out.println(A * B2);
		System.out.println(A * B1);
		System.out.println(A * Integer.parseInt(str));
	}

}

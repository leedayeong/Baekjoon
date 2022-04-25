import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, N; // 입력받을 숫자
	static Number[] numbers; // M이상 N이하  숫자 배열 (class 설명은 밑에!)
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력위한 reader
		StringBuilder sb = new StringBuilder(); // 출력위한 builder
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		M = Integer.parseInt(st.nextToken()); // M이상 숫자
		N = Integer.parseInt(st.nextToken()); // N이하 숫자
		
		numbers = new Number[N-M+1]; // N-M+1 크기 만큼의 숫자 배열 생성
		
		for (int i = 0, j = M; i < N-M+1; i++, j++) { //N이상 M 이하 숫자에 대하여 영어로 변환 
			String tmp = Integer.toString(j);
			int size = tmp.length();
			String result = "";
			
			for (int k = 0; k < size; k++) {
				result += numToStr(tmp.charAt(k)) + " "; // ex) 79 => seven nine으로 result에 담음
			}
			
			numbers[i] = new Number(j, result); // 숫자 배열에 정수 숫자값과 영어로 변환한 값을 저장
		}
		
		Arrays.sort(numbers, (n1, n2) -> n1.numberStr.compareTo(n2.numberStr)); // 숫자 배열에 대해 영어 사전순으로 정렬
		
		for (int i = 0; i < N-M+1; i++) { // 한 줄에 10개의 숫자로 출력
			if(i>0 && i%10 ==0) sb.append("\n");
			sb.append(numbers[i].number + " "); 
		}
		
		sb.setLength(sb.length()-1);
		
		System.out.println(sb);
	
	}
	
	static String numToStr(char num) { //숫자 -> 영어로 변환하는 함수
		switch( num ) { 			   // ex) '0' -> "zero"
			case '0' : return "zero";
			case '1' : return "one";
			case '2' : return "two";
			case '3' : return "three";
			case '4' : return "four";
			case '5' : return "five";
			case '6' : return "six";
			case '7' : return "seven";
			case '8' : return "eight";
			case '9' : return "nine";
		}
		return "";
	}
	
	static class Number{ //숫자 num 에 대하여 정수 값 number 와 number를 숫자 단위로 읽은 영어 str
		int number; // 정수 값 number ex) 79
		String numberStr; // number를 숫자 단위로 읽은 영어 문자열 ex) seven nine 
		
		public Number(int number, String numberStr) {
			this.number = number;
			this.numberStr = numberStr;
		}
	}
}
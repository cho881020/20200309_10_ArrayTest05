package code;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		정답은 471로 강제 설정. => 배열로 만들면 좀더 편함.
		int[] answerArr = {4,7,1};
		
//		사용자에게 세자리숫자 입력 => 배열로 분리.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("세자리 숫자로 정답 입력 : ");
		int num = scan.nextInt();
		
//		입력받은 세자리 숫자를 배열로 분리.
//		123 => {1,2,3} 배열로.


		int[] userInputArr = new int[3];
//		0번칸 => 입력한 숫자의 100의 자리값.
//		456 입력 => 4 => 100으로 나눈 몫.
		userInputArr[0] = num / 100;
//		1번칸 => 입력한 숫자의 10의 자리값.
//		456 입력 => 5 : 45.6 => 45 => 5
		userInputArr[1] = num / 10 % 10;
//		2번칸 => 입력한 숫자의 1의 자리값.
//		456 입력 => 6 => 10으로 나눈 나머지.
		userInputArr[2] = num % 10;
		
	}

}












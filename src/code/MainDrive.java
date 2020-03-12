package code;

import java.util.Scanner;

import sun.security.util.ArrayUtil;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		정답은 471로 강제 설정. => 배열로 만들면 좀더 편함.
		int[] answerArr = {4,7,1};
		
		for (int i=0 ; i < answerArr.length ; i++) {
			answerArr[i] = 0; // 정답을 000으로 변경.
		}
		
//		컴퓨터가 문제를 랜덤으로 3자리 숫자로 출제.
//		 제약조건. 0은 사용하지 않는다. 1~9로 랜덤.
//		 세 자리 숫자는 중복되면 안됨.
		
//		사용자에게 세자리숫자 입력 => 배열로 분리.
		
		for (int i=0 ; i <answerArr.length ; i++) {
			
			while (true) {
				
				int randomNum = (int) (Math.random()*9+1);
				
//				중복검사? 로직 작성. => 배열이 숫자를 가지고있나? 판단. 기능 검색.
//				 => 검색 결과 마땅치 않다. 직접 로직 작성
				
				boolean isDuplOk = true;
				for (int num : answerArr) {
					if (num == randomNum) {
						isDuplOk = false;
						break;
					}
				}
				
				if (isDuplOk) {
					answerArr[i] = randomNum;
					break;
				}
				
				
			}
			
		}
		
		Scanner scan = new Scanner(System.in);
		
//		몇번이나 시도했는지 저장할 변수.
		int tryCount = 0;
		
//		한번 입력받고 끝이 아니라, 정답을 맞출때 까지 반복 입력.
//		반복 횟수가 불명확한 반복 => while (true) 활용
		
		while(true) {
			System.out.print("세자리 숫자로 정답 입력 : ");
			int num = scan.nextInt();
			
//			한번 시도 했다고 증가처리.
			tryCount++;
			
//			입력받은 세자리 숫자를 배열로 분리.
//			123 => {1,2,3} 배열로.


			int[] userInputArr = new int[3];
//			0번칸 => 입력한 숫자의 100의 자리값.
//			456 입력 => 4 => 100으로 나눈 몫.
			userInputArr[0] = num / 100;
//			1번칸 => 입력한 숫자의 10의 자리값.
//			456 입력 => 5 : 45.6 => 45 => 5
			userInputArr[1] = num / 10 % 10;
//			2번칸 => 입력한 숫자의 1의 자리값.
//			456 입력 => 6 => 10으로 나눈 나머지.
			userInputArr[2] = num % 10;
			
			
//			문제와 입력이 전부 배열로 분리됨.
//			 => ?S ?B인지 판단.
//			 => 스트라이크의 갯수 / 볼 갯수를 저장할 변수가 필요하다!
			int strikeCount=0;
			int ballCount=0;
			
//			입력과 문제를 비교해서 스트라이크 / 볼 갯수 카운팅
			
			for (int i=0 ; i < userInputArr.length ; i++) {
				for (int j=0 ; j < answerArr.length ; j++) {
					
//					내가 입력한 i번째 숫자와
//					정답의 j번째 숫자가 같은가?
//					일단 숫자가 같아야 S/B이건 판단할 가치가 있다.
					
					if (userInputArr[i] == answerArr[j]) {
						
//						추가검사. 값이 같을때, 위치도 같은가?
//						위치가 같다면? 스트라이크 찾음.
//						위치가 다르다면? 볼 찾음.
						
						if (i == j) {
//							숫자도 같고 위치도 같음. => S
//							S 한개 더 찾았다. 증가
							strikeCount++;
						}
						else {
//							숫자는 같은데 위치가 다름. => B 한개 더 찾음.
							ballCount++;
						}
						
						
					}
					
				}
			}
			
//			?S ?B인지 계산이 끝난 상태.
//			화면에 결과 출력.
			
			System.out.println(strikeCount+"S " + ballCount + "B 입니다.");
			
//			추가로 검사. => 만약 3S를 맞췄다면 무한반복 탈출.
			if (strikeCount == 3) {
				System.out.println("정답입니다!");
				System.out.println(tryCount + "회 만에 맞췄습니다.");
				break;
			}
			
		}
		
		
	}

}












package quiz;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class QuRockPaperScissors {
	
	
	static String getRSP(int rsp) {
		if(rsp == 1) {
			return "가위";
		}
		else if(rsp == 2) {
			return "바위";
		}
		else if(rsp == 3) {
			return "보";
		}
		else {
			return "가위바위보 할줄 모르세요? 제대로 내세요^^;";
		} // 안맞을 경우 경고메세지
	} // 문자열로 무엇을 냈는지 반환하는 메서드
	
	static int myRandom(int num) {
		Random rd = new Random();
		return rd.nextInt(num)+1;
	} // 난수 생성 메서드
	
	static int myGame() {
		try {
			System.out.print("무엇을 내겠습니까?(1:가위, 2:바위,3:보): ");
			Scanner scan = new Scanner(System.in);
			return scan.nextInt();
			
		} catch (InputMismatchException e) {
			return -1;
		}
	} // 가위바위보 입력 메서드
	
	static int myRegame() {
		try {
			System.out.print(" 게임을 계속하시겠습니까? 재시작(1), 종료(0): ");
			Scanner scan = new Scanner(System.in);
			return scan.nextInt();
			
		} catch (InputMismatchException e) {
			return -1;
		}
	} // 게임 재시작 입력 메서드
	
	public static void main(String[] args) {
		// 선택지 상수로 선언
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		final int REGAME = 1;
		final int EXIT = 0;
		
		// 경기수(승패까지) 변수로 선언 및 0으로 초기화
		int game = 0;
		int win = 0;
		int lose = 0;
		
		// 사용자와 컴퓨터가 낸 것이 무엇인지 저장(기본값 바위)
		int player = 2;
		int computer = 2;
		
		while(true) {
			for(int i = 0; i < 5; i++) {
				
				// 가위바위보!
				computer = myRandom(3);
				player = myGame();
				
				
				if(player==SCISSOR) {	// 사용자 가위
					System.out.printf("사용자: %s, 컴퓨터: %s%n",
								getRSP(player),getRSP(computer));
					if(computer==SCISSOR) {
						System.out.println("비겼습니다.");
					}
					else if(computer==ROCK) {
						System.out.println("졌습니다.");
						lose++; // 패배횟수 증가
					}
					else if(computer==PAPER) {
						System.out.println("이겼습니다.");
						win++; // 승리횟수 증가
					}
					else {
						System.out.println("?");
						// 컴퓨터의 값이 이상함
					}
				}
				
				else if(player==ROCK) { // 사용자 바위
					System.out.printf("사용자: %s, 컴퓨터: %s%n",
								getRSP(player),getRSP(computer));
					if(computer==SCISSOR) {
						System.out.println("이겼습니다.");
						win++;
					}
					else if(computer==ROCK) {
						System.out.println("비겼습니다.");
					}
					else if(computer==PAPER) {
						System.out.println("졌습니다.");
						lose++;
					}
					else {
						System.out.println("?");
					}
				}
				
				else if(player==PAPER) { // 사용자 보
					System.out.printf("사용자: %s, 컴퓨터: %s%n",
								getRSP(player),getRSP(computer));
					if(computer==SCISSOR) {
						System.out.println("졌습니다.");
						lose++;
					}
					else if(computer==ROCK) {
						System.out.println("이겼습니다.");
						win++;
					}
					else if(computer==PAPER) {
						System.out.println("비겼습니다.");
					}
					else {
						System.out.println("?");
					}
				}
				
				else {
					System.out.println(getRSP(player));
					game--;
					i--;
				} // 잘못된 입력으로 경기 진행이 안됐을때 경기수 차감
				game++; // 경기횟수 추가
			}//for
			
			// 총경기수와 승패 횟수 출력
			System.out.printf("총 경기수 : %d%n", game);
			System.out.printf("승리한 경기수 : %d%n", win);
			System.out.printf("패배한 경기수 : %d%n", lose);
			
			// 출력 후 재시작을 대비해 0으로 초기화
			game = 0;
			win = 0;
			lose = 0;
			
			System.out.print("5번의 게임이 끝났습니다.");
			
			// 게임 재시작 알고리즘
			while(true) {
				int regame = myRegame();
				
				if(regame==REGAME) {
					System.out.println("게임 재시작");
					break;
				} // break로 반복문을 탈출해 바깥 while문으로
				
				else if (regame==EXIT) {
					System.out.println("게임이 종료되었습니다. 감사합니다.");
					System.exit(0);
				} // 종료 입력시 프로그램 종료
				
				else {
					System.out.print("잘못입력하셨습니다.");
				} // 잘못된 입력일 경우 재입력 요청
			}//while
		}//while
	}//main
}

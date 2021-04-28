package step8_01_atm1;

import java.util.Random;
import java.util.Scanner;


public class ATM1 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager1 userManager = new UserManager1();  // UserManager1 클래스의 인스턴스를 생성 
	int identifier = -1;  							// 로그인된 user의 User1 클래스 배열 인덱스를 파악(-1일때 로그아웃 상태) 
	
	
	void printMainMenu() {
		// 선택 메뉴 항목을 출력 
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();	
												
			if      (sel == 1) 	    login();  //3번째로 구현
			else if (sel == 2) 		logout(); 
			else if (sel == 3) 		join();   //1번째로 구현  
			else if (sel == 4) 		leave();  //2번째로 구현 
			else if (sel == 0) 		break;	   	
			
		}
		
		System.out.println("[메시지] 프로그램을 종료합니다.");
	}
	
	void login() {
		//로그인(선택메뉴 항목에서 1번 선택 시 호출) 
		identifier = userManager.logUser();
		
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 실패");
		}
		else {
			printAccountMenu();
		}
		
	}
	
	void logout() {
		//로그아웃(선택메뉴 항목에서 2번 선택 시 호출)
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 후 이용 가능");
		}
		else {
			System.out.println("[메시지] " + userManager.user[identifier].id + "님 로그아웃 되었습니다.");
			identifier = -1;
		}
	}
	
	void join() {
		//회원가입(선택메뉴 항목에서 3번 선택 시 호출)
		userManager.addUser();
	}
	
	void leave() {
		//탈퇴(선택메뉴 항목에서 4번 선택 시 호출)
		userManager.leave();
	}
	
	void printAccountMenu() {
		//계좌관리 => 계좌생성/삭제/출력/로그아웃 (login메서드 실행 후 호출)
		while(true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();	
			
			String makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			//랜덤 계좌번호 생성(10000~100000)
			
			if(sel == 1) {
				// 계좌생성 구현
				
				if (userManager.user[identifier].accCount == 0) {
					userManager.user[identifier].acc = new Account1[1];
					userManager.user[identifier].acc[0] = new Account1();
					userManager.user[identifier].acc[0].accNumber = makeAccount;
				}
				//현재 로그인된 고객의 계좌수가 0이면 계좌배열 및 인스턴스 각1개씩 생성 후 입력받은 계좌번호 복사
				else {
					Account1[] tempAccount = userManager.user[identifier].acc;
					int tempAccCount = userManager.user[identifier].accCount;
					userManager.user[identifier].acc = new Account1[tempAccCount + 1];
					for (int i = 0; i < tempAccCount; i++) {
						userManager.user[identifier].acc[i] = tempAccount[i];
					}
					userManager.user[identifier].acc[tempAccCount] = new Account1();
					userManager.user[identifier].acc[tempAccCount].accNumber = makeAccount;
				}
				userManager.user[identifier].accCount++;
				System.out.println("[메시지] " + userManager.user[identifier].id + " 님 계좌번호 " + makeAccount + "가 생성되었습니다.");
			}
			
			else if(sel == 2) {
				// 계좌삭제 구현

				if(userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 삭제할 계좌 없음");
					continue;
				}
				
				else if(userManager.user[identifier].accCount == 1) {
					System.out.println("[메시지] " + userManager.user[identifier].id + "님 계좌번호" + userManager.user[identifier].acc[0].accNumber + "가 삭제되었습니다.");
					userManager.user[identifier].acc = null;
				}
				
				else {
					System.out.print("삭제하려는 계좌번호 입력 : ");
					String delAccount = scan.next();
					
					int tempAccCount = userManager.user[identifier].accCount;
					int delIdx = -1;
					
					for (int i = 0; i < tempAccCount; i++) {
						if(userManager.user[identifier].acc[i].accNumber.equals(delAccount)){
							delIdx = i;
						}
					}
					
					if(delIdx == -1) {
						System.out.println("[메시지] 계좌번호 다시 확인 요청.");
						continue;
					}
					else {
						System.out.println("[메시지] 계좌번호" + userManager.user[identifier].acc[delIdx].accNumber + "가 삭제되었습니다.");
						Account1[] tempAccount = userManager.user[identifier].acc;
						userManager.user[identifier].acc = new Account1[tempAccCount-1];
						for (int i = 0; i < delIdx; i++) {
							userManager.user[identifier].acc[i] = tempAccount[i];
						}
						for (int i = delIdx; i < tempAccCount-1; i++) {
							userManager.user[identifier].acc[i] = tempAccount[i+1];
						}
					}
				}
				userManager.user[identifier].accCount--;

			}
			else if(sel == 3) {
				// 조회 구현
				if(userManager.user[identifier].accCount == 0) {
					System.out.println("[메시지] 생성된 계좌가 없습니다.");
				}
				
				else {
					userManager.user[identifier].printAccount();
				}
			}
			
			else if(sel == 0) {
				logout();
				break;
			}
			
		}
		
		
	}
	
}

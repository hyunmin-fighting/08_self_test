package setp8_01_atm1_arraylist;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM01 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager01 manager = new UserManager01();
	int identifier = -1;

	void printMainMenu() {
		// 선택 메뉴 항목을 출력 
		while (true) {
			
			System.out.println("\n[ MEGA ATM ]");
			System.out.print("[1.로그인] [2.로그아웃] [3.회원가입] [4.회원탈퇴] [0.종료] : ");
			int sel = scan.nextInt();	
												
			if      (sel == 1) 	    login();  //3번째로 구현
			else if (sel == 2) 		logout(); //4번째로 구현
			else if (sel == 3) 		join();   //1번째로 구현  
			else if (sel == 4) 		leave();  //2번째로 구현 
			else if (sel == 0) 		break;	   	
			
		}
		
		System.out.println("[메시지] 프로그램을 종료합니다.");
	}
	
	void login() {
		identifier = manager.logUser();
		
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 실패");
		}
		else {
			printAccountMenu();
		}
		
	}
	
	void logout() {
		if(identifier == -1) {
			System.out.println("[메시지] 로그인 후 이용가능");
		}
		else {
			System.out.println("[메시지] " + manager.user.get(identifier).id + "님, 로그아웃 되었습니다.");
		}
		
	}
	
	void join() {
		manager.addUser();
	}
	
	void leave() {
		manager.leave();
	}
	
	void printAccountMenu() {
		
		while(true) {
			System.out.print("[1.계좌생성] [2.계좌삭제] [3.조회] [0.로그아웃] : ");
			int sel = scan.nextInt();	
		
			String makeAccount = Integer.toString(ran.nextInt(90001)+10000);
			
			if(sel == 1) {
				int tempAccCount = manager.user.get(identifier).accCount;
				manager.user.get(identifier).acc.add(new Account01());
				manager.user.get(identifier).acc.get(tempAccCount).accNumber = makeAccount;
				manager.user.get(identifier).accCount++;
				System.out.println("[메시지] " + manager.user.get(identifier).id + "님, 계좌번호 " + makeAccount + "가 생성되었습니다.");
			}
			
			else if(sel == 2) {
				
				if(manager.user.get(identifier).accCount == 0) {
					System.out.println("[메시지] 더이상 삭제 할 계좌가 없습니다.");
					continue;
				}
				else {
					System.out.print("삭제하려는 계좌번호 입력 : ");
					String delAccount = scan.next();
					int tempAccCount = manager.user.get(identifier).accCount;
					int delIdx = -1;
					
					for (int i = 0; i < tempAccCount; i++) {
						if(manager.user.get(identifier).acc.get(i).accNumber.equals(delAccount)) {
							delIdx = i;
						}
					}
					if(delIdx == -1) {
						System.out.println("[메시지] 계좌 재확인 요청");
						continue;
					}
					else {
						System.out.println("[메시지] " + manager.user.get(identifier).id + "님 계좌번호" + delAccount + "가 삭제되었습니다.");
						manager.user.get(identifier).acc.remove(delIdx);
					}
				}
				manager.user.get(identifier).accCount--;
			}
			
			else if(sel == 3) {
				
				if(manager.user.get(identifier).accCount == 0) {
					System.out.println("[메시지] 생성된 계좌가 없습니다.");
				}
				else {
					manager.user.get(identifier).printAccount();
				}
				
			}
			
			else if(sel == 0) {
				logout();
				break;
			}
		
		}
		
	}
}

	
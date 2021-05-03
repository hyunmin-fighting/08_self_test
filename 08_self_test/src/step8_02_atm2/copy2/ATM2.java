package step8_02_atm2.copy2;

import java.util.Scanner;



public class ATM2 {
	Scanner scan = new Scanner(System.in);
	UserManager2 um = UserManager2.getInstance();
	int identifier = -1;
	
	void play() {
		
		
		while (true) {
			
			System.out.println("[ATM]");
			System.out.println("[1.회원가입]\n[2.로그인]\n[0.종료]");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if		(sel == 1)  join();
			else if (sel == 2)  login();  
			else if (sel == 0)  break;
			
		}
		
	}
	
	
	void login() {
		identifier = UserManager2.getInstance().logUser();
		if(identifier != -1) loginMenu();
		else System.out.println("[메시지] ID/PW를 다시 확인하세요.");
	}
	
	
	void loginMenu() {
		
		while(true) {
		
			System.out.println("[" + um.userList[identifier].id + "님, 환영합니다.]");
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조    회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			
			
				if(selectMenu == 1) {
					//계좌생성
					AccountManager2.getInstance().createAcc(identifier);
	
				}
				else if(selectMenu == 2) {
					//계좌삭제
					AccountManager2.getInstance().deleteAcc(identifier);
					
				}
				else if(selectMenu == 3) {
					//계좌조회
					AccountManager2.getInstance().printAcc(identifier);
					
				}
				else if(selectMenu == 4) {
					//회원탈퇴
					identifier = UserManager2.getInstance().deleteMember(identifier);
					break;
				}
				else if(selectMenu == 0) {
					identifier = -1;
					System.out.println("로그아웃되었습니다.");
					break;
				}
		}
	}
	
	
	void join() {
		UserManager2.getInstance().joinMember();
	}
	

	
}

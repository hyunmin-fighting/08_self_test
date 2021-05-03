package step8_02_atm2.copy1;

import java.util.Scanner;

public class ATM1 {
	
	Scanner scan = new Scanner(System.in);
	UserManager1 um = UserManager1.getInstance(); //um참조변수로 UserManager1 싱글톤호출
	int identifier = -1;
	
	void play() {
		
		FileManager1.getInstance().load();
		UserManager1.getInstance().printAllUser();
		
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
		
		identifier = um.logUser();
		
		if(identifier == -1) {
			System.out.println("[메시지] ID와 PW를 확인하세요.");
		}
		else {
			loginMenu();
		}
		
	}
	
	
	void loginMenu() {
	
		while(true) {
			
			System.out.println("[" + um.userList[identifier].id + "님, 환영합니다.]");
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조    회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			if (selectMenu == 1) {
				AccountManager1.getInstance().createAcc(identifier);
				FileManager1.getInstance().save();
			}
			else if(selectMenu == 2) {
				AccountManager1.getInstance().deleteAcc(identifier);
				FileManager1.getInstance().save();
			}
			else if(selectMenu == 3) {
				AccountManager1.getInstance().printAcc(identifier);
			}
			else if(selectMenu == 4) {
				um.deleteMember(identifier);
				break;
			}
			else if(selectMenu == 0) {
				identifier = -1;
				System.out.println("[메시지] 로그아웃되었습니다.");
				break;
			}
		}
		
	}
	
	
	void join() {
		
		um.joinMember();
		
	}
	

	
}

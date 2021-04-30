package step8_02_atm2.copy1;

import java.util.Scanner;

public class ATM1 {
	
	Scanner scan = new Scanner(System.in);
	UserManager1 um = UserManager1.getInstance(); //um참조변수로 UserManager1 싱글톤호출
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
	
	
	void login() {}
	
	
	void loginMenu() {
		
		while(true) {
			
			System.out.println("[" + um.userList[identifier].id + "님, 환영합니다.]");
			System.out.println("[1.계좌생성]\n[2.계좌삭제]\n[3.조    회]\n[4.회원탈퇴]\n[0.로그아웃]");
			System.out.println("메뉴 선택 : ");
			int selectMenu = scan.nextInt();
			
			
		}
		
	}
	
	
	void join() {
		
		um.joinMember();
		
	}
	

	
}

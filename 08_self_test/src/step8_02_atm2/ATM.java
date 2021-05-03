package step8_02_atm2;

import java.util.Scanner;

public class ATM {
	Scanner scan = new Scanner(System.in);

	
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
	
	
	void loginMenu() {}
	
	
	void join() {}
	

	
}

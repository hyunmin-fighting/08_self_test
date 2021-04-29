package setp8_01_atm1_arraylist;

import java.util.Random;
import java.util.Scanner;

public class ATM01 {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	UserManager01 manager = new UserManager01();
	User01 user = new User01();

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
	
	void login() {}
	void logout() {}
	
	void join() {
		manager.addUser();
	}
	
	void leave() {}
	
	
}

	
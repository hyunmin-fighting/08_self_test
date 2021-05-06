package step8_03_atm3.copy1;

import java.util.Random;
import java.util.Scanner;

public class ATM1 {
	
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	
	void showMenu() {
		
		while(true) {
			
			printAllDataByAllUser();
			
			System.out.println("[MEGA ATM]");
			System.out.println("[1]회원가입\n[2]로그인\n[0]종료");
			System.out.print("메뉴를 선택하세요 : ");
			int choice = scan.nextInt();
			
			if		(choice == 1) 	join(); 
			else if (choice == 2) 	login(); 
			else if (choice == 0) 	break;
			
		}
	}
		
	void printAllDataByAllUser() {
		UserManager1.getInstance().printAllUserInfo();
	}
	
	void login() {
		UserManager1.getInstance().loginUser();
	}
	
	void join() {
		UserManager1.getInstance().joinUser();
	}
	
	
	
}








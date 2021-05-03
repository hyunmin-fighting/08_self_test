package step8_02_atm2.copy2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager2 {
	private FileManager2() {}
	private static FileManager2 instance = new FileManager2();
	public static FileManager2 getInstance() {
		return instance;
	}
	
	String fileName = "ATM text";
	String data = "";
	UserManager2 um = UserManager2.getInstance();
	
	
	void setData() {
		
		data = "";
		int userCount = um.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i=0; i<userCount; i++) {
			data += um.userList[i].id;
			data += "\n";
			data += um.userList[i].pw;
			data += "\n";
			data += um.userList[i].accCnt;
			data += "\n";
			
			if (um.userList[i].accCnt == 0) {
				data += "0\n";
			}
			else {
				for (int j=0; j<um.userList[i].accCnt; j++) {
					data += um.userList[i].acc[j].accNumber;
					data += "/";
					data += um.userList[i].acc[j].money;
					if (j != um.userList[i].accCnt-1) {
						data += ",";
					}
				}
				data += "\n";
			}
		}
		
	}
	
//	3
//	김현민
//	1212
//	1
//	3184763/0
//	김주원
//	2323
//	0
//	0
//	한원규
//	3434
//	0
//	0

	
	void save() {
		
		setData();
		
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fw != null) try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	
	void load() {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			if(file.exists()) {
				
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				// 파일로 부터 한줄씩 데이터를 읽어옴(읽어올 값이 없을때까지..)
				while(true) {
					String line = br.readLine();
					if(line == null) {
						break;
					}
					data += line;
					data += "\n";
				}
				
				//String 배열을 만들고 data 값을 띄어쓰기 기준으로 끊어서 배열 인덱스별로 나누어 담는다
				String[] temp = data.split("\n"); 
				// temp의 0번 인덱스 값은 고객수 값으로 문자형태를 정수형태로 변환하여 해당 변수에 담는다.
				um.userCnt = Integer.parseInt(temp[0]);
				um.userList = new User2[um.userCnt]; // userList 배열크기를 재정의
				// userCnt크기만큼 객체를 생성 
				for (int i = 0; i < um.userCnt; i++) {
					um.userList[i] = new User2();
				}
			}

			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {br.close();} catch (IOException e) {e.printStackTrace();}
			try {fr.close();} catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
}






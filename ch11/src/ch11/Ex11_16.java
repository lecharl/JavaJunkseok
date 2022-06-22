package ch11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex11_16 {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		System.out.println(map);
		map.put("asdf", "1234");
		System.out.println(map);
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("id와 password를 입력하세요.");
			System.out.print("id : ");
			String inputId = sc.nextLine().trim();
			
			System.out.print("password : ");
			String inputPw = sc.nextLine().trim();
			System.out.println();
//			idㄴㄴ :: key일치 확인 -> containsKey(Object key)
			if(!map.containsKey(inputId)) {
				System.out.println("입력하신 id는 존재하지 않습니다. 다시 입력하세요.");
				continue;
			}
//			pwㄴㄴ :: 
			if(!map.get(inputId).equals(inputPw)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
				continue;
			}else {
				System.out.println("id와 비밀번호가 일치합니다. 환영합니다.");
				break;
			}
			
		}//while
		
	}

}

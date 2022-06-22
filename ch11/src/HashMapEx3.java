import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx3 {
	static HashMap phoneBook = new HashMap();
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");
		printList();
	} //main
//	그룹을 추가
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}
	
//	그룹에 전화번호 추가
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);	//그룹이 없으면 추가하고 찾기, 있으면 바로 찾기
		HashMap group = (HashMap) phoneBook.get(groupName);
		group.put(tel, name);	//name은 중복될 수 있으니 tel을 key로!!**
	}
	
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	private static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Map.Entry me = (Map.Entry)it.next();
//			me.getValue() 반환값 : Object 이므로 -> HashMap 변환 **
			Set subSet = ((HashMap)me.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println(" * "+me.getKey() + "["+subSet.size()+"]");	//그룹이름, 각 그룹당 크기
			
			while(subIt.hasNext()) {
				Map.Entry subMe = (Map.Entry) subIt.next();
				String telNo = (String) subMe.getKey();
				String name = (String) subMe.getValue();
				System.out.println(name + " : "+telNo);
//				System.out.println(subMe.getValue() + " : "+ subMe.getKey());	이렇게 바로 해도 됨!
			}
			System.out.println();
		}
	}
}

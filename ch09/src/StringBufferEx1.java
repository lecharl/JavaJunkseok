
public class StringBufferEx1 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println("sb1 == sb2 ? :: "+(sb1 == sb2));
		System.out.println("sb1.equals(sb2) ? :: "+(sb1.equals(sb2)));
		
//		toString() 으로 equals()비교해야 한다!!
		System.out.println("sb1.toString().equals(sb2.toString()) :: "+sb1.toString().equals(sb2.toString()));
		
		StringBuffer s = new StringBuffer("aaa");
//		자기 자신 반환!!
		StringBuffer ns = s.append("222");
		System.out.println("s = "+s);
		System.out.println("ns = "+ns);
//		연달아 해도 된다!!
		System.out.println("s.append(\"asdf\").append(\"6666\") :: "+s.append("asdf").append("6666"));
		
	}

}

package tptty.example02;

//import java.util.*; //유틸리티안에 있는 모든 클래스 import
import java.util.List;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		List<Integer> vec1 = new Vector<Integer>(); //부모가 List기 때문에 Vector는 List로 참조 가능
		Vector<Integer> vec2 = new Vector<Integer>();
		Vector<Integer> vec3 = new Vector<>(); //타입생략가능
		Vector<Integer> vec4 = new Vector<>(5); //초기용량 설정 (디폴트 용량 : 10)
		
		Vector<String> vec5 = new Vector<>();
		System.out.println(vec5.size()+" : "+vec5.capacity()); //List는 capacity사용x
		Vector<String> vec6 = new Vector<>(3);
		vec6.add("greenjoa1");
		vec6.add("greenjoa2");
		vec6.add("greenjoa3");
		vec6.add("greenjoa4");
		System.out.println(vec6.size()+" : "+vec6.capacity()); //오버플로가 발생하면 용량이 2배로 자동증가(기본)
		
		Vector<String> vec7 = new Vector<>(3,5); //오버플로가 발생했을 때 (,x)x만큼 용량증가
		vec7.add("greenjoa1");
		vec7.add("greenjoa2");
		vec7.add("greenjoa3");
		vec7.add("greenjoa4");
		System.out.println(vec7.size()+" : "+vec7.capacity()); 
		
		Vector<String> vec8 = new Vector<>(vec7);
		System.out.println(vec8); //vec8의 주소값이 아니라  멤버의 값들이 출력됨(vec7이 가진 값)

	}

}

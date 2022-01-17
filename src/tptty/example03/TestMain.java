package tptty.example03;

import java.util.List;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		Vector<String> vec = new Vector<>();
		vec.add("greenjoa1");
		vec.add("greenjoa2");
		vec.add("greenjoa3");
		vec.add("greenjoa4");
		vec.add("greenjoa5");
//		vec.add(2, "greenjoa6"); //2번인덱스에 greenjoa6추가
		vec.add("greenjoa6");
		
		List<String> vec2 = vec.subList(1, 5); //인덱스 1번부터 4번까지만
		System.out.println(vec2);
		
		vec.subList(1, 3).clear(); //인덱스 1번부터 2번까지 값 지우기
		System.out.println(vec);
		
		vec.remove(0); //인덱스번호
		vec.remove("greenjoa5"); //실제 값
		//만약 greenjoa5가 여러개 있는 경우 첫번째 나오는 greenjoa5만 지워짐(다 지워지지 않음)
		
		//이때, greenjoa5를 모두 지우는 방법
		while(vec.contains("greenjoa5")) {
			int index = vec.indexOf("greenjoa5"); //greenjoa5가 있는 인덱스방의 정보를 반환
			vec.remove(index);
		}
		
//		vec.trimToSize(); //데이터가 있는 size만큼만 용량이 잘림
		
		for(String str : vec) {
			System.out.println(str);
		}
		
		System.out.println("------------------------");
		
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i)); //배열에서 vec[i]와 같은 역할
			//System.out.println(vec.elementAt(i)); 와 동일
		}
		
		System.out.println(vec.size()+" : "+vec.capacity()); //데이터를 지우면 size는 줄어들지만 capacity는 줄어들지 않음
		
		

	}

}

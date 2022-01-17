package tptty.example01;

public class TestMain {

	public static void main(String[] args) {
		// E타입 대신 Integer로 생성
		MyArray<Integer> arr1 = new MyArray<Integer>(10);
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);
		
		//Q 만약 인덱스값으로 1이 아니라 5를 준다면, 현재 5번방에는 데이터가 없는상태
		//->앞에 코드에서 이럴 때는 null을 반환하라고 지정->null은 int형으로 받을 수 없음
		//A1 try-catch문으로 예외처리
		//A2 값을 int가 아니라 Integer타입으로 받음 (null값 참조 가능)
		try {
			int num = arr1.getElement(1);
		} // 1번 인덱스방에 들어가있는 값 반환
		catch (NullPointerException e) {
			System.out.println("인덱스 참조 오류");
		}
		
		//Integer num = arr1.getElement(5);
		//if(num==null)
		//	System.out.println("인덱스 참조 오류");
		
		//앞에서 타입 파라미터가 명시되었다면, 뒤는 생략 가능
		MyArray<Integer> arr2 = new MyArray<>(20);
		
		MyArray<String> arr3 = new MyArray<>(10);
		arr3.add("greenjoa1");
		arr3.add("greenjoa2");
		arr3.add("greenjoa3");
		String str = arr3.getElement(1);
		
	}

}

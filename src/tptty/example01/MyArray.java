package tptty.example01;

public class MyArray <E> { //<-public class MyArray
	private int capacity; //배열용량
	private int count=0; //배열에 실제 들어가는 자료개수
	E[] arr; //모든 타입이 E타입으로 변하는 것은 아님, 바꿀 것만 E타입으로 지정
	//Q 만약 배열에 다른 타입의 값을 넣고 싶으면 어떻게 하지?
	//A1 또 다른 배열 정의
	//A2 제네릭 프로그래밍
	
	//생성자
	@SuppressWarnings("unchecked") //경고무시
	public MyArray(int capacity) {
		super();
		this.capacity = capacity;
		arr = (E[])new Object[this.capacity];//타입 파라미터로는 배열생성x->Object로 생성 후 E타입으로 형변환
		//타입체크를 하지 않았으므로 정상적인 타입변환이 되지 않을 수 있어, 경고뜸->무시
	}
	
	public void add(E e) {//<-(int e)
		if(this.count<this.capacity) //들어갈 공간이 있으면
			arr[count++]=e;
		else
			System.out.println("공간 부족");
	}
	
	public E getElement(int index) {//<-public int
		if(index>=0 && index <count)
			return arr[index];
		else
			return null; //<-return Integer.MAX_VALUE; //참조변수만 가능(기본x)
	}
	
}

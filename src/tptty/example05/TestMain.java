//ArrayList와 LinkedList의 실행 성능 비교
package tptty.example05;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		long starttime = System.nanoTime(); //작업 시작시간 측정
		for(int i=0;i<10000;i++) {
//			list1.add(0,i); //항상 새롭게 들어오는 데이터는 인덱스 0번으로 들어옴
			//ArrayList보다 LinkedList가 월등히 빠름
			list1.add(i); //무조건 ArrayList가 느린 것은 아님
		}
		long endtime = System.nanoTime(); //작업 끝나는시간 측정
		System.out.println((endtime-starttime));
		
		starttime = System.nanoTime();
		for(int i=0;i<10000;i++)
//			list2.add(0,i);
			list2.add(i);
		endtime = System.nanoTime();
		System.out.println((endtime-starttime));
	}

}

package tptty.exmaple04;

import java.util.*;

public class TestMain02 {

	public static void main(String[] args) {
		//set구조는 순서가 유지되지 않음 (vs 배열과의 차이점)
		Set<Word> set = new HashSet<>();
		set.add(new Word("red", "빨강"));
		set.add(new Word("red", "빨강"));
		set.add(new Word("red", "빨강"));
		set.add(new Word("green", "초록"));
		set.add(new Word("blue", "파랑"));
		set.add(new Word("blue", "파랑"));
		set.add(new Word("blue", "파랑"));
		//오류발생 : 그냥 같은 내용을 add하다보면 중복제거가 안됨
		//오류원인 : HashSet은 값만 비교하는 것이 아니라 해시코드도 비교
		//해결방안 : equals만 오버라이딩할게 아니라 hashCode도 오버라이딩해서 재정의
		
		System.out.println(set);
		System.out.println(set.size());
		
		//앞에 List와 다르게 인덱스번호로 접근 불가능->iterator로 접근
		Iterator<Word> it = set.iterator(); //Word타입을 읽어내는 iterator
		while(it.hasNext()) { //previous는 사용불가
			Word word = it.next();
			System.out.println(word);
		}
		
		//집합 연산
		Set<Word> set1 = new HashSet<>(); //빈출단어
		set1.add(new Word("red", "빨강"));
		set1.add(new Word("green", "초록"));
		set1.add(new Word("blue", "파랑"));
		
		Set<Word> set2 = new HashSet<>(); //자주 틀리는 단어
		set2.add(new Word("red", "빨강"));
		set2.add(new Word("blue", "파랑"));
		set2.add(new Word("yellow", "노랑"));
		
		Set<Word> intersection = new HashSet<>(set2); //자주 틀리는 단어 중 빈출단어?
		intersection.retainAll(set1); //set과의 교집합정보만 남김
		System.out.println(intersection);
		
		//Stack사용
		Stack<Word> stack = new Stack<>();
		stack.push(new Word("red", "빨강")); //데이터 삽입 시, add가 아닌 push사용
		stack.push(new Word("green", "초록"));
		stack.push(new Word("blue", "파랑"));
		//입력순서 : red->green->blue
		
		Iterator<Word> stackit = stack.iterator(); //stack에 있는 자료 순차탐색
		while(stackit.hasNext()) {
			Word word = stackit.next();
			System.out.println(word);
			//출력순서 : red->green->blue
		}
		
		System.out.println();
		
		while(!stack.isEmpty()) { //stack이 비어있지 않은 동안
			Word word = stack.pop();
			System.out.println(word);
			//출력순서 : blue->green->red
		}
		
		//Queue사용
		Queue<Word> queue = new LinkedList<>(); 
		//Queue는 인터페이스라 직접 객체 생성 불가능
		//Queue의 구현 클래스인 LinkedList객체를 생성하고 부모(Queue)로 참조
		queue.offer(new Word("red", "빨강"));
		queue.offer(new Word("green", "초록"));
		queue.offer(new Word("blue", "파랑"));
		//입력순서 : red->green->blue
		
		
		//LinkedList는 컬렉션이므로 iterator사용가능
		Iterator<Word> queueit = queue.iterator();
		while(queueit.hasNext()) {
			Word word = queueit.next();
			System.out.println(word);
			//출력순서 : red->green->blue (입력된 순서 그대로)
		}
		
		System.out.println();
		
		while(!queue.isEmpty()) {
			Word word = queue.poll();
			System.out.println(word);
			//출력순서 : red->green->blue (FIFO특성)
		}
		
		//Deque사용-queue, stack구조 모두 사용가능
		Deque<Word> deque = new LinkedList<>(); 
		deque.offer(new Word("red", "빨강")); //deque에서의 offer : offerlast(뒤에 추가)
		deque.offer(new Word("green", "초록"));
		deque.offer(new Word("blue", "파랑"));
		//입력순서 : red->green->blue
		
		
		Iterator<Word> dequeit = deque.iterator();
		while(dequeit.hasNext()) {
			Word word = dequeit.next();
			System.out.println(word);
			//출력순서 : red->green->blue (입력된 순서 그대로)
		}
		
		System.out.println();
		
		while(!deque.isEmpty()) {
			Word word = deque.poll(); 
			//poll : 앞에서부터 가져옴
			//queue를 stack처럼 사용하고 싶을 경우 : poll대신 pollLast사용
			System.out.println(word);
			//출력순서 : red->green->blue (FIFO특성)
		}
		
		Stack<Word> dequeStack = new Stack<>();
		dequeStack.push(new Word("red", "빨강")); //데이터 삽입 시, add가 아닌 push사용
		dequeStack.push(new Word("green", "초록")); //데이터 삽입 시, 맨 앞에 : 가장 마지막에 추가된 것이 맨 앞에 위치
		dequeStack.push(new Word("blue", "파랑"));
		//입력순서 : red->green->blue
		
		Iterator<Word> dequeStackit = dequeStack.iterator(); //stack에 있는 자료 순차탐색
		while(dequeStackit.hasNext()) {
			Word word = dequeStackit.next();
			System.out.println(word);
			//출력순서 : blue->green->red
		}
		
		System.out.println();
		
		while(!dequeStack.isEmpty()) { //stack이 비어있지 않은 동안
			Word word = dequeStack.pop(); 
			//pop : 앞에꺼부터 읽고 제거(=removeFirst)
			//stack을 queue처럼 사용하고 싶은 경우 : pop대신 removeLast사용
			System.out.println(word);
			//출력순서 : blue->green->red
		}
		
		
	}

}

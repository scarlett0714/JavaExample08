package tptty.exmaple04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		Vector<Word> vec = new Vector<>();
		vec.add(new Word("red", "빨강"));
		vec.add(new Word("green", "초록"));
		vec.add(new Word("blue", "파랑"));
		Word w = new Word("yellow", "노랑");
		vec.add(w); // Word객체 생성하고 그 객체를 vec에 추가

//		vec.remove(0);
		vec.remove(w); // yellow정상적으로 삭제됨
		vec.remove(new Word("green", "초록"));
		// 오류발생 : 초록이 지워지지 않음
		// 오류원인 : remove(Object) Object의 주소값이 이전에 생성한 green, 초록객체와 같은 지 확인(값을 비교x)
		// 해결방법 : 값을 비교하게 만들어아함->Word클래스에서 equlas오버라이딩해서 재정의

		System.out.println(vec);

		// ArrayList사용
		ArrayList<Word> list = new ArrayList<>(); // List여도 상관x
		list.add(new Word("red", "빨강"));
		list.add(new Word("green", "초록"));
		list.add(new Word("blue", "파랑"));

		list.remove(new Word("green", "초록"));

//		Object[] arr = list.toArray(); //컬렌션배열을 일반 배열(Object)로 반환
//		//toArray() : 강제적으로 형변환을 시켜도 Object에서 다른걸로 형변환이 안되도록 설계됨->ClassCastException오류
//		//Word타입으로 사용하려면?
//		for(Object o : arr) {
//			if(o instanceof Word) {
//				Word w2 = (Word)o;
//				System.out.println(w2.eng);
//			}
//		}

		Word[] arr = list.toArray(new Word[list.size()]); // 제네릭클래스에서 일반배열로 받고 싶을 경우 위의 방법을 사용하기 보단 지금 방법 사용
		// 새로만든 Word배열의 크기가 0이어도 상관x

		for (Word w3 : arr) { // 일반배열 접근하듯이 사용
			System.out.println(w3.kor);
		}

		for (Word w1 : list) {
			System.out.println(w1.eng);
		}

		System.out.println(list);

		// LinkedList사용 : ArrayList와 동일
		// iterator사용
		LinkedList<Word> list1 = new LinkedList<>();
		list1.add(new Word("red", "빨강"));
		list1.add(new Word("green", "초록"));
		list1.add(new Word("blue", "파랑"));

//		Iterator<Word> it = list1.iterator(); //iterator : 자료 순차 탐색
		ListIterator<Word> it = list1.listIterator(); //ListIterator : previous(이전), next(이후)모두 이동 가능 vs iterator는 next(이후)만 가능
		while (it.hasNext()) { // 다음에 읽어낼 게 있으면 true : 데이터를 뒤로 접근
			Word word = it.next();
			if (word.equals(new Word("green", "초록"))) {
				System.out.println(word + " 삭제함");
				it.remove(); // iterator가 가리키고 있는 곳의 객체를 삭제
			}
			System.out.println(word);
		}
		System.out.println("==================");
		
		while(it.hasPrevious()) { //데이터를 앞으로 접근 : previous()
			Word word = it.previous();
			System.out.println(word);
		}
		
		System.out.println(list1);
		
		//HashMap사용
		HashMap<String, Word> map = new HashMap<>();
		map.put("red", new Word("red", "빨강")); //키 : red, 값 : Word객체
		map.put("green", new Word("green", "초록"));
		map.put("blue", new Word("blue", "파랑"));
		map.put("skyblue", new Word("blue", "파랑")); //map은 키가 중복되면 덮어씀
		
		System.out.println(map);
		
		//values는 중복이 가능한 Collection타입
		Collection<Word> words = map.values(); //값만 Collection타입으로 반환
		Iterator<Word> it2 = words.iterator();
		while(it2.hasNext()) {
			Word w2 = it2.next();
			System.out.println(w2);
		}
		
		
		//import java.util.Map.*을 해주면 Map.Entry대신 Entry사용가능
		Set<Map.Entry<String, Word>> set = map.entrySet();
		Iterator<Map.Entry<String, Word>> it3 = set.iterator();
		while(it3.hasNext()) {
			Map.Entry<String, Word> entry = it3.next();
			String key = entry.getKey();
			Word value = entry.getValue();
			System.out.println(key+ " : "+value);
		}
		//map에는 iterator가 존재하지 않음->set으로 바꿔 iterator사용
//		Set<String> keyset = map.keySet();
//		Iterator<String> it2 = keyset.iterator();
//		while(it2.hasNext()) {
//			String key = it2.next();
//			Word value = map.get(key);
//			System.out.println(key+" : "+value);
//		}
	}

}

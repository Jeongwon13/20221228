package pkg3;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		//1. 객체 생성
		HashSet<String> a = new HashSet<String>();
		//2. add() 메소드를 호출해서 "abc" 문자열을 저장하기
		boolean b = a.add("abc");
		//3. add() 메소드의 반환값을 화면에 표시
		System.out.println(b);
		
		//4. 다시 한번 같은 값을 저장하기
//		b = a.add("abc");
//		System.out.println(b);
		//4-1. if 조건문 사용해 add() 메서드 실행 결과 판단하기
		if(b == true) {
			System.out.println("문자열 abc가 저장되었습니다.");
		}else {
			System.out.println("문자열 abc가 저장되지 않았습니다.");
		}
		//5. 다시 한 번 값을 저장하기
		b = a.add("abc");
		System.out.println(b);
		//5-1. 다시 if 조건문 작성해 add() 메소드의 실행 결과를 판단하기
		if(b == true) {
			System.out.println("두 번째 값 abc가 정상적으로 저장되었습니다.");
		}else {
			System.out.println("두 번째 값 abc가 저장되지 않았습니다.");
		}
		/*
		 * 6. 반복자 Iterator 사용하기
		 *  - 내부 작동 원리
		 *   - Scanner 클래스와 매우 유사함
		 *    - 내부에 임시 배열 공간 사용
		 *   - iterator() 메소드를 호출해서 값을 갖고 있는 HashSet 클래스에 접근하기
		 *    - 형식:
		 *    Iterator<Wrapper클래스이름> 변수명 = HashSet 객체참조변수이름.iterator();
		 */
		Iterator<String> c = a.iterator();
		/*
		 * HashSet 클래스 내부에서 갖고 있는 여러 값들을 가져오는 반복문 작성하기
		 * 1) for문: for(초기식;조건식;증감식){}
		 *  - 여기선 보통 while문을 많이 사용. 지금 상황에서는 조건식 하나를 가지고도 반복을 실행
		 * 2) while문
		 *  - 하나의 조건식을 사용해서도 반복 구조 만들 수 있음.
		 */
		while(c.hasNext() == true) {
			//3) 실제 값은 next() 메소드를 호출해야 함.
			String value = c.next();
			//4) 사용자에게 값을 보여주기
			System.out.println("HashSet 클래스에서 가져온 값은 " + value);
			
		}
	}

}

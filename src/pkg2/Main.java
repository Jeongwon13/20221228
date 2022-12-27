package pkg2;

import java.util.*;

/*
 * 1. 제네릭 개념을 사용한 계산기 클래스
 */
class Calc {
	/*
	 * Number 클래스: Integer, Double, Float, Long wrapper 클래스의 부모 클래스(숫자 관련)
	 * List<? extends Number>: 제한(한정)
	 *  - List: 인터페이스 이름(다형성)
	 *  - <? extends Number>: 제한(한정)
	 *  - 외부에서 입력되는 값의 타입이 Number 클래스와 같거나
	 *    Number 클래스의 자식 클래스들을 모두 포함
	 *  - ?: 물음표의 의미는 와일드 카드 문자인 *를 의미 말그대로 아무 숫자 자료형이 오든 받아들이겠다는 Number의 자식클래스의 의미
	 *   - Number 클래스의 자식 클래스가 모두 허용
	 *   
	 *   int type: 숫자 자료형의 종류를 구분하는 값을 받는 매개변수
	 *    - 정수형 숫자이면 1을 입력 받음
	 *    - 실수형 숫자이면 2를 입력 받음
	 */
	public Number add(List<? extends Number> list, int type) {
		//외부에서 정수형 숫자가 입력된 경우에는 정수 덧셈 계산
		if(type == 1) {
			int sum = 0;
			//외부에서 입력받은 여러 정수값들을 하나씩 일거와 덧셈 계산 수행
			//변수 v를 선언할 때 Number 클래스 사용
			// - 이유: 위에서 <? extends Number>
			for(Number v : list) {
				//Number 클래스가 갖고 있는 intValue() 메소드 호출해 정수값 읽기
				
				sum += v.intValue();
			}
			return sum;
		}else {
			//double형 실수 덧셈 계산 명령어 작성
			double sum = 0;
			
			for(Number v : list) {
				//doubleValue() 메소드의 기능: Number 클래스로부터 실수 값 반환
				sum += v.doubleValue();
			}
			//덧셈 결과 반환
			return sum;
		}
	}

	}

public class Main {

	public static void main(String[] args) {
		Calc a = new Calc();
		/*
		 * 다형성을 위한 객체 생성 명령어 작성
		 *  - List: 인터페이스 이름
		 *   - ArrayList 클래스의 부모 인터페이스
		 */
		List<Integer> b = new ArrayList<Integer>();
		//add() 메소드의 기능: ArrayList 클래스 내부의 배열에 값을 저장
		// - 정수 10을 저장: Integer 클래스가 정수형 wrapper 클래스
		b.add(10);
		//정수 20도 ArrayList 클래스 내부의 배열에 값을 저장
		b.add(20);
		//실제 정수 덧셈 계산을 수행하기 위해 Calc 클래스에서 정의한 add() 메소드를 호출
		// - 첫 번째 값은 ArrayList 클래스 타입의 객체를 참조하고 있는 참조변수 b(10과 20을 보관)
		// - 두 번째 값은 정수형 덧셈 계산을 위한 값 정수 1(add 메소드의 int type 매개변수에 대입)
		Number r = a.add(b, 1);
		//정수 덧셈 계산 결과를 화면에 표시(30)
		System.out.println(r);
		System.out.println("======================");
		
		//다형성을 사용하지 않은 방법
		// - ArrayList 클래스를 바로 사용하기
		// - 형식) ArrayList<Wrapper클래스이름> 객체참조변수명 = new ArrayList<Wrapper클래스이름>();
		ArrayList<Double> e = new ArrayList<Double>();
		//ArrayList 클래스가 갖고 있는 add() 메소드 호출해서 덧셈 계산에 사용할 실수를 저장하기
		e.add(3.5);
		e.add(5.2);
		Number result4 = a.add(e, 2);
		System.out.println(result4);
		
		System.out.println("============================");
		
		
		//ArrayList 클래스를 사용하지 않은 방법
		// - Arrays 클래스가 갖고 있는 static 메소드인 asList() 메소드를 호출
		//  - asList() 메소드 내부에서 객체를 생성
		//   - asList() 메소드에게는 덧셈 계산에 사용할 정수 3개를 배열에 담아 전달
		// - 동적으로 한번만 사용할 수 있는 배열을 생성: new 자료형[] {값1,값2,값3...};
		// - 이유: 힙 메모리에 생성은 되지만 객체의 주소를 따로 보관하지 않기 때문
		List<Integer> d = Arrays.asList(new Integer[] {10,20,30});
		//Calc 클래스에서 정의한 add() 메소드 호출해 정수 덧셈 계산 수행: 10+20+30
		Number result = a.add(d, 1);
		//정수 덧셈 계싼 결과 화면에 표시
		System.out.println(result);
		
		System.out.println("===============================");
		//ArrayList 클래스를 사용하지 않고 실수 계산
		List<Double> c = Arrays.asList(new Double[] {3.2, 4.6, 5.8});
		//Calc 클래스에서 정의한 add() 메소드 호출해 정수 덧셈 계산 수행: 10+20+30
		Number result2 = a.add(c, 2);
		//정수 덧셈 계싼 결과 화면에 표시
		System.out.println(result2);
		
		
		/*
		 * Vector 클래스 써보기
		 * 1) 기본 형식
		 * - 객체 생성
		 * Vector<Wrapper클래스이름> 참조변수이름 = new Vector<Wrapper클래스이름>();
		 *  - Wrapper클래스이름: String, Integer, Double, Long, Float 등
		 */
		Vector<String> f = new Vector<String>();
		/*
		 * add() 메소드를 호출하면 Vector 클래스에 실제 값 저장
		 *  - 주의사항: 값의 형식이 String이어야 함.
		 */
		f.add("홍길동");//Vector 클래스 내부 배열의 첫 번째 값이 됨 0
		f.add("김길동");//두 번째 값 1
		f.add("나길동");//세 번째값 2
		
		/*
		 * Vector 클래스 내부에 있는 배열의 특정 방에 새로운 값을 입력하고 싶은 경우
		 *  - set() 메소드를 호출하기
		 *   - 형식) 객체참조변수이름.set(방번호, 새로운 객체);
		 *    - 주의사항: 방 번호 작성 시 0 이상이고, 현재 배열의 크기 -1
		 *     - 즉, 0 미만이거나 현재 배열의 크기보다 같거나 크면 예외 발생
		 */
		f.set(0, "다길동");
		/*
		 * Vector 클래스가 갖고 있는 배열의 모든 값을 확인 또는 특정 방 번번의 값만을 확인 가능
		 * 
		 */
		//1. 특정 방 번호의 값만을 읽기
		// - get() 메소드를 호출하기
		//  - 형식: 객체참조변수이름.get(방번호);
		//   - 방번호 작성시 주의사항: 0 ~ 배열의 크기 -1 까지만 사용
		String value = f.get(0);
		System.out.println("첫 번째 이름:" + value);
		System.out.println();
		
		//현재 배열의 값들: 다길동 홍길동 김길동 나길동 0 1 2 3
		//두 번째 값인 홍길동 꺼내오기: 객체참조변수이름.get(1);
		String value2 = f.get(1);
		System.out.println("두 번째 이름:" + value2);
		
		/*
		 * Vector 클래스의 내부 배열이 갖고 있는 모든 값들을 읽어와서 출력하기
		 *  - 반복자(Iterator)를 사용
		 *   - while 반복문과 함께 사용
		 *  또는
		 *  - for 반복문과 get() 메소드 함께 사용
		 *   - 차이점: get() 메소드는 방 번호를 꼭 지정해야 함.
		 *    - 하지만, 반복자는 방 번호를 지정하지 않습니다.
		 */
		/*
		 * 반복자를 사용하는 형식
		 * Iterator 인터페이스를 사용
		 *  - 형식: Iterator<Wrapper클래스이름> 객체참조변수명;
		 *    객체참조변수명 = Vector클래스가 갖고 있는 iterator() 메소드를 호출;
		 *    - iterator() 메소드가 반복자와 Vector 클래스를 연결(매개체 역할)
		 * import java.util.Iterator;
		 * 
		 */
		
		Iterator<String> g = f.iterator();
		/*
		 * Vector f에는 0 이상의 값이 있을 수 있기 때문에 반복문을 사용해야 함.
		 *  - 주로 while 반복문을 많이 사용함.
		 *   - 형식
		 *   while(조건식){
		 *     반복적으로 실행할 명령문;
		 *   }
		 *  - 조건식: 반복자인 Iterator 인터페이스가 갖고 있는 hasNext() 메소드를 호출
		 *   - Vector 클래스의 내부 배열에서 읽어올 값이 있다면 true 반환
		 *    - 없다면 false 반환
		 *     - while(g.hasNext() == true)
		 */
		while(g.hasNext() == true) {
			System.out.println("현재 값이 있는 상태입니다.");
			//배열에서 값을 가져오는 메소드는 next()
			// - 형식: 객체참조변수명.next()
			String value3 = g.next();
			//배열에서 가져온 값을 화면에 표시
			System.out.println(value3);	
		}
		System.out.println("==========================================");
		/*
		 * 검색(Search)
		 * 예) 다길동 김길동 나길동 중에서 특정 이름 찾기
		 *  - 기능을 수행하는 메소드 이름은 contains()
		 *   - 형식: boolean 변수명 = 객체참조변수이름.contains(찾고싶은값 또는 객체);
		 *   - 예제: 다길동 이름을 찾기
		 *    - boolean h = f.contains("다길동");
		 *     - 만약 다길동이 있다면 true 반환. 없음 false 반환
		 */
		boolean h = f.contains("다길동");
		System.out.println("다길동을 찾은 결과는 " + h);
		
		//없는 이름인 라길동 찾기
		h = f.contains("라길동");
		System.out.println(h);

		/*
		 * Vector 클래스가 갖고 있는 배열이 갖고 있는 값을 삭제하기
		 * 1) 모든 값을 삭제(제거: clear() 메소드 사용)
		 *  - 형식: 객체참조변수명.clear()
		 * 
		 * 2) 하나의 값만을 삭제(제거: remove() 메소드 사용)
		 *  - 형식: 객체참조변수명.remove(인덱스)
		 */
		f.remove(0);//첫 번째 이름을 제거
		String value4 = f.get(0);
		System.out.println(value4);
		//clear() 메소드 사용하면 모든 값들 제거
		f.clear();
		//size() 메소드 호출하면 현재 배열에 저장된 값의 개수 반환
		// - 형식: int 변수명 = 객체참조변수명.size();
		int size = f.size();
		System.out.println(size);
		
	
	
	
	
	}
	

}

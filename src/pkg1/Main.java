package pkg1;
/*
 * 1. 제네릭 기술을 사용
 */
class MyClass<T>{
	//멤버변수 a를 선언하는데 자료형은 미지정
	T a;
	//setter 메소드를 정의
	// - 위에서 선언한 멤버변수인 a에 값을 대입 -> 값을 입력받는 매개변수 선언
	public void set(T value) {
		a = value;
	}
	//getter 메소드 정의
	// -위에서 선언한 멤버 변수인 a의 값을 반환 -> 반환형에 미지정 타입 이름인 T를 사용
	public T get() {
		return a;
	}
	
	
	
	
}

public class Main {

	public static void main(String[] args) {
		//2. 위에서 정의한 MyClass 클래스 사용하기
		//1) String 자료형을 사용하고 싶은 경우의 형식
		//MyClass<String> 객체참조변수명 = new MyClass<String>();
		MyClass<String> a = new MyClass<String>();
		/*
		 * new MyClass<String>() 명령어가 실행되는 시점에
		 * MyClass 내부에서 선언한 멤버변수인 a의 자료형이 결정됩니다.
		 * class MyClass<String>{
		 * 	  String a;
		 * 	  public void set(String a) {}
		 *	  public String get() {}
		 * }
		 */
		//set() 메소드를 호출해 매개변수인 a에 문자열을 전달하기
		a.set("홍길동");
		//get() 메소드 호출해 멤버변수 a의 현재 값을 가져오기
		String value = a.get();
		//가져온 멤버변수 a의 현재 값을 화면에 표시
		System.out.println("MyClass 내부에서 선언한 멤버 변수 a의 값:" + value);
		
		/*
		 * Integer wrapper 클래스를 사용해 멤버변수 a의 자료형을 정수형으로 변경
		 *  - 형식: MyClass<Integer> 객체참조변수이름 = new MyClass<Integer>();
		 */
		MyClass<Integer> b = new MyClass<Integer>();
		//set(Integer value) 메소드를 호출해서 정수값을 매개변수 value에 전달하기
		b.set(100);
		//public Integer get() {} 메소드를 호출해 멤버변수인 a의 정수값을 읽어오기
		int value2 = b.get();
		System.out.println("MyClass 내부에서 선언한 멤버 변수 b의 값:" + value2);
		
		
		/*
		 * Double wrapper 
		 */
		MyClass<Double> c = new MyClass<Double>();
		c.set(3.14);
		double value3 = c.get();
		System.out.println(value3);
		
		
		
	}

}
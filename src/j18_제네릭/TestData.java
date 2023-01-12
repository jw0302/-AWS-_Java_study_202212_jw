package j18_제네릭;

// <T> : 제네릭
public class TestData<T> {	
	
	private T data1;				// Wrapper Class(래퍼 클래스)
	private double data2;				// 일반자료형 : int 일반자료형을 클래스화 시켜놓은것 (래퍼 클래스) : integer
	
	public TestData(T data1, double data2) {
		this.data1 = data1;
		this.data2 = data2;
	}

	@Override
	public String toString() {
		return "TestData [data1=" + data1 + ", data2=" + data2 + "]";
	}
	
	

}

package j13_상속;

public class KiaCar extends Car {
	
	public KiaCar() {
		
		super();
		
		System.out.println("자식");
		
	}
	
//	public void test() {
//		KiaCar kc = this;
//	}
	
	@Override
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage);
	}


}

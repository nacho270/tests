package main;

public class Test {

	public native String testJNI();
	
	static{
		System.loadLibrary("prueba-dll");
	}
	
	public static void main(String[] args) {
//		System.out.println(System.getProperty("java.library.path"));
		System.out.println(new Test().testJNI());
	}
}

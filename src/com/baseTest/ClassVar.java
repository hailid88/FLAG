package com.baseTest;

public class ClassVar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestVar.printTest();
		SystemTest.out.println();
	}

}

class TestVar{
	int m;
	static void printTest(){
		System.out.println("Hello");
	}
}


class SystemTest {
	  public static final PrintStreamTest out = new PrintStreamTest();
	  //...
	}

	//the Prinstream class belongs to java.io package
class PrintStreamTest{
public void println(){
};
//...
}






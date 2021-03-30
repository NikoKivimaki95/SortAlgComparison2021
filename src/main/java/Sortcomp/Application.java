package Sortcomp;

public class Application {
	
	public static void main(String[] args) {

		BackEndHandler beh = new BackEndHandler();
		
		int len = 100000;
		
		System.out.println(beh.testAlgorithms(new boolean[]{true, false, false}, 1000));
		
		beh.runAll(1);
		beh.runAll(10);
		beh.runAll(100);
		beh.runAll(1000);
		beh.runAll(10000);
		
		
	}
}

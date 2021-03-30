package Sortcomp;

public class Application {
	
	public static void main(String[] args) {
		Bubblesort bs = new Bubblesort();
		Heapsort hs = new Heapsort();
		Quicksort qs = new Quicksort();
		
		int len = 10000;
		
		Integer[] data = bs.sort(new CompArray(len));
		System.out.println("Comparisons: "+data[0]+" Swaps: "+data[1]);
		Integer[] data2 = hs.sort(new CompArray(len));
		System.out.println("Comparisons: "+data2[0]+" Swaps: "+data2[1]);
		Integer[] data3 = qs.sort(new CompArray(len));
		System.out.println("Comparisons: "+data3[0]+" Swaps: "+data3[1]);
		
		
	}
}

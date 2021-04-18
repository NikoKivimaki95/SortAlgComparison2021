package Sortcomp;

import java.awt.TextArea;
import java.util.ArrayList;

public class BackEndHandler {
	
	private ArrayList<SortingAlgorithm> algorithms;
	
	public BackEndHandler() {
		this.algorithms = new ArrayList<SortingAlgorithm>();
		algorithms.add(new Bubblesort());
		algorithms.add(new Heapsort());
		algorithms.add(new Quicksort());
	}
	
	public boolean testAlgorithms(boolean[] algorithms, int length) {
		boolean isSorted = true;
		if(algorithms.length == this.algorithms.size()) {
			for(SortingAlgorithm alg : this.algorithms) {
				CompArray tempArray = new CompArray(length);
				alg.sort(tempArray);
				for(int i = 0; i < tempArray.getLength(); i++) {
					if(tempArray.getAtIndex(i) != i) {
						System.out.println(tempArray.getAtIndex(i)+", "+ i);
						isSorted = false;
					}
				}
			}
		}
		else {
			return false;
		}
		return isSorted;
	}
	
	 public void runAll(int length) {
		  for(SortingAlgorithm alg : this.algorithms) {
		   Integer[] returnData = alg.sort(new CompArray(length));
		   System.out.println("Comparisons: "+returnData[0]+" "
				     + "Swaps: "+returnData[1]+" Time (ms): "+returnData[2]);
		  }
		 }
	
	public  ArrayList<SortingAlgorithm> getAlgorithms(){
		return this.algorithms;
	}
	
	public ArrayList<Integer[]> runAlgorithms(boolean[] algorithms, int length) {
		if(algorithms.length == this.algorithms.size()) {
			ArrayList<Integer[]> returnData = new ArrayList<Integer[]>();
			for(SortingAlgorithm alg : this.algorithms) {
				returnData.add(alg.sort(new CompArray(length)));
			}
			return returnData;
		}
		else {
			return null;
		}
	}
	
	public String getName(int index) {
		return this.algorithms.get(index).getName();
	}
}

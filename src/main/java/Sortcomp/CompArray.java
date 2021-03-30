package Sortcomp;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;


public class CompArray {

	private Integer[] arr;
	
	private int comparisons;
	private int switches;
	
	public CompArray(int length) {
		this.arr = new Integer[length];
		this.comparisons = 0;
		this.switches = 0;
		generateArray(length);
	}
	
	//Generates randomized array
	private void generateArray(int length) {
		
		for(int i = 0; i < length; i++) {
			arr[i] = i;
		}
		
		List<Integer> intList = Arrays.asList(arr);
		Collections.shuffle(intList);
		intList.toArray(arr);
	}
	
	public boolean isEqual(int a, int b) {
		comparisons++;
		if(arr[a] == arr[b]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isGreater(int a, int b) {
		comparisons++;
		if(arr[a] > arr[b]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSmaller(int a, int b) {
		comparisons++;
		if(arr[a] < arr[b]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isGreaterOrEqual(int a, int b) {
		comparisons++;
		if(arr[a] >= arr[b]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSmallerOrEqual(int a, int b) {
		comparisons++;
		if(arr[a] <= arr[b]) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void swap(int a, int b) {
		switches = switches + 3;
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}
	
	public boolean isSmallerThanInt(int a, int b) {
		comparisons++;
		if(arr[a] < b) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isGreaterThanInt(int a, int b) {
		comparisons++;
		if(arr[a] > b) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Integer[] getArray() {
		return arr;
	}
	
	public int getLength() {
		return arr.length;
	}
	
	public int getAtIndex(int index) {
		return arr[index];
	}
	
	public Integer[] getData() {
		return new Integer[]{comparisons, switches};
	}
}

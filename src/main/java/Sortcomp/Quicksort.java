package Sortcomp;

class Quicksort implements SortingAlgorithm{

	public Quicksort(){

	}

	public Integer[] sort(CompArray a){
		a.startMeasurement();
		quicksort(a, 0, a.getLength()-1);
		return a.getData();
	}
	
	//validates, that the algorithm is working
	public boolean validate(CompArray a) {
		boolean isInOrder = true;
		quicksort(a, 0, a.getLength()-1);
		
		for(int i = 0; i < a.getLength(); i++) {
			if(a.getAtIndex(i) != i) {
				isInOrder = false;
			}
		}
		
		return isInOrder;
		
	}

	public void quicksort(CompArray a, int low, int high){
		if(low < high){
			int p = partition(a, low, high);
			quicksort(a, low, p-1);
			quicksort(a, p+1, high);
		}
	}

	//last item as pivot, places into correct position. Smaller elements on left, larger ones on right
	private int partition(CompArray a, int low, int high){
		int pivot = a.getAtIndex(high);
		int i = low;
		for(int j = i; j < high; j++){
			if(a.isSmallerThanInt(j, pivot)){ //smaller than pivot, swap a[i] and a[j]
				a.swap(i, j);
				i++;
			}
		}
		a.swap(i, high); //swap a+1 and pivot
		return i;
	}
	
	public String getName() {
		return "Quicksort";
	}
}
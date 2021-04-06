package Sortcomp;

class Bubblesort implements SortingAlgorithm{

	public Bubblesort(){

	}

	public Integer[] sort(CompArray a){
		a.startMeasurement();
		bubblesort(a);
		return a.getData();
	}

	private void bubblesort(CompArray a){
		int n = a.getLength();
		for(int i = 0; i < n-1; i++){
			for(int j = 0; j < n-i-1; j++){
				if(a.isGreater(j, j+1)){ 				//compare element to next
					a.swap(j, j+1);						//swap if bigger
				}
			}
		}
	}
	
	public String getName() {
		return "Bubblesort";
	}
}
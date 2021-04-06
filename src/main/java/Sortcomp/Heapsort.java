package Sortcomp;

class Heapsort implements SortingAlgorithm{


	public Heapsort(){

	}

	public Integer[] sort(CompArray a){
		a.startMeasurement();
		heapsort(a);
		return a.getData();
	}

	public void heapsort(CompArray a) 
	{ 
		int n = a.getLength();

		for (int i = n / 2 - 1; i >= 0; i--){
			heapify(a, n, i);
		}

		for (int i = n - 1; i > 0; i--){
			a.swap(0, i);

			heapify(a, i, 0);
		} 
	} 

	private void heapify(CompArray a, int n, int i){
		int largest = i; // largest = root 
		int l = 2*i + 1; // left
		int r = 2*i + 2; // right

		// left > root
		if (l < n && a.isGreater(l, largest)){
			largest = l;
		}

		// right = largest
		if (r < n && a.isGreater(r, largest)){
			largest = r;
		}

		// largest != root
		if (largest != i){
			a.swap(i, largest);
			heapify(a, n, largest); 
		} 
	}
	
	public String getName() {
		return "Heapsort";
	}
}
import java.util.Arrays;

/*
 * This program is an example of the use of the Strategy design pattern.
 * In this case Strategy is defined as a functional interface, so lambda
 * expressions can be used.
 * Strategy allows to define different operation implementations for different
 * situations. In the example we want to sort arrays, but want to choose the
 * algorithm depending on its size.
 */

/*
 * This is the main class of the program. It uses the Sorter client.
 */
public class StrategyPatternLambda {
	
	public static void main(String args []) {
		int[] test1 = {9,8,7,6,5,4,3,2,1,0};
		int[] test2 = new int[200];
		
		for (int i=0; i<test2.length; i++)
			test2[i] = 200-i;

		Sorter sorter = new Sorter();
		BubbleSortStrategy bsort = new BubbleSortStrategy();
		MergeSortStrategy msort = new MergeSortStrategy();

		sorter.setStrategy(bsort::sort);
		sorter.sort(test1);
		System.out.println("test1: ");
		printArray(test1);

		sorter.setStrategy(msort::sort);
		sorter.sort(test2);
		System.out.println("test2: ");
		printArray(test2);

	}

	public static void printArray(int[] array) {
		String output = "";
		for (int i=0; i<array.length; i++)
			output += " "+array[i]+" ";
		System.out.println(output);
	}

}

/*
 * This interface generalizes the Strategies for different logics
 */
interface SortStrategy {
	public void sort(int[] array);
}

/*
 * Strategy that implements bubblesort. Thought for small datasets.
 */
class BubbleSortStrategy implements SortStrategy {
	
	@Override
	public void sort(int[] array) {
//		int lowestIndex;
//		for (int i=0; i<array.length; i++) {
//			lowestIndex = i;
//			for (int j=0; j<array.length; j++) {
//				if (array[j] < array[lowestIndex]) {
//					 lowestIndex = j;
//					 int aux = array[i];
//					 array[i] = array[lowestIndex];
//					 array[j] = aux;
//				}
//			}	
//		}

		//int[] sorted2 = sorter.sort(test2);
		int n = array.length;  
        int temp = 0;  
		for(int i=0; i < n; i++){  
			for(int j=1; j < (n-i); j++){  
				if(array[j-1] > array[j]){  
					temp = array[j-1];  
					array[j-1] = array[j];  
					array[j] = temp;  
				}
			}  
		}  

	}

}

/*
 * Strategy that implements mergesort (from the Collections utility). Thought 
 * for big datasets.
 */
class MergeSortStrategy implements SortStrategy {
	
	@Override
	public void sort(int[] array) {
		Arrays.sort(array);
	}

}

/*
 * This class represents the client that uses the strategies accordingly to the
 * situation
 */
class Sorter {

	SortStrategy strategy;

	public void sort(int[] array) {
		strategy.sort(array);
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}
	
}

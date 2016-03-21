package test;

public class BubbleSort {
	public static void bubble_sort(int[] arr) {
		int i, j, temp, len = arr.length;
		for (i = 0; i < len - 1; i++)
			for (j = 0; j < len - 1 - i; j++)
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}
	public static void main(String[] args) {
		int[] number = {95,45,15,78,84,51,24,12};
		int temp = 0;
		bubble_sort(number);
		for(int i = 0; i < number.length; i++) 
			System.out.print(number[i] + " ");
		//System.out.println();
	}
}
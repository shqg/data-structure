package test;
//输入n个整数，输出其中最小的k个。 o(nlogk)
public class findLeastNumbers {
	// 大顶堆
	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5,6,7,8 };
		int k = 4;
		findLeastNumber(arr,k);
	}
	public static void Adjustdown(int[] arr, int s, int m) {// 向下调整堆,删除时使用
		int temp = arr[s];
		int j;
		for (j = 2 * s + 1; j <= m; j = 2 * j + 1) {
			if (j < m && arr[j + 1] > arr[j])
				++j;
			if (temp > arr[j])
				break;
			arr[s] = arr[j];
			s = j;
		}
		arr[s] = temp;
	}

	public static void delete(int[] arr) {
		// 删除堆中的节点，安定义，堆中每次都只能删除第0个数据
		int len = arr.length;
		int temp  = arr[0];
		arr[0] = arr[len-1];
		arr[len-1] = temp;
		Adjustdown(arr, 0, len - 2);
	}

	public static void Adjustup(int[] arr, int i) {
		// 向上调整堆，插入节点时使用,每次插入都是将新数据放在数组最后。
		// 可以发现从这个新数据的父结点到根结点必然为一个有序的数列，
		// 因此需自下往上调整堆
		// i为数组中最后一个元素的下标
		int temp = arr[i];
		int j = (i - 1) / 2;// 父节点坐标
		while (j >= 0 && i != 0) {
			if (arr[j] > temp)
				break;
			arr[i] = arr[j];
			i = j;
			j = (j - 1) / 2;
		}
		arr[i] = temp;
	}

	public static void insert(int[] arr, int n, int num) {
		// 在数组arr中插入节点i
		arr[n] = num;
		Adjustup(arr, n);
	}

	public static void findLeastNumber(int[] arr, int k) {
		// 找到arr数组里最小的k个数
		if (arr.length == 0) {
			System.out.println("数组为空！");
			return;
		}
		int[] heapvector = new int[k];// 堆容器
		int i = 0;
		while (i < k) {
			insert(heapvector, i, arr[i]);
			i++;
		}
		for(int j=k;j<arr.length;j++){
			if(arr[j]<heapvector[0]){
				delete(heapvector);
				insert(heapvector,k-1,arr[j]);
			}
			
		}
		for(int j = heapvector.length-1;j>0;j--){
			int temp = heapvector[j];
			heapvector[j] = heapvector[0];
			heapvector[0] = temp;
			Adjustdown(heapvector,0,j-1);
		}
		for(int j = 0;j<heapvector.length;j++)
		System.out.println(heapvector[j]);
	}

}

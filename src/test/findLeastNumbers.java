package test;
//����n�����������������С��k���� o(nlogk)
public class findLeastNumbers {
	// �󶥶�
	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5,6,7,8 };
		int k = 4;
		findLeastNumber(arr,k);
	}
	public static void Adjustdown(int[] arr, int s, int m) {// ���µ�����,ɾ��ʱʹ��
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
		// ɾ�����еĽڵ㣬�����壬����ÿ�ζ�ֻ��ɾ����0������
		int len = arr.length;
		int temp  = arr[0];
		arr[0] = arr[len-1];
		arr[len-1] = temp;
		Adjustdown(arr, 0, len - 2);
	}

	public static void Adjustup(int[] arr, int i) {
		// ���ϵ����ѣ�����ڵ�ʱʹ��,ÿ�β��붼�ǽ������ݷ����������
		// ���Է��ִ���������ݵĸ���㵽������ȻΪһ����������У�
		// ������������ϵ�����
		// iΪ���������һ��Ԫ�ص��±�
		int temp = arr[i];
		int j = (i - 1) / 2;// ���ڵ�����
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
		// ������arr�в���ڵ�i
		arr[n] = num;
		Adjustup(arr, n);
	}

	public static void findLeastNumber(int[] arr, int k) {
		// �ҵ�arr��������С��k����
		if (arr.length == 0) {
			System.out.println("����Ϊ�գ�");
			return;
		}
		int[] heapvector = new int[k];// ������
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

package test;

public class spiltSearch2 {

 

	/**
	 �ǵݹ�
	 * @param arrayData ����
	 * @param searchData Ҫ���ҵ�����
	 * @param start ��ʼ�±�
	 * @param end �����±�
	 * @return �������������±��λ�ã�������ݲ��������У����� -1
	 * ��   �ܣ��۰���� 
	 */
	public static int splitHalf2(int[] arrayData,int searchData,int start,int end){
		 int index;
		if(start > end ){
			return -1;
		}
		while(start<=end){
			  index = (start + end)/2;
			int data = arrayData[index];
			
			   if(data<searchData){
		   start=index+1;
			  }
			  else if(data>searchData){
			  end =index-1;
			  } 
			   if(data == searchData){
				   return index;
				} 
		}
		return -1; 
			 
	}
	/* ������÷ǵݹ鷽��   if��Ϊwhile ÿ���жϺ�  start++    end--�� 
	 * while(start<=end){
	 * int index = (start + end)/2;
	 * if(data<searchData){
	 * start=index+1;
	 * }
	 * else if(data>searchData){
	 * end =index-1;
	 * } 
	 * }
	 * 
*/	
	/**
	 * @author hbliu
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 3,5,11,17,21,23,28,30,32,50};
		System.out.println(array.length);
		int isExist = splitHalf2(array,(int)30,0,array.length - 1);
		System.out.println("isExist : "+isExist);
	}

}

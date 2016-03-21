package test;

public class spiltSearch2 {

 

	/**
	 非递归
	 * @param arrayData 数组
	 * @param searchData 要查找的数据
	 * @param start 开始下标
	 * @param end 结束下标
	 * @return 数据在数组中下标的位置，如果数据不在数组中，返回 -1
	 * 功   能：折半查找 
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
	/* 如果采用非递归方法   if换为while 每次判断后  start++    end--； 
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

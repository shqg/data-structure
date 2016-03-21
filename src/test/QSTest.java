package test;

public class QSTest {
	 public int getMiddle(int[] list,int low,int high){
	        int tmp = list[low];
	     //   System.out.println(tmp);//数组的第一个元素做为中轴
	        while(low < high) {        
	            //从后面遍历
	            while(low < high && list[high] > tmp){
	                high--;
	            }
	            list[low] = list[high]; //比中轴小的元素移到低端
	            //从前面遍历 
	            while(low < high && list[low] < tmp){
	                low++;
	            }
	            
	            list[high] = list[low]; //比中轴大的元素移到高端
	           
	        }
	        list[low] = tmp; //中轴元素（此时list(low) == list(high)）
	        return low; //返回中轴的位置
	    }

	    public void _quickSort(int[] list,int low,int high){
	        if(low < high){
	            int middle = getMiddle(list,low,high); //将list数组进行一分为二
	            _quickSort(list,low,middle-1); //对低字表进行递归排序
	            _quickSort(list,middle+1,high); //对高字表进行递归排序
	        }
	    }

	    public void quick(int[] list){
	        if(list.length > 0){
	            _quickSort(list, 0, list.length-1);
	        }
	    }
	}

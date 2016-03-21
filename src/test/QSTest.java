package test;

public class QSTest {
	 public int getMiddle(int[] list,int low,int high){
	        int tmp = list[low];
	     //   System.out.println(tmp);//����ĵ�һ��Ԫ����Ϊ����
	        while(low < high) {        
	            //�Ӻ������
	            while(low < high && list[high] > tmp){
	                high--;
	            }
	            list[low] = list[high]; //������С��Ԫ���Ƶ��Ͷ�
	            //��ǰ����� 
	            while(low < high && list[low] < tmp){
	                low++;
	            }
	            
	            list[high] = list[low]; //��������Ԫ���Ƶ��߶�
	           
	        }
	        list[low] = tmp; //����Ԫ�أ���ʱlist(low) == list(high)��
	        return low; //���������λ��
	    }

	    public void _quickSort(int[] list,int low,int high){
	        if(low < high){
	            int middle = getMiddle(list,low,high); //��list�������һ��Ϊ��
	            _quickSort(list,low,middle-1); //�Ե��ֱ���еݹ�����
	            _quickSort(list,middle+1,high); //�Ը��ֱ���еݹ�����
	        }
	    }

	    public void quick(int[] list){
	        if(list.length > 0){
	            _quickSort(list, 0, list.length-1);
	        }
	    }
	}

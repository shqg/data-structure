package test;


	//-----------------------------------------------
	public class QuickSort {
	    public static void main(String args[]){
	        int[] list = {34,53,3  };
	        QSTest qst = new QSTest();
	        qst.quick(list);
	        for(int i=0;i<list.length;i++){
	            System.out.print(list[i] + " ");
	        }
	        //System.out.println();
	    }

}

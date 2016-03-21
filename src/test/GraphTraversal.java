package test;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author �����
 * @date 2015-02-11 18:52
 */
/*
 * <1>������ȱ������õݹ�ķ�ʽ��������
 * <2>������ȱ������ö��еķ��ʷ�ʽ�����ȶ�������У�Ȼ�������һ��Ԫ�ط���
 * ͬʱ�ö����������ڽڵ�����У�ֱ������Ϊ��ʱ��������
 * <3>��ͨ����:��ͼΪ��ͨͼʱ��ֻҪ����һ�ι�����ȱ�������������ȱ����Ϳ��Եõ���ͨ����
 *        ��ͼΪ������ͨͼʱ��ֻ�ܷ��ʸ�ͼ�������ͨ����
 */
public class GraphTraversal {
 /*
  * verNum:�洢�ڵ�ĳ���
  * visited:�������飬��ǵ�ǰ�ڵ��Ƿ��Ѿ����ʹ�
  * ver:�洢�ڵ�Ĺؼ���
  * edge:��ά���飬�洢�ڵ�֮��ߵ���Ϣ���б�
  */
 static int verNum;
 static boolean []visited;
 static String []ver={"A","B","C","D","E"};
 static int [][]edge;

 /*
  * ͼ��������ȱ�������
  */
 void dfsTraverse(){
  //�����нڵ���Ϊδ����
  visited=new boolean[verNum];
  for(int i=0;i<verNum;i++){
   if(visited[i]==false)
    dfs(i);
  }
 }

 /*
  * ͼ��������ȵݹ��㷨
  */
 void dfs(int i){
  visited[i]=true;               //���ʽڵ�
  System.out.print(ver[i]+" ");
  for(int j=0;j<verNum;j++){        //��������Ϣ�б����еݹ�
   if(visited[j]==false&&edge[i][j]==1){
    dfs(j);
   }
  }
 }

 /*
  * ͼ�Ĺ�����ȱ����㷨
  */
 void bfsTraverse(){
  visited=new boolean[verNum];         //������нڵ��δ������
  Queue<Integer>queue=new LinkedList<Integer>(); //�洢�ڵ�Ķ���
  for(int i=0;i<verNum;i++){           //���ʽڵ�
   if(visited[i]==false){
    visited[i]=true;
    System.out.print(ver[i]+" ");
    queue.add(i);                //���������
    while(!queue.isEmpty()){          //���в�Ϊ��ʱ���б�������
     int j=queue.poll();             //��������У���Ϊ��һ�����б���Ϣ�б���У���֤ÿ������Ϣ�б��õ�����
     for(int k=0;k<verNum;k++){
      if(edge[j][k]==1&&visited[k]==false){
       visited[k]=true;
       System.out.print(ver[k]+" ");
       queue.add(k);
      }
     }
    }
   }
  }
 }

 /*
  * ���ߵ���Ϣ�б����һ�������ı���Ϣ�б�
  */
 void addEdge(int i,int j){
  if(i==j)
   return;
  edge[i][j]=1;
  edge[j][i]=1;
 }

 /*
  * ���ͼ����ͨ����(����ͼΪ����ͨͼ����������ͼ�������ͨ����)
  */
 void con(){
  int count=0;
  visited=new boolean[verNum];
  for(int i=0;i<verNum;i++){
   if(!visited[i]){
    count++;
    dfsTraverse();          //����������ȱ���
   }
  }
  System.out.println("����"+count+"����ͨ����!");
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  verNum=ver.length;
  edge=new int [verNum][verNum];
  for(int i=0;i<verNum;i++){
   for(int j=0;j<verNum;j++){
    edge[i][j]=0;
   }
  }
  GraphTraversal b=new GraphTraversal();
  b.addEdge(0, 3);
  b.addEdge(0, 4);
  b.addEdge(1, 2);
  b.addEdge(2, 4);
  b.addEdge(2, 3);

  System.out.println("ͼ����ȱ�������:");
  b.dfsTraverse();
  System.out.println();
  System.out.println("ͼ�Ĺ�ȱ�������:");
  b.bfsTraverse();
  System.out.println();
  System.out.println("��ͨ����:");
  b.con();
 }
}

package test;

/* Single-Source Shortest Paths (Dijkstra's algorithm)
 * ���룺n������������ȨͼG������Ϊn*n����
 * ��ʼ��:v0 ��ȡֵ��ΧΪ0~n-1��
 * ��������·�����䳤�ȣ�����Ϊһ����ά����path[n-1][3]��ÿ������Ԫ����������������ɣ�����path[i][0]��������·��֮�յ㣬path[i][1]��������·��֮���ȣ�path[i][2]��������·���յ�֮ǰ����
 */
public class ShortestPathTest
{ 
   static int[][] graph={
       {1000, 1000, 10 , 1000, 30 , 100 ,},
       {1000, 1000, 5 , 1000, 1000, 1000,},
       {1000, 1000, 1000, 50 , 1000, 1000,},
       {1000, 1000, 1000, 1000, 1000, 10 ,},
       {1000, 1000, 1000, 20 , 1000, 60 ,},
       {1000, 1000, 1000, 1000, 1000, 1000,},
   };
   static int [][] path;
   static int v=0;

   public static void main(String[] args)
   {
       ShortestPath sortestPath=new ShortestPath();
       sortestPath.input(graph, v);
       path=sortestPath.getPath();
       for(int i=0; path[i][1]!=1000; i++){
           System.out.println("Դ�㣺" + v + "; �յ㣺" + path[i][0] + 
           "; ���ȣ�" + path[i][1] + "; �յ�ǰ����" + path[i][2]);
       }
   }
}

class ShortestPath
{
    private int[][] graph;
    private int v;
    private int[][] path;
    
    void input(int[][] graph, int v)
    {
        this.graph=graph;
        this.v=v;
        calculate();
    }
    
    void calculate()
    {
        path=new int[graph.length-1][];
        int[] s=new int[graph.length];
        for(int i : s)i=0; s[v]=2;
        
        //��·��ֵ��С�����˳�����������·��

        for(int i=0; i<graph.length-1; i++){
            //��v������s2�����·��pointToSet[0]

            int[][] pointToSet={{1, 1000, -1,},{1, 1000, -1,},};
            for(int j=0; j<graph.length; j++){
                if(s[j]==0 && graph[v][j]<pointToSet[0][1]){
                    pointToSet[0][1]=graph[v][j];
                    pointToSet[0][0]=j;
                }
            }
            
            //�󼯺�s1������s2�����·��setToSet[0]

            int[][] setToSet={{1, 1000, -1,},};
            for(int j=0; j<i; j++){
                //�󶥵�path[j][0]���㼯s2�����·��pointToSet[1]

                pointToSet[1][1]=1000; pointToSet[1][2]=j;
                for(int k=0; k<graph.length; k++){
                   if(s[k]==0 && graph[path[j][0]][k]<pointToSet[1][1]){
                        pointToSet[1][1]=graph[path[j][0]][k];
                        pointToSet[1][0]=k;
                    }
                }
                pointToSet[1][1]=pointToSet[1][1]+path[j][1];
                if(pointToSet[1][1]<setToSet[0][1]){
                    setToSet[0]=pointToSet[1];
                }
            }
            
            //�Ƚ�pointToSet[0]��setToSet[0]������С�ߣ���Ϊpath[i]ֵ֮

            if(pointToSet[0][1]<setToSet[0][1])
                path[i]=pointToSet[0];
            else
                path[i]=setToSet[0];
                
            s[path[i][0]]=1; //�Ѷ��㻮Ϊ�������·�յ�֮�㼯

        }
    }

    int[][] getPath()
    {
        return path;
    }
}
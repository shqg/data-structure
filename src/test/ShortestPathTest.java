package test;

/* Single-Source Shortest Paths (Dijkstra's algorithm)
 * 输入：n个顶点的有向带权图G，表述为n*n矩阵。
 * 起始点:v0 其取值范围为0~n-1。
 * 输出：最短路径及其长度，表述为一个二维数组path[n-1][3]，每个数组元素由三个数据项组成，其中path[i][0]代表此最短路径之终点，path[i][1]代表此最短路径之长度，path[i][2]代表此最短路径终点之前趋。
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
           System.out.println("源点：" + v + "; 终点：" + path[i][0] + 
           "; 长度：" + path[i][1] + "; 终点前趋：" + path[i][2]);
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
        
        //按路径值从小到大的顺序求解各条最短路径

        for(int i=0; i<graph.length-1; i++){
            //求v到集合s2的最短路径pointToSet[0]

            int[][] pointToSet={{1, 1000, -1,},{1, 1000, -1,},};
            for(int j=0; j<graph.length; j++){
                if(s[j]==0 && graph[v][j]<pointToSet[0][1]){
                    pointToSet[0][1]=graph[v][j];
                    pointToSet[0][0]=j;
                }
            }
            
            //求集合s1到集合s2的最短路径setToSet[0]

            int[][] setToSet={{1, 1000, -1,},};
            for(int j=0; j<i; j++){
                //求顶点path[j][0]到点集s2的最短路径pointToSet[1]

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
            
            //比较pointToSet[0]及setToSet[0]，求其小者，作为path[i]之值

            if(pointToSet[0][1]<setToSet[0][1])
                path[i]=pointToSet[0];
            else
                path[i]=setToSet[0];
                
            s[path[i][0]]=1; //把顶点划为已求最短路终点之点集

        }
    }

    int[][] getPath()
    {
        return path;
    }
}
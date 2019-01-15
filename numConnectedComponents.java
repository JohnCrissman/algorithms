// Implementation of the numConnectedComponents method
// This will give us the number of connected components we have or the number of groups that are completely disconnected from other groups.  Each group has atleast one thing/entity in it.
// 
// John Crissman

public class numConnectedComponents
{
   public static void main(String[] args)
   {
      // creating the infinity
      final int INF = 999999999;
      int n = 6;
      
      // This graph has 1 connected component
      int[][] W = {{0,0,0,0,0,0,0},
                   {0,0,10,15,INF,INF,12},
                   {0,10,0,20,INF,13,9},
                   {0,15,20,0,18,8,INF},
                   {0,INF,INF,18,0,INF,10},
                   {0,INF,13,8,INF,0,8},
                   {0,12,9,INF,10,8,0}};
      
      // This graph has 3 connected components            
      int[][] C = {{0,0,0,0,0,0,0,0,0},
                   {0,0,10,INF,INF,INF,INF,INF,INF},
                   {0,10,0,20,INF,INF,INF,INF,INF},
                   {0,INF,20,0,INF,INF,INF,INF,INF},
                   {0,INF,INF,INF,0,5,INF,INF,INF},
                   {0,INF,INF,INF,5,0,6,INF,INF},
                   {0,INF,INF,INF,INF,6,0,INF,INF},
                   {0,INF,INF,INF,INF,INF,INF,0,4},
                   {0,INF,INF,INF,INF,INF,INF,4,0}};
      
      // This graph has 2 connected components           
      int[][] S = {{0,0,0,0,0,0,0},
                   {0,0,15,INF,11,INF,INF},
                   {0,15,0,7,8,INF,INF},
                   {0,INF,7,0,INF,INF,INF},
                   {0,11,8,INF,0,INF,INF},
                   {0,INF,INF,INF,INF,0,2},
                   {0,INF,INF,INF,INF,2,0}};
      
      // This graph has 1 connected component            
      int[][] M = {{0,0,0,0,0,0,0,0},
                   {0,0,1,1,1,1,1,1},
                   {0,1,0,1,1,1,1,1},
                   {0,1,1,0,1,1,1,1},
                   {0,1,1,1,0,1,1,1},
                   {0,1,1,1,1,0,1,1},
                   {0,1,1,1,1,1,0,1},
                   {0,1,1,1,1,1,1,0}};
                   
      int[] nearest = new int[n+1];
      int[] cost = new int[n+1];
      int m = 8;
      int[] Cnearest = new int[m+1];
      int[] Ccost = new int[m+1];
      int l = 7;
      int[] Mnearest = new int[l+1];
      int[] Mcost = new int[l+1];
      
      
      // The print statements below will output the number of connected components for the graphs above in order from top to bottom.
      System.out.println(prim(W,n,1,nearest,cost));
      
      System.out.println(prim(C,m,1,Cnearest,Ccost));
      
      System.out.println(prim(S,n,1,nearest,cost));
      
      System.out.println(prim(M,l,1,Mnearest,Mcost));
      
   }
   
   public static int prim(int[][]W, int n, int source, int[] nearest, int[] cost)
   {
      
      int[] myArray = new int[n+1];
      final int INF = 999999999;
      int [] dist = new int [n+1];
      boolean noMoreINF = false;
      int count = 0;
      boolean foundINF = true;
      
      while(foundINF == true)
      {
      
      int min = INF;
      
      
      int vnear = source;
      
      for(int i = 1; i <= n; i++)
      {
         dist[i] = W[source][i];
         nearest[i] = source;
      }
      
      
      
     
      for(int i = 1; i < n; i++)
      {
         for(int j = 1; j <= n; j++)
         {
            if(dist[j] < min && dist[j] != 0)
            {
               min = dist[j];
               vnear = j;
            }
         }
         
         cost[vnear] = dist[vnear];
         
         dist[vnear] = 0;
         for(int k = 1; k <= n; k++)
         {
            if(W[vnear][k] < dist[k])
            {
               dist[k] = W[vnear][k];
               nearest[k] = vnear;
            }
         }
         min = INF;
      }
      
      foundINF = false;
      
      for(int i = 1; i <= n; i++)
      {
         
         if(dist[i] != INF)
            myArray[i] = 1;
      
      }
      
      for(int i = 1; i <= n; i++)
      {
         if(dist[i] == INF && myArray[i] == 0)
         {
            foundINF = true;
            source = i;
         }   
         if(dist[i] == INF)
            foundINF = true;
         
      
      }
      
      if(foundINF == false)
      {
         count += 1;
         break;
      }
      else
         count++;
      
      boolean finished = true;
      for(int i = 1; i <= n; i++)
      {
         if(myArray[i] != 1)
            finished = false;   
       
      
      
      }
      
      if(finished == true)
      {
         
         break;
      }
         
   }
   return count;
}
}
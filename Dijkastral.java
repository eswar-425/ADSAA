import java.util.Scanner;
public class Dijkastral{
    static final int INF = 999;
    
    private static int chooseMinVertex(int[] dist,boolean[] s,int n){
        int minIndex = -1, min  = INF;
        for(int i=0;i < n;i++){
	    if(!s[i] && dist[i] < min){
	        min = dist[i];
	        minIndex = i;
	    }
	}
	return minIndex;
    }
    public static void shortestPaths(int v, int[][] cost, int[] dist, int n){
        boolean[] s = new boolean[n];
        for(int i=0;i<n;i++){
            dist[i] = cost[v][i];
        }
        s[v] = true;
        for(int num = 1; num < n+1; num++){
            int u = chooseMinVertex(dist,s,n);
            if(u == -1)
                break;
            s[u] = true;
        for(int w = 0;w < n; w++){
                if(!s[w] && dist[u] + cost[u][w] < dist[w])
                    dist[w] = dist[u] + cost[u][w];
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        int cost[][] = new int[n][n];
        
        System.out.println("Enter cost adjacency matrix (Use 999 for INF):");
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                cost[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();
        int[] dist = new int[n];
        
        
        shortestPaths(source,cost,dist,n);
        
        System.out.println("Shortest distance from source "+source+":");
        for(int i =0 ;i< n;i++)
            System.out.println("Vertex "+i+" : "+(dist[i] == INF ? "INF" : dist[i]));
    }
} 

output:
Enter the number of vertices: 5
Enter cost adjacency matrix (Use 999 for INF):
0 10 999 30 999
10 0 50 999 10
999 50 0 20 10
30 999 20 0 60
999 10 10 60 0
Enter source vertex: 0
Shortest distance from source 0:
Vertex 0 : 0
Vertex 1 : 10
Vertex 2 : 30
Vertex 3 : 30
Vertex 4 : 20
  

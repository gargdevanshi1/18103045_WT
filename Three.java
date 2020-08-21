import java.util.*;
public class Three{
	static class Edge{
		int src, dest, cost;
		Edge(int s, int d, int c){
			src = s;
			dest = d;
			cost = c;
		}
	}
	public static void print(String str){
		System.out.print(str);
	}
	public static String printShortestDistance(ArrayList<Edge> edges, int n, int src, int dest){
		int m = edges.size();
		int dist[] = new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[src] = 0;
		for(int i = 1;i<n;i++){
			for(Edge edge:edges){
				int u = edge.src;
				int v = edge.dest;
				int w = edge.cost;
				if(dist[u]!=Integer.MAX_VALUE&&dist[v]>dist[u]+w){
					dist[v] = dist[u]+w;
				}
			}
		}
		for(Edge edge:edges){
			int u = edge.src;
			int v = edge.dest;
			int w = edge.cost;
			if(dist[u] != Integer.MAX_VALUE && dist[u]+w<dist[v]){
				return "Negative weight cycle exists";
			}
		}
		return dist[dest]==Integer.MAX_VALUE?"No path":String.valueOf(dist[dest]);
	}
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	print("Number of vertices: ");
    	int n = sc.nextInt();
    	print("Number of edges: ");
    	int m = sc.nextInt();
    	ArrayList<Edge> edges = new ArrayList<Edge>(m);
    	print("Enter Source Destination Cost for all edges: \n");
    	for(int i = 0;i<m;i++){
    		edges.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
    	}
    	print("Source vertex:\n");
    	int src = sc.nextInt();
    	print("Destination vertex:\n");
    	int dest = sc.nextInt();
    	print("Shortest distance: "+printShortestDistance(edges,n,src,dest)+"\n");
    }   
                             
}
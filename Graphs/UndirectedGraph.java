import java.util.LinkedList;

class Graph{
	private int V;
	private  LinkedList<Integer> adjList[];
	Graph(int v){
		this.V=v;
		adjList=new LinkedList[v];
		for(int i=0;i<v;i++)
			adjList[i]=new LinkedList<>();
	}
	public void addEdge(int a,int b){
		adjList[a].add(b);
		adjList[b].add(a);
	}
	public void print(){
		for(int v=0;v<V;v++){
			System.out.println("Adjacency list of vertex "+v);
			System.out.print("head");
			for(Integer i:adjList[v])
				System.out.print("->"+i);
			System.out.println("\n");
		}
	}
}
class UndirectedGraph{
	public static void main(String[] args){
		int V=5;
		Graph graph=new Graph(5);
		graph.addEdge(0,1);
		graph.addEdge(0,4);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.print();
	}
}
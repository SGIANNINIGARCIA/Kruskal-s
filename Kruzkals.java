 /*
 * @author Sandro Giannini Garcia
 * Files: Driver.java, Kruzkals.java, Edge.java, graph.txt
 * 
 * Description: Implementation of Kruzkals algorithm.   
 *   
 */
import java.util.*;

public class Kruzkals{

	private PriorityQueue<Edge> edges;            //edges in the grapj
	private int[] cycle;                          //stores array size of vertices used for cycle checking           
	private int vertices;                         //number of vertices
	private ArrayList<Edge> graph;                //resulting graph

	/**  
	 * Instantiates class variables, sets every element in the array cycle to -1, calls the method algorithm
	 * @param priorityQueue<Edge> edges, int vertices  
	 */  
	public Kruzkals(PriorityQueue<Edge> edges, int vertices){
		this.edges = edges;   
		this.vertices = vertices;
		this.graph = new ArrayList<>();
		this.cycle = new int[vertices];

		for(int i = 0; i < vertices; i++){
			cycle[i] = -1;
		}

		algorithm();

	}
	/**  
	 * Checks if by the union of two vertices a cycle is created. int i represents the root of vertex one, 
	 * int j represents the root of the vertex two
	 * @param true if cycle is found, false otherwise    
	 */  
	private boolean isCycle(int i, int j){   
		i = findRoot(i - 1);
		j = findRoot(j - 1);
		if(i == j) {
			return true;
		}
		int totalElements = cycle[i] + cycle[j];
		if (cycle[i] >= cycle[j]) {
			cycle[i] = j;
			cycle[j] = totalElements;
		} else {
			cycle[j] = i;
			cycle[i] = totalElements;
		}
		return false;
	}
	/**  
	 * Finds the root of a given vertex, int s represents the vertex. returns the root of the vertex  
	 * @param int s
	 * @return int result
	 */  
	private int findRoot(int s){
		int result = s;

		while(cycle[result] > 0){
			result = cycle[result];
		}
		return result; 
	}
	/**  
	 * add edges to a graph starting from the edge with the lowest weight, until the resulting graph contains 
	 * vertices -  1. It only adds the edge if the method isCycle() returns false.
	 * Prints the edges that are being added to the resulting graph
	 */  
	private void algorithm(){
		int weight = 0;
		System.out.println("V E V");
		while(graph.size() != (vertices) - 1) {

			if(isCycle(edges.peek().getVertex(), edges.peek().getVertexDest()) == false) {
				Edge toBeAdded = edges.poll();
				weight = weight + toBeAdded.getEdge();
				graph.add(toBeAdded);
				System.out.println(toBeAdded.toString());
			} else {
				edges.poll();
			}
		}
		System.out.println("Total weight= " + weight);

	}
}

/**
 * @author Sandro Giannini Garcia
 * Files: Driver.java, Kruzkals.java, Edge.java, graph.txt
 * 
 * Description: Implementation of Kruzkals algorithm.   
 *   
 */

public class Edge implements Comparable<Edge> {
	private int vertex;
	private int edge; 
	private int vertexDest;

	public Edge(int vertex, int edge, int vertexDest){
		this.vertex = vertex;
		this.edge = edge;
		this.vertexDest = vertexDest; 
	}

	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	public void setEdge(int edge){
		this.edge= edge;
	}
	public void setVertexDest(int vertex){
		this.vertexDest = vertex;
	}
	public int getVertex(){
		return this.vertex;
	}
	public int getEdge(){
		return this.edge;
	}
	public int getVertexDest(){
		return this.vertexDest;
	}
	/**  
	* Overrides the method compareTo from the interface Comparable in order to sort the priorityqueue
	* @return the difference between edges 
	* @param Edge  
	*/  
	@Override
	public int compareTo(Edge comparestu) {
		int compareEdge=((Edge)comparestu).getEdge();

		return this.edge - compareEdge;

	}

	public String toString() {
		return this.vertex + " " + this.edge + " " + this.getVertexDest();
	}
}



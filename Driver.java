/**
 * @author Sandro Giannini Garcia
 * Files: Driver.java, Kruzkals.java, Edge.java, graph.txt
 * 
 * Description: Implementation of Kruzkals algorithm.   
 *   
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Driver {
	/**  
	* Reads graph file and parses graph file, creates edge objects based on the file, populates priorityqueue 
	* with the edge objects
	* @return the number of vertices   
	* @param PriorityQueue<Edge>   
	*/  
	public static int buildGraph(PriorityQueue<Edge> edges) throws IOException {      

		String currentLine;	    
		String[] fields;
		int size;

		Scanner in = new Scanner(new BufferedReader(new FileReader("graph.txt")));	

		currentLine = in.nextLine();
		fields = currentLine.split(" ");
		size = Integer.parseInt(fields[0]);


		while (in.hasNext()) {

			currentLine = in.nextLine();	         
			fields = currentLine.split(" "); 
			Edge edge = new Edge(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
			edges.offer(edge);
		}	

		in.close();
		return size;
	} 

	/**  
	* Intantiates a priorityqueue, populates it by calling builGraph, and creates a kruzkal object.     
	*/  
	public static void main(String[] args) throws IOException {

		PriorityQueue<Edge> edges = new PriorityQueue<Edge>() ;
		int size = buildGraph(edges);
		Kruzkals sort = new Kruzkals(edges, size);
	}
}

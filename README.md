# Kruskal-s
Kruskal’s algorithm is a minimum spanning tree algorithm, meaning it is and algorithm in which
its output is a subset of edges of a connected, edge-weighted undirected graph that connects
all the vertices together, without any cycles and with the minimum possible total edge weight.

The algorithm produces a subset of edges in which every vertex is visited at least once. It
selects these vertices by finding the next minimum value weight that does not forms a cycle,
hence why it is classified as a greedy algorithm. The initial set of vertices from where the subset
is to be constructed from is considered to be a forest of trees, since each vertex is considered to
be its own root until connected through an edge to another tree.

## Implementation

The implementations of the algorithm calls for the use of a data structure like a priority Queue,
in which the elements are ordered depending a criteria; the weight of the edge. When an edge
is evaluated to be added to the final graph, it is discarded, and the next available edge is going
to be the next edge with the lowest weight in the list of available edges.

The selection process of the next possible edge to be added is done by taking advantage of the
characteristics of the priority queue, and by implementing the Comparable interface. The
comparable interface allows to provide a criterion or a “priority” to the objects in the queue. In
the case of Kruzkal’s, the weight of the edge was used. We selected which edge was going to be
added to the subset by checking if by adding the edge, a cycle was formed. If no cycle was
formed, then the edge was added, else we discarded the edge.

We check for cycles by creating a “forest of trees”. We created an array with size equal to the number
of vertices and initialized each element to -1, meaning they are their own root. If two vertices
were to be connected, we would first check if the two elements are already in the same tree by
ensuring that their roots were different , if not we would check the root of both and assign the
index of the biggest root (the one containing more children) to the value stored in the index of
the smallest root. If the two vertices are on the same tree, then a cycle has been formed and
the edge cannot be added

## Result
Based on the graph provided in the .txt file, the output of the program, or resulting graph is the following
![alt text](https://github.com/SGIANNINIGARCIA/Kruskal-s/blob/master/kruskal.png?raw=true)




## Run
The program reads from a file the graph, the files's name is graph.txt. 


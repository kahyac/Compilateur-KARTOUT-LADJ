package util.graph;

import util.graph.*;
import util.intset.*;
import java.util.*;
import java.io.*;

public class ColorGraph {
    public  Graph          graph;
    public  int            vertexNb;
    private Stack<Integer> stack;
    public  IntSet         removed;
    public  IntSet         spill;
    public  int[]          color;
    public  int            colorNb;
    public  Node[]         int2Node;
    static  int            NOCOLOR = -1;

    public ColorGraph(Graph graph, int colorNb, int[] preColoredVertices){
	this.graph   = graph;
	this.colorNb = colorNb;
	stack        = new Stack<Integer>(); 
	vertexNb     = graph.nodeCount();
	color        = new int[vertexNb];
	removed      = new IntSet(vertexNb);
	spill        = new IntSet(vertexNb);
	int2Node     = graph.nodeArray();
	for(int v=0; v < vertexNb; v++){
	    int preColor = preColoredVertices[v];
	    if(preColor >= 0 && preColor < colorNb)
		color[v] = preColoredVertices[v];
	    else
		color[v] = NOCOLOR;
	}
    }


}

package com.algorithm;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-06
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    private Map<Vertex, List<Edge>> vertices ;

    public Graph() {
        vertices = new HashMap<Vertex, List<Edge>>();
    }

    private void addVertex(Vertex v) {
        if(!vertices.containsKey(v)) {
            vertices.put(v, new ArrayList<Edge>());
        }
    }

    public void addEdge(Edge e) {
        Vertex head = e.head;
        Vertex tail = e.tail;

        addVertex(e.head);
        addVertex(e.tail);

        vertices.get(e.tail).add(e);
        vertices.get(e.head).add(new Edge(e.head, e.tail, e.weight));
    }

    public List<Edge> getEdges(Vertex v) {
        return vertices.get(v);
    }

    public void caculateShortestPath(Vertex start) {

    }


}

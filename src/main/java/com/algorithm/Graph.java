package com.algorithm;



import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-06
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {
    private Map<String, Vertex> vertices ;
    private int MAX_DISTANCE = Integer.MAX_VALUE;

    public Graph() {
        vertices = new HashMap<String, Vertex>();
    }

    private void addVertex(Vertex v) {
        if(!vertices.containsKey(v.label)) {
            vertices.put(v.label, v);
        }
    }

    public void addEdge(Vertex tail, Edge e) {
        addVertex(tail);
        addVertex(e.head);
        vertices.get(tail.label).addEdge(e);
    }

    public Vertex getVertex(String label) {
        return vertices.get(label);
    }

    public Map<String, Vertex> getVertices() {
        return vertices;
    }

    public void caculateShortestPath(Vertex start) {
        Set<Vertex> V = new HashSet<Vertex>(vertices.values());
        Set<Vertex> S = new HashSet<Vertex>();

        Iterator<Vertex> vertexIterator = V.iterator();
        while(vertexIterator.hasNext()) {
            Vertex v = vertexIterator.next();
            v.distance = MAX_DISTANCE;
        }

        start = vertices.get(start.label);
        V.remove(start);
        S.add(start);
        start.distance = 0;

        while (V.size() > 0) {
            //find minimum edge
            Vertex min = null;
            for(Vertex s : S) {
                List<Edge> edges = s.getEdges();
                for(Edge e : edges) {
                    Vertex current = vertices.get(e.head.label);
                    if(V.contains(current)) {
                        if(current.distance > s.distance + e.weight) {
                            current.distance = s.distance + e.weight;
                        }
                        if(null == min || current.distance < min.distance) {
                            min = current;
                        }

                    }
                }
            }
            V.remove(min);
            S.add(min);
        }
    }
}

package com.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-06
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vertex {
    public String label;

    public Vertex(String label) {
        this.label = label;
        edges = new ArrayList<Edge>();
    }

    public int distance;
    public Vertex parent;

    private List<Edge> edges;


    public void addEdge(Edge e) {
        edges.add(e);
    }

    public List<Edge> getEdges() {
        return edges;
    }

    @Override
    public boolean equals(Object o) {
        Vertex other = (Vertex) o;
        if( o == null) return false;
        return other.label.equals(this.label);
    }

    @Override
    public int hashCode() {
        return this.label.hashCode();
    }
}

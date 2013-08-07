package com.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-06
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    public Vertex tail;
    public Vertex head;

    public int weight;

    public Edge(Vertex tail, Vertex head, int weight) {
        this.tail = tail;
        this.head = head;
        this.weight = weight;
    }
}

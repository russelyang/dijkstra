package com.algorithm;

/**
 * Created with IntelliJ IDEA.
 * User: ryang
 * Date: 2013-08-06
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Edge {
    public Vertex head;

    public int weight;

    public Edge(Vertex head, int weight) {
        this.head = head;
        this.weight = weight;
    }
}

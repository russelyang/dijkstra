package com.algorithm;

import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void testAddEdge()
    {
        Graph g = new Graph();

        Vertex head = new Vertex("s");
        Vertex tail = new Vertex("t");

        Edge edge = new Edge(head,tail, 3);

        g.addEdge(edge);

        List<Edge> headEdgs = g.getEdges(head);
        List<Edge> tailEdges = g.getEdges(tail);



        assertEquals(1, headEdgs.size());
        assertEquals(1, tailEdges.size());
        assertTrue(headEdgs.contains(edge));
        assertFalse(tailEdges.contains(new Edge(head,tail,3)));
    }

    /**
     *
     1 2,3 3,3
     2 3,1 4,2
     3 4,50
     4
     *
     */

    public void testShortestPath1() {
        Graph g = new Graph();
        g.addEdge( new Edge( new Vertex("1"), new Vertex("2"), 3));
        g.addEdge( new Edge( new Vertex("1"), new Vertex("3"), 3));
        g.addEdge( new Edge( new Vertex("2"), new Vertex("3"), 1));
        g.addEdge( new Edge( new Vertex("2"), new Vertex("4"), 2));
        g.addEdge( new Edge( new Vertex("3"), new Vertex("4"), 50));

        g.caculateShortestPath(new Vertex("1"));


    }
}

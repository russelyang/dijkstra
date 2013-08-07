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

        Edge edge = new Edge(head, 3);

        g.addEdge(tail,edge);


        assertEquals(1, g.getVertex("s").getEdges().size());
        assertEquals(1, g.getVertex("t").getEdges().size());
        assertTrue(g.getVertex("s").getEdges().contains(edge));
        assertFalse(g.getVertex("t").getEdges().contains(new Edge(tail,3)));
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

        Vertex one =  new Vertex("1");
        Vertex two =  new Vertex("2");
        Vertex three =  new Vertex("3");
        Vertex four =  new Vertex("4");

        g.addEdge( one, new Edge( two, 3));
        g.addEdge( one, new Edge( three, 3));
        g.addEdge( two, new Edge( three, 1));
        g.addEdge( two, new Edge( four, 2));
        g.addEdge( three, new Edge( four, 50));

        g.caculateShortestPath(new Vertex("1"));

        assertEquals(0, g.getVertex("1").distance);
        assertEquals(3, g.getVertex("2").distance);
        assertEquals(3, g.getVertex("3").distance);
        assertEquals(5, g.getVertex("4").distance);
    }

    /*
        1 2,8 3,15
        2 1,7 3,4 4,5
        3 1,12
        4 3,5
     */

    public void testShortestPath2() {
        Graph g = new Graph();

        Vertex one =  new Vertex("1");
        Vertex two =  new Vertex("2");
        Vertex three =  new Vertex("3");
        Vertex four =  new Vertex("4");

        g.addEdge( one, new Edge( two, 8));
        g.addEdge( one, new Edge( three, 15));
        g.addEdge( two, new Edge( one, 7));
        g.addEdge( two, new Edge( three, 4));
        g.addEdge( two, new Edge( four, 5));
        g.addEdge( three, new Edge( one, 12));
        g.addEdge( four , new Edge( three, 5));

        g.caculateShortestPath(one);

        assertEquals(0, g.getVertex("1").distance);
        assertEquals(8, g.getVertex("2").distance);
        assertEquals(12, g.getVertex("3").distance);
        assertEquals(13, g.getVertex("4").distance);
    }
}

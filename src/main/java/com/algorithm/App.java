package com.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Dijkstra shortest path." );
        if(args.length < 1) {
            System.out.println("please provide data file");
            System.exit(-1);
        }

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        Graph g = new Graph();

        try {
            String line = reader.readLine();
            while(line != null) {
                String[] splits = line.split("\t");
                Vertex tail = new Vertex(splits[0]);
                for(int i=1; i<splits.length; i++) {
                   String[] pair = splits[i].split(",");
                   g.addEdge(tail, new Edge(new Vertex(pair[0]), Integer.parseInt(pair[1])));
                }
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }

        System.out.println("number of vertices: " + g.getVertices().size());

        g.caculateShortestPath(new Vertex("1"));

        Integer[] labels = {7,37,59,82,99,115,133,165,188,197};
        String out = "";
        for(Integer label : labels) {
           out += g.getVertex(label.toString()).distance + ",";
        }
        System.out.println(out);
    }
}

package Run;


import calculate.Edge;
import calculate.KochFractal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KockEdge implements  Runnable  {

    private KochFractal koch;
    List<Edge> edges =  Collections.synchronizedList(new ArrayList());
    boolean busy = false;
    private double ax;
    private double ay;
    private double bx;
    private double by;
    private int level = 1;
    private float hue;



    public KockEdge(double ax, double ay, double bx, double by, float hue) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.hue = hue;
        busy = true;
        this.koch = new KochFractal(hue);
        busy = false;

    }

    @Override
    public void run() {
        busy  = true;
        koch.drawKochEdge(this.ax, this.ay, this.bx, this.by, this.level, this.edges);
        busy = false;
        System.out.println("Thread finished : "+ this.hue);

    }

    public synchronized void setlevel(int n){
        this.level = n;
    }

    public synchronized List<Edge> getEdges(){
        return edges;
    }

    public synchronized void clearEdges(){
        edges.clear();
    }

    public synchronized boolean isbusy(){
        return busy;
    }


}

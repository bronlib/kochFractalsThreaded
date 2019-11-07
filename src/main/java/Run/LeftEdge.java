package Run;

import calculate.Edge;
import calculate.KochFractal;
import calculate.KochManager;
import fun3kochfractalfx.FUN3KochFractalFX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeftEdge implements  Runnable {
    private KochFractal koch;
    private NotKochFractal notKoch;
    List<Edge> edges =  Collections.synchronizedList(new ArrayList());


    @Override
    public void run() {
            koch.generateLeftEdge(edges);
            notKoch.CountUp(1);

    }

    public List<Edge> getEdges(){
        return edges;
    }

    public void clearEdges(){
        edges.clear();
    }



    public LeftEdge(KochFractal kochFractal, NotKochFractal notKoch) {
        this.koch = kochFractal;
        this.notKoch = notKoch;


    }

}

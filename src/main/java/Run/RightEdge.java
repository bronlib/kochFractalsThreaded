package Run;

import calculate.Edge;
import calculate.KochFractal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RightEdge implements  Runnable {

    private KochFractal koch;
    private NotKochFractal notKoch;
    List<Edge> edges =  Collections.synchronizedList(new ArrayList());
    @Override
    public void run() {
            int nr = koch.getNrOfEdges();
            koch.generateRightEdge(edges);
            notKoch.CountUp(1);

    }

    public List<Edge> getEdges(){
        return edges;
    }

    public void clearEdges(){
        edges.clear();
    }

    public RightEdge(KochFractal kochFractal, NotKochFractal notKoch) {
        this.koch = kochFractal;
        this.notKoch = notKoch;

    }

}

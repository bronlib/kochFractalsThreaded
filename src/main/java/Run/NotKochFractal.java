package Run;

import calculate.Edge;
import calculate.KochFractal;
import calculate.KochManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotKochFractal {

    private int Counter;

    private KochManager kochManager;

    private KochFractal koch = new KochFractal(this);

    private BottomEdge bottomEdge = new BottomEdge(koch, this);
    private LeftEdge leftEdge = new LeftEdge(koch, this);
    private RightEdge rightEdge = new RightEdge(koch, this);

    private Thread bottomThread = new Thread(bottomEdge);
    private Thread leftThread = new Thread(leftEdge);
    private Thread rightThread = new Thread(rightEdge);



//    public void addEdge(Edge e) {
//
//    }

    public synchronized int CountUp(int Counting) {
        Counter += Counting;
        return Counter;
    }


         public boolean start() {

         bottomThread.run();
         leftThread.run();
         rightThread.run();

         return true;


     }

     public List<Edge> getEdges(){
        List<Edge> e = bottomEdge.getEdges();
        e.addAll(leftEdge.getEdges());
        e.addAll(rightEdge.getEdges());
        return e;
     }

     public void clearEdges(){
        bottomEdge.clearEdges();
        leftEdge.clearEdges();
        rightEdge.clearEdges();
     }

     public void setNextLvl(int nxt) {

        koch.setLevel(nxt);
     }


     public NotKochFractal(KochManager kochManager) {
         this.kochManager = kochManager;
     }

     public void stopThreads() {


     }




}

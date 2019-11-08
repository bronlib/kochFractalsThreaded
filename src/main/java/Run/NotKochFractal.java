package Run;

import calculate.Edge;
import calculate.KochManager;

import java.util.List;

public class NotKochFractal {

    private int Counter;

    private KochManager kochManager;

    private KockEdge bottomEdge = new KockEdge((1 - Math.sqrt(3.0) / 2.0) / 2, 0.75, (1 + Math.sqrt(3.0) / 2.0) / 2, 0.75,  1f / 3f);
    private KockEdge leftEdge = new KockEdge(0.5, 0.0, (1 - Math.sqrt(3.0) / 2.0) / 2, 0.75,  0f);
    private KockEdge rightEdge = new KockEdge((1 + Math.sqrt(3.0) / 2.0) / 2, 0.75, 0.5, 0.0, 2f / 3f);
//
//    private Thread bottomThread = new Thread(bottomEdge);
//    private Thread leftThread = new Thread(leftEdge);
//    private Thread rightThread = new Thread(rightEdge);



//    public void addEdge(Edge e) {
//
//    }



    public boolean start() {
        System.out.println("Startring threads");

        Thread bottomThread = new Thread(bottomEdge);
        Thread leftThread = new Thread(leftEdge);
        Thread rightThread = new Thread(rightEdge);


        bottomThread.start();
         leftThread.start();
         rightThread.start();

         while (bottomEdge.isbusy() && leftEdge.isbusy() && rightEdge.isbusy()){
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

        try {
            bottomThread.join();
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Threads finished");

         return true;


     }

     public List<Edge> getEdges(){
         System.out.println("getting edges");

        List<Edge> e = bottomEdge.getEdges();
        e.addAll(leftEdge.getEdges());
        e.addAll(rightEdge.getEdges());
        return e;
     }

     public void clearEdges(){
         System.out.println("clearing edges");

        bottomEdge.clearEdges();
        leftEdge.clearEdges();
        rightEdge.clearEdges();
     }

     public void setNextLvl(int nxt) {
        System.out.println("Setting next level to "+nxt);
        bottomEdge.setlevel(nxt);
        leftEdge.setlevel(nxt);
        rightEdge.setlevel(nxt);
     }


     public NotKochFractal() {

     }

     public void stopThreads() {

         System.out.println("Not stopping theads");

     }




}

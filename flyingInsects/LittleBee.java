package flyingInsects;

import java.util.ListIterator;

public class LittleBee extends FlyingInsect {
     double collectedPollen = 0;
     public int numberOfAntlers;
     private static final int TYPICAL_NR_OF_ANTLERS = 2;
     public LittleBee(int numberOfAntlers) {this.numberOfAntlers = numberOfAntlers;}
     public LittleBee() {this.numberOfAntlers = TYPICAL_NR_OF_ANTLERS;}
     public void sting() {
          System.out.println("Kleine Stechstech");
     }

     public void snooze () {
          System.out.println("snooooooooze");
     }
     public void fly() {System.out.println("brummmmmm");}

}

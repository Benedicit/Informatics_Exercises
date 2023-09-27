package flyingInsects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class InsectDemo {
    public static void main(String[] args) {
            FlyingInsect someInsect;
            someInsect = new FlyingInsect();
            someInsect.fly();
            System.out.println("---------------!");
            LittleBee maja = new LittleBee();
            LittleBee willi = new LittleBee();
            maja.collectedPollen = 150;
            willi.collectedPollen = 10;
            maja.sting();
            willi.snooze();
            System.out.println("---------------!");
            maja.fly();
            folienTesten test = new folienTesten();
            test.rechnen();

    }
}



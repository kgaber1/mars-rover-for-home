
/**
 * Write a description of class Runner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Runner
{
    public static void main(String[] args) {
        Rover r1 = new Rover("Jevin");  
        Rover r2 = new Rover("Kevin");  
        Rover r3 = new Rover("Elevan");
        
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        r1.rotate(3);
        r1.move(1);
        r1.rotate(3);
        System.out.println(r1);
        
        r2.rotate(1);
        r2.rotate(5);
        r2.move(2);
        r2.rotate(2);
        r2.move(5);
        System.out.println(r2);
        
        r3.move(1);
        System.out.println(r3);
        r3.move(1);
        r3.takePicture();
        r3.rotate(1);
        r3.takePicture();
        r3.move(4);
        r3.takePicture();
        r3.transmitPictures();
        System.out.println(r3);
        
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.attack(r3);
        r2.charge(100);
        System.out.println(r2);
        r2.moveTo(5, 10);
        System.out.println(r2);
        
        r3.move(3);
        r3.attack(r2);
        System.out.println(r3);
        r1.teleport(0,0);
        r1.moveTo(-3,4);
        System.out.println(r1);
        r1.goHome();
        System.out.println(r1);
    }
}

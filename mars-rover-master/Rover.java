
/**
 * Write a description of class Rover here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rover
{
    // instance variables
    private int x;
    private int y;
    private int dir;
    private String name;
    private boolean isAlive;
    private String direction;
    private int energy;
    private int numPics;
    public Rover(String name)
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.energy = 100;
        this.numPics = 0;
        this.name = name;
        this.isAlive = true;
    }
    
    public Rover(String name, int x, int y, int dir)
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.name = name;
        this.isAlive = true;
    }

    public void rotate(int rotation)
{
       dir = dir + rotation;
    if (dir >= 8) {
        dir = (dir % 8); 
    }
     else if (dir < 0); {
        dir = 8 - (Math.abs(dir) % 8);
    }      
       System.out.println(name + " is facing " + rotation);
}
    
private String getDirectionName() {
    if (dir == 0) {
    direction = "North";
}
 else if (dir == 1) {
    direction = "Northeast";
}
 else if (dir == 2) {
     direction = "East";
    }
 else if (dir == 3) {
 direction = "SouthEast";
}
 else if (dir == 4) {
 direction = "South";
}
 else if (dir == 5) {
 direction = "SouthWest";
}
 else if (dir == 6) {
 direction = "West";
}
  else if (dir == 7) {
 direction = "NorthWest";
}
return direction;
}

    public void move(int moveDistance) 
    {
        if (isAlive) {
            if (dir == 0) {
                y = y + moveDistance;
            }
                else if (dir == 1) {
                x = x + moveDistance;
                y = y + moveDistance;
            }
            else if (dir == 2) {
                x = x + moveDistance;
            }
            else if (dir == 3) {
                y = y - moveDistance;
                x = x - moveDistance;
            }
            else if (dir == 4) {
                y = y - moveDistance;
            }
            else if (dir == 5) {
                y = y - moveDistance;
                x = x + moveDistance;
            }
            else if (dir == 6) {
                y = x - moveDistance;
            }
            else if (dir == 7) {
                y = y + moveDistance;
                x = x - moveDistance;
            }
            System.out.println(this.name + " moved forward " + moveDistance + " units");
        }
        else {
            System.out.println(this.name + " can't move. It's ded.");
        }
    }
    
     public void moveTo(int x, int y) {
            rotate(-this.dir);
            move(y - this.y);
            rotate(2);
            move(x - this.x);
    }
    
    public void energypad()
    {
        if (x == 0 && y == 0);
        energy = 100;
    }
    
    public void numPics()
    {
        
        
    }
    
    public void kill(Rover other) {
        System.out.println(this.name + " shoots " + other.name + " with space lasers.");
        System.out.println(other.name + " goes 'beep beep aaaaaaakkkkkk!' and dies");
        
        other.isAlive = false;
    }
    
    public String toString() {
        return "Rover[name=" + name + ",x=" + x + ",y=" + y + 
               " dir=" + dir +  ",is facing= " + getDirectionName() + ",isAlive=" + isAlive + "]";
    }
}

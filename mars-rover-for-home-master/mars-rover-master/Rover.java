
/**
 * Write a description of class Rover here.
 *
 * @author (kEVIN GAber)
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
    private int numPics = 0;
    private boolean hasPower = true;
    private int maxPics = 10;
    private int health;
    private int damage;
    public Rover(String name) // name of rovers and their intital stats
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.energy = 100;
        this.health = 100;
        this.damage = 10;
        this.numPics = 0;
        this.name = name;
        this.isAlive = true;
    }
    
    public Rover(String name, int x, int y, int dir) // name of rovers and their intital stats
    {
        this.x = 0;
        this.y = 0;
        this.dir = dir;
        this.name = name;
        this.energy = 100;
        this.health = 100;
        this.damage = 10;
        this.numPics = 0;
        this.isAlive = true;
    }

     
    /** the program checks to see if the rover is alive and had energy and then turns the rover in whichever direction is inputted. param 
     * @param dir tells the direction of the rover 
     * @param rotation gives the direction value of the rover to turn int direction.
     */
    public void rotate(int rotation) { 
        if(hasPower){
            if(isAlive) {
                this.dir += rotation;
                spendEnergy();
                if (this.dir >= 8) {
                    this.dir = (dir % 8);
                    System.out.println(name + " turned to the right " + Math.abs(rotation) + " to face " + getDirectionName() + "."); 
                } else if (this.dir < 0) {
                    this.dir = 8 - (Math.abs(dir) % 8);
                    System.out.println(name + " turned to the left " + Math.abs(rotation) + " to face " + getDirectionName() + "."); 
                } else {
                    System.out.println(name + " turned to the right " + Math.abs(rotation) + " to face " + getDirectionName() + "."); 
                }
            }
            else {
                System.out.println("ERr0r: " + name + " cannot rotate while dead!");
            }
        } else System.out.println(this.name + " has no power!");
    }  
    
    /** this function allows the rover to consume energy doing tasks.
     * @param energy allows the rover to do a certain amount of commands before recharging
     * @param hasPower gives the rover the condition if he has energy he can do tasks
     */
        public void spendEnergy() { 
        energy -= 5;
        if (energy <= 0) {
            energy = 0;
            hasPower = false;
        }
    }
    
    /** this allows the program to output a cardinal direction onto the screen given the input the computer received and calculated in the rotation function.
     * directionArray are the cardinal directions allowed in the rover.
     */
    private String getDirectionName() { 
          String[] directionArray = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
        return directionArray[this.dir];
    }

    /** these are the formulas to move in the 8 cardinal directions 0 being north 7 being north east
     * @param moveDistance is the distance inputed added to the corresponding direction to give a position of x and y.
     */
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
            System.out.println(name + " moved " + moveDistance + " units in direction " + getDirectionName() + ".");
        }
    }
    
    /** this function takes an integer and rotates the rover to move to the given point as efficiently as possible
     * @param moveTo is the function which takes the x and y coordinate and moves the rover as efficiently as possible to the desired x and y value.
     */
     public void moveTo(int x, int y) { 
            rotate(-this.dir);
            move(y - this.y);
            rotate(2);
            move(x - this.x);
    }
    
    /** this function initiates the rover to take the most efficient way back home using the moveTo function above.
     * @param moveTo is the function which takes the x and y coordinate and moves the rover as efficiently as possible to the desired x and y value.
     * @param goHome makes the rover efficiently move to the coordinate (0,0)
     */
    public void goHome() { 
        moveTo(0, 0);
        System.out.println(name + " went home ");
    }
    
    
    /** this function allows the robot to teleport anywhere as long as it had energy and is alive.
     * @param teleport this function takes an x and a y coordinate and uses the robots energy to take it to the destination.
     */
    public void teleport (int x, int y) { 
        spendEnergy();
        if(hasPower) {
            if(isAlive) {
                this.x = x;
                this.y = y;
                System.out.println(name + " has teleported to " + x + ", " + y + ".");
                spendEnergy();
            } else {
                System.out.println (name + " cannot teleport while dead!");    
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    /** this function allows the robot to charge the energy of the robot to 100%
     * @param amps - the amount of charge given to the rover up to 100%.
     */
        public void charge(int amps) { 
        if (!(energy > 100 && !((amps + energy) > 100))) {
            energy += amps;
            System.out.println(name + " is charging for " + amps + " power!");
        } else {
            System.out.println(name + " cannot charge past their limit of ");
        }
    }
    
     /** this function allows the rover to take a selfie in his current spot and the direction he is facing.
     * @param Numpics - the amount of pictures you can take.
     * @param maxPics - the maximum amount of pictures the rover can hold.
     */
       public void takePicture() { 
        if(hasPower) {
            if(isAlive) {
                if (numPics <= maxPics) {
                this.numPics++;
                System.out.println(name + " took a selfie at " + "[" + x + ", " + y + "] facing " + getDirectionName() + ".");
                } else  System.out.println(name + " has taken wayyy to many selfies!");
            } else {
                System.out.println(name + " is dead!");
            }
    }
    }
    
    /** this function allows the rover to transmit his pictures back to earth.
     * @param transmitPictures - resets the numPics to 0 and send the photos to earth.
     */
      public void transmitPictures() { 
        this.numPics = 0;
        System.out.println(name + "'s" + " photos have been sent to earth!");
    }
    
     /** this function removes the other rover and makes the robot dead.
     * @param isAlive - is alive is the condition of the rover if he is alive or not 
     */
    public void kill(Rover other) {
        System.out.println(this.name + " shoots " + other.name + " with space lasers.");
        System.out.println(other.name + " goes 'beep beep aaaaaaakkkkkk!' and dies");
        
        other.isAlive = false;
    }
    
    /** this function allows rovers to fight other robots while spending energy to do so, the initial rover will deal 10 damage to the other rover 
     * @param attack - allows the rover to hit the other rover for -10 and diminishes it from the other rovers health at the cost of energy.
     */
    public void attack(Rover other) { 
        spendEnergy();
        if(hasPower) {
            if(this.isAlive && other.isAlive == false) {
                System.out.println(this.name + " tried to kill " + other.name + ", but it is already dead.");
            } else if (isAlive) {
                spendEnergy();
                other.health -= this.damage;
                System.out.println(this.name + " has attacked " + other.name + " for " + damage + 
                " damage.\n >" + other.name + " current health: " + other.health);
                checkHealth();
                other.checkHealth();
                
            }
            else {
                other.health-= this.damage;
                System.out.println(this.name + " has killed " + other.name + " from beyond the grave!");
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    /** this function allows the rover to check if the rover has died
     * @param isAlive - does not let the rover do any more commands because it is not alive
     */
    public void checkHealth() { 
        if (this.health <= 0) {
           this.health = 0;
           this.isAlive = false; 
           System.out.println(name + " has died!");
        }
    }
    
    /** this allows the rovers stats to be displayed on the console.
     */
    public String toString() { //this allows the rovers stats to be displayed on the console.
        return "Rover[Name: " + name + ", x: " + x + ", y: " + y + ", dir: " + dir + ", picsTaken: " +  numPics + ", isAlive: " + isAlive + 
        "]\n [Health: " + health + " Energy: " +  energy + "]";
    }
}

   

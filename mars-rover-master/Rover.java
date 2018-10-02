
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
    private int homeY;
    private int homeX;
    private int y;
    private int dir;
    private String name;
    private boolean isAlive;
    private int energy;
    private int numPics = 0;
    private boolean hasPower = true;
    private int maxPics = 10;
    private int health;

    
    /** the function creates a rover
     * @param name  name of the rover being created
     */
    public Rover(String name) // name of rovers and their intital stats
    {
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.energy = 200;
        this.health = 100; 
        this.numPics = 0;
        this.name = name;
        this.isAlive = true;
    }
    
    /** the function creates a rover
     * @param name  name of the rover being created
     */
    public Rover(String name, int x, int y, int dir) // name of rovers and their intital stats
    {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.name = name;
        this.energy = 200;
        this.health = 100;
        this.numPics = 0;
        this.isAlive = true;
    }

     
    /** the program checks to see if the rover is alive and had energy and then turns the rover in whichever direction is inputted. 
     * @param  rotation dir tells the direction of the rover 
     * @param  rotation gives the direction value of the rover to turn int direction.
     */
    public void rotate(int rotation) {
        int energyRequired = 5;
        
        if(energy >= energyRequired){
            if(isAlive) {
                this.dir += rotation;
                spendEnergy(energyRequired);
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
     * @param  energy  allows the rover to do a certain amount of commands before recharging
     * @param  hasPower  gives the rover the condition if he has energy he can do tasks
     * @param spendEnergy  consumes energy to do tasks
     */
    public void spendEnergy(int amount) { 
        energy -= amount;
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
     * moveDistance is the distance inputed added to the corresponding direction to give a position of x and y.
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
     * moveTo is the function which takes the x and y coordinate and moves the rover as efficiently as possible to the desired x and y value (even if it means driving backwards).
     */
     public void moveTo(int x, int y) { 
        int energyRequired = ((x + y));
        if((energy >= energyRequired)) {
            rotate(-this.dir);
            move(y - this.y);
            rotate(2);
            move(x - this.x);
            spendEnergy(energyRequired);
            System.out.println( name + " has reached their destination ");
        }else {
            System.out.println( name + "has no power");
        }
    }
    
    /** this function initiates the rover to take the most efficient way back home using the moveTo function above.
     * moveTo is the function which takes the x and y coordinate and moves the rover as efficiently as possible to the desired x and y value.
     * goHome makes the rover efficiently move to the coordinate (0,0)
     */
    public void goHome(int homeX, int homeY) { 
        moveTo(homeX, homeY);
        System.out.println(name + " went home to his base at " + "[" + homeX + "," + homeY + "]");
    }
    
    /** this function allows the robot to teleport anywhere as long as it had energy and is alive.
     * teleport this function takes an x and a y coordinate and uses the robots energy to take it to the destination.
     */
    public void teleport (int x, int y) { 
         int energyRequired = (2*(x + y));
        if((energy >= energyRequired)) {
            if(isAlive) {
                this.x = x;
                this.y = y;
                System.out.println(name + " has teleported to " + x + ", " + y + ".");
                spendEnergy(energyRequired);
            } else {
                System.out.println (name + " cannot teleport while dead!");    
            }
        } else {
            System.out.println(this.name + " has no power!");
        }
    }
    
    /** this function allows the robot to charge the energy of the robot to 100%
     * amps - the amount of charge given to the rover up to 100%.
     */
        public void charge(int amps) { 
       if (isAlive) {
          if (((energy < 100) && ((amps + energy) < 100))) {
            amps -= Math.abs(energy);
            energy += Math.abs(amps);
            
            System.out.println(name + " is charging for " + amps + " power!");
         } 
         else {
            System.out.println(name + " cannot charge past their limit of 100, " + name + " is charging to max power!");
            energy = 100;
          }
       }
    }
    
     /** this function allows the rover to take a selfie in his current spot and the direction he is facing.
     * Numpics - the amount of pictures you can take.
     * maxPics - the maximum amount of pictures the rover can hold.
     * getDirectionName() -  prints out the direction the rover is facing.
     */
       public void takePicture() { 
        if(hasPower) {
            if(isAlive) {
                if (numPics <= maxPics) {
                    this.numPics++;
                    System.out.println(name + " took a selfie at " + "[" + x + ", " + y + "] facing " + getDirectionName() + ".");
                } else {
                    System.out.println(name + " has taken wayyy to many selfies!");
                }
            } else {
                System.out.println(name + " is dead!");
            }
        }
    }
    
    /** this function allows the rover to transmit his pictures back to earth.
     * transmitPictures - resets the numPics to 0 and send the photos to earth.
     */
      public void transmitPictures() { 
        System.out.println(name + "'s " +  numPics + " selfies have been sent to earth!");
         this.numPics = 0;
    }
    
     /** this function removes the other rover and makes the robot dead.
     * isAlive - is alive is the condition of the rover if he is alive or not 
     */
    public void kill(Rover other) {
        System.out.println(this.name + " finishes " + other.name + " with long sticks.");
        System.out.println(other.name + " goes 'beep beep aaaaaaakkkkkk!' and explodes");
        
        other.isAlive = false;
    }
    
    /** this function allows rovers to fight other robots while spending energy to do so, the initial rover will deal a random damage value to the other rover 
     *  attack - allows the rover to hit the other rover for -10 and diminishes it from the other rovers health at the cost of energy.
     */
    public void attack(Rover other) { 
        int damage = ((int)(15*Math.random()));
        int energyRequired = (2*(1 + damage));
        spendEnergy((2*(1 + damage))); 
        if((energy >= energyRequired)) {
            if(this.isAlive == true && other.isAlive == false) {
                System.out.println(this.name + " tried to kill " + other.name + ", but the rover is already dead.");
            } else if (isAlive) {
                
                 ;
                other.health -= damage;
                System.out.println(this.name + " has attacked " + other.name + " for " + damage + 
                " damage.\n >" + other.name + " current health: " + other.health);
                checkHealth();
                other.checkHealth();
            }
            else {
                other.health-= damage;
                System.out.println(this.name + " has killed " + other.name + " from beyond the grave!");
            }
        } else System.out.println(this.name + " has no power!");
    }
    
    /** this function allows the rover to check if the rover has died
     * isAlive - does not let the rover do any more commands because it is not alive
     */
    public void checkHealth() { 
        if (this.health <= 0) {
           this.health = 0;
           this.isAlive = false; 
           System.out.println(name + " has died! ");
        }
    }
    
    /** this allows the rovers stats to be displayed on the console.
     */
    public String toString() { //this allows the rovers stats to be displayed on the console.
        return "Rover[Name: " + name + ", x: " + x + ", y: " + y + ", dir: " + dir + ", picsTaken: " +  numPics + ", isAlive: " + isAlive + 
        "]\n [Health: " + health + " Energy: " +  energy + "]";
    }
}

   

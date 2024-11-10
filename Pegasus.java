import java.util.ArrayList;

public class Pegasus implements Contract {
    
    double size;
    ArrayList<String> inventory;
    double x;
    double y;
    int energylevel;
    String name;

    /**
     * constructor for the pegasus 
     * @param name name of the pegasus 
     */
    Pegasus(String name){
        this.name=name;
        this.size=2;
        this.x=0;
        this.y=0;
        this.energylevel=10;
        this.inventory=new ArrayList<String>(0);
    }

    /**
     * method that adds items to the inventory
     * @param item the item to be added to the inventory
     */
    public void grab(String item){
        this.inventory.add(item);
        System.out.println("you have added"+item+"to your innventory");
    }

    /**
     * method that removes the specified item from the innventory
     * @param item the item to be removed
     * @return the name of the item that was removed 
     */
    public String drop(String item){
        if (this.inventory.contains(item)){
            this.inventory.remove(item);
            return item;
        } else{
            System.out.println("this item is not in your innventory try grabbing it first");
            return item;
        }
    }

    /**
     * method that prints a statement about where the item is located in the inventory 
     * @param item the item to be examined
     */
    public void examine(String item){
        if (inventory.contains(item)){
            System.out.println(item+"is located at index"+this.inventory.indexOf(item));
        } else {
            System.out.println("sorry"+ item+"is not in your inventory");
        }
    }
    
    /**
     * uses the specifed item to spread magical joy 
     * @param item the item that you want to use
     */
    public void use(String item){
        drop(item);
        this.energylevel=0;
        System.out.println("you have used all of your energy and"+item+"to spread magical joy! go rest now");
    }

    /**
     * method that changes the x position of the pegasus depending on the inputed direction
     * @param direction the direction you want to walk
     * @return boolean true if movement was successful and false otherwise 
     */
    public boolean walk(String direction){
        direction = direction.toUpperCase();
        if(this.y==0){
            if (energylevel>0){
                if (direction.equals("LEFT")){
                    this.x=x-1;
                    System.out.println("you are at position"+this.x+","+this.y);
                    this.energylevel=energylevel-1;
                    System.out.println("your energy level is"+this.energylevel);
                    return true;
                } else if (direction.equals("RIGHT")){
                    this.x=x+1;
                    System.out.println("you are at position"+this.x+","+this.y);
                    this.energylevel=energylevel-1;
                    System.out.println("your energy level is"+this.energylevel);
                    return true;
                } else{
                    System.out.println("this in an invalid direction for this method, try left or right");
                    return false;
                }
            } else{
                System.out.println("you are out of energy try resting");
                    return false;
            }
        } else{
            System.out.println("to walk you must be on the ground, try flying to position y=0 first");
            return false;
        }
    }
    
    /**
     * method that allows the user to fly to the specified point
     * @param x the x coordinate that you want to fly to 
     * @param y the y coordinate that you want to fly to 
     */
    public boolean fly(int x, int y){
        if (this.energylevel>1){
            this.x=x;
            this.y=y;
            System.out.println("your current position is"+"("+x+","+y+")");
            return true;
        } else{
            System.out.println("you don't have enough energy, try resting");
            return false;
        }
    }

    /**
     * method that allows you to shrink the size of your pegasus 
     * @return the current size of the pegasus
     */
    public Number shrink(){
        if (this.energylevel>0){
            if(this.size>1){
                this.size=size-1;
                System.out.println("your new size is"+size);
                this.energylevel=energylevel-1;
                System.out.println("your energy level is"+this.energylevel);
            } else {
                System.out.println("you are too small to shrink try growing first");
            }
        } else {
            System.out.println("your energy level must be at least one to shrink try resting first");
        }
        return size;
    }

    /**
     * method that allows you to enlarge your pegasus 
     * @return the current size of the pegasus
     */
    public Number grow(){
        if (this.energylevel>0){
            if(this.size<3){
                this.size=size+1;
                System.out.println("your new size is"+size);
                this.energylevel=energylevel-1;
                System.out.println("your energy level is"+this.energylevel);
            } else {
                System.out.println("you are too large to grow try shrinking first");
            }
        } else {
            System.out.println("your energy level must be at least one to shrink try resting first");
        }
        return size;
    }
    
    /**
     * method that restores the energy level of your pegasus to full, 10 
     */
    public void rest(){
        this.energylevel=10;
    }
        
    /**
     * method that moves you back to the coordinates (0,0)
     */
    public void undo(){
        this.x=0;
        this.y=0;
    }

    public static void main(String[] args) {
        Pegasus mypegasus=new Pegasus("meow");
        System.out.println(mypegasus.energylevel);
    }

}

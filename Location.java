import java.util.ArrayList;

import javax.management.RuntimeErrorException;
public class Location {
    
    protected String name;
    protected String address;
    Borough borough;
    ArrayList<Pioneer> pioneers;
    Location left;
    Location right;
    

    public Location (String name, String address, Borough borough){
        this.name = name;
        this.address = address;
        this.borough = borough;
        this.pioneers = new ArrayList<>();
    }


    public Location goLeft(){
        return this.left;
    } 

    public Location goRight(){
        return this.right;
    }

    public void printLocation(){
        System.out.println("You are now in the " + this.name + "!");
        
    }

    public void printPioneers(){

        if(this.pioneers.size() > 0){
            for (Pioneer p: this.pioneers){
                System.out.println(p.getName() + "is here!");

            }

        }
        

        else {
            System.out.println("There is no-one here! Go somewhere else. Click L for left and R for right");
        }

        
    }

    public boolean moveIn(Pioneer p){
        if (this.pioneers.contains(p)){
            throw new RuntimeException(p + "is already in this location!"); // Already here
        }  //Checks for beef
            for (Pioneer a: p.Beefs.keySet()){
                if(this.pioneers.contains(a)){
                    System.out.println(p + " says: I am not going there because " + a + "is already there!");
                    return false; 
                }
            }
            //Moves pioneer
            this.pioneers.add(p);
            if (p.getLocation() != this){
                p.getLocation().moveOut(p);
            }
            p.setLocation(this);
            return true;

    }

    public void talkTo(Pioneer p){
        if (this.pioneers.contains(p)){
            System.out.println(p.getBio());

        }
        else {
            System.out.println("That pioneer is not here");
        }
    }

    public void moveOut(Pioneer p){
        if (this.pioneers.contains(p)){
            this.pioneers.remove(p);
        }   else {
            throw new RuntimeException("Can't remove" + p + "from this location!");
        }

    }

    public void setLeft(Location l){
        this.left = l;
    }
    public void setRight(Location r){
        this.right = r;

    }

    public String toString(){
        return name;
    }


    
}

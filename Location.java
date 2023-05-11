import java.util.ArrayList;

import javax.management.RuntimeErrorException;
public class Location {
    
    protected String name;
    protected String address;
    Borough borough;
    ArrayList<Pioneer> party_participants;
    Location left;
    Location right;
    

    public Location (String name, String address, Borough borough){
        this.name = name;
        this.address = address;
        this.borough = borough;
        this.party_participants = new ArrayList<>();
    }




    public Location goLeft(){
        return this.left;
    } 

    public Location goRight(){
        return this.right;
    }

    public boolean moveIn(Pioneer p){
        if (this.party_participants.contains(p)){
            throw new RuntimeException(p + "is already in this location!"); // Already here
        }  //Checks for beef
            for (Pioneer a: p.Beefs){
                if(this.party_participants.contains(a)){
                    System.out.println(p + " says: I am not going there because " + a + "is already there!");
                    return false; 
                }
            }
            //Moves pioneer
            this.party_participants.add(p);
            p.getLocation().moveOut(p);
            p.setLocation(this);
            return true;

    }

    public void moveOut(Pioneer p){
        if (this.party_participants.contains(p)){
            this.party_participants.remove(p);
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


    
}

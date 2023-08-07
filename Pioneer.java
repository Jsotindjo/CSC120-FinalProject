import java.util.ArrayList;
import java.util.Hashtable;

public class Pioneer {
    
    public String name;
    public String stage_name;
    public String bio;
    public Hashtable<Pioneer, Beef> Beefs;
    public String element;
    private Location currentLocation;

    public Pioneer( String name, String stage_name, String element, String bio, Location currentLocation){
        this.name = name;
        this.stage_name = stage_name;
        this.element = element;
        this.bio = bio;
        this.currentLocation = currentLocation;
        this.Beefs = new Hashtable<> ();


    }

    public Location getLocation(){
        return this.currentLocation;
    }

    public void setLocation(Location newLocation){
        this.currentLocation = newLocation;

    }
 
    public String getName(){
        return this.stage_name + " AKA " + this.name;
    }


    public String getElement(){
        return this.element;
    }

    public String getBio(){
        return this.bio;
    }

    public void addAntagonist(Pioneer p, Beef b){
        this.Beefs.put(p,b);
    }

    public void resolveBeef (Pioneer p, Beef b){
        this.Beefs.remove(p, b);
        // public boolean to tell you if it is right
    }




    /*Pioneers that I plan to use are Lee Quiones, Sha Rock, DJ Kool Herc, Ana "Rokafella" Garcia, Crazy Legs, MC Lyte */
    /* Locations: 1520 Segwick Ave (Bronx), Lower East Side (Manhattan), South Bronx, Inwood (Manhattan), East Flatbush (Brooklyn), Queens  */


}


import java.util.ArrayList;

public class Pioneer {
    
    public String name;
    public String bio;
    ArrayList<Pioneer> Antagonists;

    public Pioneer( String name, String bio){
        this.name = name;
        this.bio = bio;
        ArrayList<Pioneer> Antagonists = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getBio(){
        return this.bio;
    }

    public void addAntagonist(Pioneer p){
        this.Antagonists.add(p);
    }

    public void resolveBeef (Pioneer p){
        this.Antagonists.remove(p);
    }


}


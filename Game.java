import java.awt.*;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void instructions() {
        System.out.println("Congrats! You've been invited to the grand 50th anniversary of Hip-Hop Celebration.");
        System.out.println("Remember that there are 5 main elements of Hip-Hop: Dance, DJing, Mcing, Graffiti, and Knowledge.");
        System.out.println("Your job is to gather 1 pioneer of each of the 5 elements of Hip-Hop at the party together.");
    }



    public static void main(String[] args) {

        //* Creates frame with flyer */
        Visuals img = new Visuals();
        JFrame f = new JFrame();
        f.add(img);
        f.setSize(450,650);
        f.setVisible(true);


        instructions();


        Scanner input = new Scanner(System.in);


        //Creates the locations

        Location Party = new Location("DJ Kool Herc's Party Location", "1520 Sedgewick Avenue", Borough.The_Bronx);
        Location Lyte_House = new Location("Lyte_House", "Mind Your Business", Borough.Brooklyn);
        Location Da_Pink_House = new Location("Da Pink House", "Somewhere in Astoria", Borough.Queens);
        Location Campbell_Cave = new Location("The Campbell Cave", "Somewhere in Staten Island", Borough.Staten_Island);
        Location Crazy_House = new Location("Crazy_House", "Harlem", Borough.Manhatttan);

        Party.setLeft(Da_Pink_House);
        Lyte_House.setLeft(Campbell_Cave);
        Campbell_Cave.setLeft(Da_Pink_House);
        Da_Pink_House.setLeft(Campbell_Cave);
        Crazy_House.setLeft(Lyte_House);

        Party.setRight(Crazy_House);
        Lyte_House.setRight(Crazy_House);
        Da_Pink_House.setLeft(Party);
        Campbell_Cave.setLeft(Lyte_House);
        Crazy_House.setLeft(Party);

        Pioneer DJ_Kool_Herc = new Pioneer("Clive Campbell", "DJing", "DJ Kool aka Clive Campbell is often considered the grandfather of Hip-Hop. He and his sister Cindy Campbell threw the Back 2 School Jam on August 11th of 1973 which is often reffered to as the birth of Hip-Hop. ", Party);
        Pioneer MC_Lyte = new Pioneer("Lana Michele Moorer", "MCing", "MC Lyte is a female pioneer of Hip-Hop. She was the first female rapper to release a full album. ", Lyte_House);
        Pioneer Crazy_Legs = new Pioneer("Richard Colón", "Dance", "Crazy Legs is a Puerto Rican B-Boy, and he was present of the Rock Steady Crew.", Crazy_House);
        Pioneer Lady_Pink = new Pioneer("Sandra Fabara", "Graffiti", "Lady Pink is a female Ecuadorian-American graffiti artist.", Da_Pink_House);
        Pioneer Cindy_Campbell = new Pioneer("Cindy Campbell", "Knowledge", "Cindy Campbell is a woman with many skills. She also happens to be the sister of Clive Campbell, and she hosted the Back 2 Jam", Campbell_Cave);

        String [] Cindy_Options = {"Have a good cry about it", "Have a conversation about the situation", "Silently fume about it."};
        Beef Cindy_Beef = new Beef("Cindy is mad at her brother because he took all the fame for the Back 2 School Jam in 1973", 1, Cindy_Options);
        String [] Pink_Options = {"Help Cindy make a new and better mural", "Hack Crazy Legs' Youtube and erase a video", "Tell her it is not that big of a deal"};
        Beef Pink_Beef = new Beef("Lady Pink is upset with Crazy Legs because he ruined one of her murals while breaking", 0, Pink_Options);
        String [] Crazy_Options = {"Make him a sandwich that is not as good", "Tell him to get over it", "Get MC Lyte to apologize with tears"};
        Beef Crazy_Beef = new Beef("MC Lyte ate Crazy Legs' favorite sandwich last week", 2, Crazy_Options);
        String [] Lyte_Options = {"Give her Cindy's long lost apology letter", "Give her a hug", "Have an unproductive conversation"};
        Beef Lyte_Beef = new Beef("Cindy left me to go to Staten Island and never explained", 0, Lyte_Options);


        Party.moveIn(DJ_Kool_Herc);
        Lyte_House.moveIn(MC_Lyte);
        Campbell_Cave.moveIn(Cindy_Campbell);
        Da_Pink_House.moveIn(Lady_Pink);
        Crazy_House.moveIn(Crazy_Legs);


        System.out.println("Which NYC borough would you like to start in? ");
        //PRINT menu
        System.out.println(java.util.Arrays.asList(Borough.values()));
        String response = input.nextLine();
        Location currentLocation; 

        if( response.equalsIgnoreCase("the_bronx")){
            currentLocation = Party;
        }
        else if (response.equalsIgnoreCase("brooklyn")){
            currentLocation = Lyte_House;

        }
        else if (response.equalsIgnoreCase("queens")){
            currentLocation = Da_Pink_House;
        }
        else if (response.equalsIgnoreCase("campbell cave")){
            currentLocation = Campbell_Cave;
        }
        else if (response.equalsIgnoreCase("crazy_house")){
            currentLocation = Crazy_House; 
        }

        System.out.println("Welcome to " + response + "!");
        System.out.println("A few blocks later you are now at" + currentLocation + "!");




    







        


      

    



       





    }



    



}

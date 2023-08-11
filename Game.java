import java.awt.*;
import javax.swing.JFrame;
import javax.xml.transform.SourceLocator;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void instructions() {
        System.out.println("Congrats! You've been invited to the grand 50th anniversary of Hip-Hop Celebration.");
        System.out.println("Remember that there are 5 main elements of Hip-Hop: Dance, DJing, Mcing, Graffiti, and Knowledge.");
        System.out.println("Your job is to gather 1 pioneer of each of the 5 elements of Hip-Hop at the party together.");
    }

    public static void printMenu(){
        System.out.println("Here are your options:");
        System.out.println("Type H to know your specific location.");
        System.out.println("Type C to see who's here.");
        System.out.println("Type P to speak to a pioneer.");
        System.out.println("Type L to move to the borough on the left.");
        System.out.println("Type R to move to the borough on the right.");
        System.out.println("Type E to exit");

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
        Location Crazy_House = new Location("Crazy_House", "Harlem", Borough.Manhattan);


        Party.setLeft(Crazy_House);
        Lyte_House.setLeft(Da_Pink_House);
        Campbell_Cave.setLeft(Lyte_House);
        Da_Pink_House.setLeft(Party);
        Crazy_House.setLeft(Campbell_Cave);

        Party.setRight(Da_Pink_House);
        Lyte_House.setRight(Campbell_Cave);
        Da_Pink_House.setRight(Lyte_House);
        Campbell_Cave.setRight(Crazy_House);
        Crazy_House.setRight(Party);

        Pioneer DJ_Kool_Herc = new Pioneer("Clive Campbell", "DJ Kool Herc", "DJing", "DJ Kool aka Clive Campbell is often considered the grandfather of Hip-Hop. He and his sister Cindy Campbell threw the Back 2 School Jam on August 11th of 1973 which is often reffered to as the birth of Hip-Hop. ", Party);
        Pioneer MC_Lyte = new Pioneer("Lana Michele Moorer", "MC_Lyte", "MCing", "MC Lyte is a female pioneer of Hip-Hop. She was the first female rapper to release a full album. ", Lyte_House);
        Pioneer Crazy_Legs = new Pioneer("Richard Colón", "Crazy Legs",  "Dance", "Crazy Legs is a Puerto Rican B-Boy, and he was present of the Rock Steady Crew.", Crazy_House);
        Pioneer Lady_Pink = new Pioneer("Sandra Fabara", "Lady Pink", "Graffiti", "Lady Pink is a female Ecuadorian-American graffiti artist.", Da_Pink_House);
        Pioneer Cindy_Campbell = new Pioneer("Cindy Campbell", "Cindy Campbell", "Knowledge", "Cindy Campbell is a woman with many skills. She also happens to be the sister of Clive Campbell, and she hosted the Back 2 Jam", Campbell_Cave);

        String [] Cindy_Options = {"Have a good cry about it", "Have a conversation about the situation", "Silently fume about it."};
        Beef Cindy_Beef = new Beef("Cindy is mad at her brother because he took all the fame for the Back 2 School Jam in 1973", 1, Cindy_Options);
        Cindy_Campbell.addAntagonist(DJ_Kool_Herc, Cindy_Beef);
        Cindy_Beef.isResolved(1);
        System.out.println(Cindy_Beef.getDescription());
        int c = 0;
        for (String o: Cindy_Beef.getPossibleActions()){
            System.out.println(c+ ". " + o);
            c++;
        }

        if (Cindy_Beef.isResolved(1)){
            Cindy_Campbell.resolveBeef(DJ_Kool_Herc, Cindy_Beef);
        }



        String [] Pink_Options = {"Help Cindy make a new and better mural", "Hack Crazy Legs' Youtube and erase a video", "Tell her it is not that big of a deal"};
        Beef Pink_Beef = new Beef("Lady Pink is upset with Crazy Legs because he ruined one of her murals while breaking", 0, Pink_Options);
        Lady_Pink.addAntagonist(Crazy_Legs, Pink_Beef);
        Pink_Beef.isResolved(0);
        System.out.println(Pink_Beef.getDescription());
        int p = 0;
        for (String o: Cindy_Beef.getPossibleActions()){
            System.out.println(p+ ". " + o);
            p++;
        }
        if (Pink_Beef.isResolved(0)){
            Lady_Pink.resolveBeef(Crazy_Legs, Pink_Beef);
        }

        


        String [] Crazy_Options = {"Make him a sandwich that is not as good", "Tell him to get over it", "Get MC Lyte to apologize with tears"};
        Beef Crazy_Beef = new Beef("MC Lyte ate Crazy Legs' favorite sandwich last week", 2, Crazy_Options);
        Crazy_Legs.addAntagonist(MC_Lyte, Crazy_Beef);
        Crazy_Beef.isResolved(2);
        System.out.println(Crazy_Beef.getDescription());
        int z = 0;
        for (String o: Cindy_Beef.getPossibleActions()){
            System.out.println(z+ ". " + o);
            z++;
        }
        if (Pink_Beef.isResolved(2)){
            Lady_Pink.resolveBeef(Crazy_Legs, Pink_Beef);
        }

        
        String [] Lyte_Options = {"Give her Cindy's long lost apology letter", "Give her a hug", "Have an unproductive conversation"};
        Beef Lyte_Beef = new Beef("Cindy left me to go to Staten Island and never explained", 0, Lyte_Options);
        MC_Lyte.addAntagonist(Cindy_Campbell, Lyte_Beef);
        Lyte_Beef.isResolved(0);
        System.out.println(Lyte_Beef.getDescription());
        int l = 0;
        for (String o: Cindy_Beef.getPossibleActions()){
            System.out.println(l+ ". " + o);
            l++;
        }
        if (Pink_Beef.isResolved(0)){
            Lady_Pink.resolveBeef(Crazy_Legs, Pink_Beef);
        }
        


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
        Borough borough;


        if( response.equalsIgnoreCase("the bronx")){
            currentLocation = Party;
            borough = Borough.The_Bronx;
            
        }
        else if (response.equalsIgnoreCase("brooklyn")){
            currentLocation = Lyte_House;
            borough = Borough.Brooklyn;

        }
        else if (response.equalsIgnoreCase("queens")){
            currentLocation = Da_Pink_House;
            borough = Borough.Queens;
        }
        else if (response.equalsIgnoreCase("staten island")){
            currentLocation = Campbell_Cave;
            borough = Borough.Staten_Island;
        }
        else if (response.equalsIgnoreCase("manhattan")){
            currentLocation = Crazy_House; 
            borough = Borough.Manhattan;
        }
        else {
            System.out.println("I did not understand that! Starting in The Bronx");
            currentLocation = Party;
            borough = Borough.The_Bronx;
        }

        System.out.println("Welcome to " + borough + "!" );
        printMenu();
        

        while (!response.equalsIgnoreCase("e") ){
            response = input.nextLine();
            //process the response 
            // if (response.equalsIgnoreCase("p"))
            //     currentLocation.talkTo(Cindy_Campbell);
            //     currentLocation.talkTo(DJ_Kool_Herc);
            //     currentLocation.talkTo(Lady_Pink);
            //     currentLocation.talkTo(Crazy_Legs);
            //     currentLocation.talkTo(MC_Lyte);

            // }

            if (response.equalsIgnoreCase("h")){
                currentLocation.printLocation();
            }

            if (response.equalsIgnoreCase("c")){
                currentLocation.printPioneers();
            }

            if(response.equalsIgnoreCase("p")){

                if(currentLocation.pioneers.size() > 1){
                    System.out.println("This is the party, no one wants to talk, go somewhere else!");
                }

                else{
                    currentLocation.talkTo(currentLocation.pioneers.get(index:0));
                }
            }


            else if (response.equalsIgnoreCase("l")){
                currentLocation.goLeft();
                System.out.println("Welcome to the " + borough + "!" );
                printMenu();
                
            }
            else if (response.equalsIgnoreCase("r")){
                currentLocation.goRight();
                System.out.println("Welcome to the " + borough + "!");
                printMenu();
            }

            else if (response.equalsIgnoreCase("e")){
                System.out.println("You have ended the game goodbye!");
                break;
            }

            else{
                System.out.println("I did not understand that");
                printMenu();
            }

            

               
            
    
        }

        // while (response.equalsIgnoreCase("p") ){
        //     response = input.nextLine();
    
        //     if (DJ_Kool_Herc.getLocation() != currentLocation))){

        //     }

       

        
        
        

        



        // options are go left go right or talk to someone or exit
        // print menu or available options 
        // process input




    







        


      

    



       





    }



    



}

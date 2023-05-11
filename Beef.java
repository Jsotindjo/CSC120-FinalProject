public class Beef {
    private String description;
    private int right_answer;
    private String [] possible_actions;

    //Constructor

    public Beef(String description, int right_answer, String [] possible_actions){
        this.description = description;
        this.right_answer= right_answer;
        this.possible_actions = possible_actions;

    }

    public String getDescription(){
        return this.description;
    }

    public int getRightAnswer(){
        return this.right_answer;
    }

    public String [] getPossibleActions(){
        return this.possible_actions;
    }

    public boolean isResolved(int option_chosen){
        return this.right_answer == option_chosen;

    }

    public static void main(String[] args) {
        String[] options = {"Talk it out", "Go separate ways", "Fight to the death"};

        Beef myBeef = new Beef("Jordan and razie never agree on anything.", 0, options);
        myBeef.isResolved(0);
        System.out.println(myBeef.getDescription());
        int i = 0;
        for (String o: myBeef.getPossibleActions()){
            System.out.println(i+ ". " + o);
            i++;
        }
        System.out.println(myBeef.isResolved(0));
    }


}

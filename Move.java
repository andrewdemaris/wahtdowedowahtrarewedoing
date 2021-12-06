public class Move {

    String name;
    String type;
    String category;
    int power;
    double accuracy;
    int PP;

    public Move(String initialName,String initialType, String initialCategory, int initialPower, double initialAccuracy, int initialPP) {
        name = initialName;
        type = initialType;
        category = initialCategory;
        power = initialPower;
        accuracy = initialAccuracy;
        PP = initialPP;
    }
    public Move(){
        name = "DNE";
        type = "";
        category = "";
        power = 0;
        accuracy = 0;
        PP = 0;
    }
}

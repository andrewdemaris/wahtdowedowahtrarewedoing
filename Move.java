public class Move {

    String name;
    String type; //I don't want to even start to consider type advantages/disadvantages
    String category; //might change to a simpler type b/c there's only three options
    int power;
    double accuracy;
    int PP;

    public Move(String IName,String IType, String ICategory, int IPower, double IAccuracy, int IPP) {
        name = IName;
        type = IType;
        category = ICategory;
        power = IPower;
        accuracy = IAccuracy;
        PP = IPP;
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

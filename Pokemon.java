public class Pokemon {

    String name;
    int xp;
    int level;
    double catchRate;
    //insert how you store a sprite here
    //stats
    int BaseHP;
    int BaseAttack;
    int BaseDefence;
    int BaseSPAttack;
    int BaseSPDefence;
    int BaseSpeed;
    //moves
    Move[] advancement = new Move[11]; //I'm capping level advancement at 10 rn
    Move[] moveSet = new Move[4]; //current known moves
    //things Emeline does not want to track rn, abilities, shape, footprint, friendship level, anything related to breeding

    public Pokemon(String initialName, int initialXp, double initialCatchRate,
                   int initialBaseHP, int initialBaseAttack, int initialBaseDefence, int initialBaseSPAttack, int initialBaseSPDefence, int initialBaseSpeed){
        name = initialName;
        xp = initialXp;
        level = -1; //function of xp, I'll look it up in the morning
        catchRate = initialCatchRate;
        BaseHP = initialBaseHP;
        BaseAttack = initialBaseAttack;
        BaseDefence = initialBaseDefence;
        BaseSPAttack = initialBaseSPAttack;
        BaseSPDefence = initialBaseSPDefence;
        BaseSpeed = initialBaseSpeed;
        for(int i = 0; i < advancement.length; i++) {
            advancement[i] = new Move();
        }
        //might delete the placeholder no move b/c when autofilling wild pokemon it's easier to filter out nulls

    }

    public static void Pokemon(String[] args) {
        //move 'list'
        Move tackle = new Move ("tackle", "normal", "physical", 40, 1, 35);
        Move withdraw = new Move ("withdraw", "water", "status", 0, 10, 40);
        Move leafage = new Move ("leafage", "grass", "physical", 40, 1, 40);
        Move growth = new Move ("growth", "normal", "status", 0, 10, 20);

        //example pokemon
        Pokemon Turtwig = new Pokemon("Turtwig", 500, 11.9, 55, 68, 64, 45, 55, 31);
        Turtwig.advancement[1] = tackle; //at level 1 Turtwig knows tackle
        Turtwig.advancement[5] = withdraw;
        Turtwig.advancement[6] = leafage;
        Turtwig.advancement[10] = growth;
    }
}

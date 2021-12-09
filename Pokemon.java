public class Pokemon {

    String name;
    String type;
    int xp;
    int level;
    double catchRate;
    //insert how you store a sprite here
    //stats
    int baseHP;
    int baseAttack;
    int baseDefence;
    int baseSPAttack;
    int baseSPDefence;
    int baseSpeed;
    //moves
    Move[] advancement = new Move[101]; //I'm capping level advancement at 10 rn
    Move[] moveSet = new Move[4]; //current known moves
    //things Emeline does not want to track rn, abilities, shape, footprint, friendship level, anything related to breeding

    public Pokemon(String IName, String Itype, double ICatchRate, int IBHP, int IBAttack, int IBDefence,
                   int IBSPAttack, int IBSPDefence, int IBSpeed){
        name = IName;
        type = Itype;
        xp = 0;
        level = 0; //function of xp, I'll look it up in the morning
        catchRate = ICatchRate;
        baseHP = IBHP;
        baseAttack = IBAttack;
        baseDefence = IBDefence;
        baseSPAttack = IBSPAttack;
        baseSPDefence = IBSPDefence;
        baseSpeed = IBSpeed;
        /* for(int i = 0; i < advancement.length; i++) {
            advancement[i] = new Move();
        } */
        //might delete the placeholder no move b/c when autofilling wild pokemon it's easier to filter out nulls

    }

    public static Pokemon generateWildPokemon(Pokemon temp, int initialXp) {
        temp.xp = initialXp; //or insert some equation here based on zone or whatever
        int EV = 0; //placeholder
        temp.level = (temp.xp/1000) + 1;
        temp.baseHP = (int)((((2*temp.baseHP + 7 + EV)*temp.level)/100.0) + temp.level + 10); //again, grab the function for this \/
        temp.baseAttack = (int)(((2*temp.baseAttack + 8 + EV)*temp.level)/100.0) + 5;
        temp.baseDefence = (int)(((2*temp.baseDefence + 8 + EV)*temp.level)/100.0) + 5;
        temp.baseSPAttack = (int)(((2*temp.baseSPAttack + 8 + EV)*temp.level)/100.0) + 5;
        temp.baseSPDefence = (int)(((2*temp.baseSPDefence + 8 + EV)*temp.level)/100.0) + 5;
        temp.baseSpeed = (int)(((2*temp.baseSpeed + 8 + EV)*temp.level)/100.0) + 5;

        for(int i = temp.level; i >= 0; i--) {
            if(temp.advancement[i] != null) {
                for(int j = 0; j < 4; j++) {
                    if(temp.moveSet[j] != null) {
                        temp.moveSet[j] = temp.advancement[i];
                    }
                }
            }
        }
        return temp;
    }

    public static void printMove(Move temp) {
        System.out.print(temp.name + ": " + temp.type + ", " + temp.category + ", ");
        if(temp.category.equals("status") || temp.power == 0) {
            System.out.print("it does nothing atm, ");
        } else {
            System.out.print("Power " + temp.power + ", ");
        }
        if(temp.accuracy == 10) {
            System.out.print("always works");
        } else {
            System.out.print("Accuracy " + temp.accuracy*100 + "%");
        }
        System.out.print(", & PP " + temp.PP);
    }

    public static void printPokemon(Pokemon temp){
        System.out.println("Look, it's a " + temp.name + "! They're a " + temp.type + "-type Pokemon.");
        System.out.println("With " + temp.xp + " xp they're level " + temp.level + ".");
        System.out.println("This one has " + temp.baseHP + " HP, " + temp.baseAttack + " Attack, " + temp.baseDefence + " Defence, ");
        System.out.println(temp.baseSPAttack + " Special Attack, " + temp.baseSPDefence + " Special Defence, and " + temp.baseSpeed + " Speed.");
        System.out.println("They know "); printMove(temp.moveSet[0]); System.out.println(", ");
        printMove(temp.moveSet[1]); System.out.println(", ");
        printMove(temp.moveSet[2]); System.out.println(", and ");
        printMove(temp.moveSet[3]);

    }

    public static void main(String[] args) {
        //Some Gen 1 Moves to play with:
        Move absorb = new Move("absorb", "grass", "special", 20, 1, 25); //half damage done heals attacker
        Move acid = new Move("acid", "poison", "special", 40, 1, 30); //may?? lower target's defence
        Move acidArmor = new Move("acid armor", "poison", "status", 0, 10, 20); //sharply raises attacker's defence
        Move agility = new Move("agility", "psychic", "status", 0, 10, 30); //Sharply raises user's Speed.
        Move amnesia = new Move("amnesia", "psychic", "status", 0, 10, 20); //Sharply raises user's Special Defense.
        Move auroraBeam = new Move("aurora beam", "ice", "special", 65, 1, 20); //May lower opponent's Attack.

        Move barrage = new Move("barrage", "normal", "physical", 15, .85, 20); //Hits 2-5 times in one turn.
        Move barrier = new Move("barrier", "psychic", "status", 0, 10, 20); //Sharply raises user's Defense.
        Move bide = new Move("bide", "normal", "physical", 0, 10, 10); //User takes damage for two turns then strikes back double.
        Move bind = new Move("bind", "normal", "physical", 15, .85, 20); //Traps opponent, damaging them for 4-5 turns.
        Move bite = new Move("bite", "normal", "physical", 60, 1, 25); //May cause flinching.
        Move blizzard = new Move("blizzard", "ice", "special", 110, .70, 5); //May freeze opponent.
        Move bodySlam = new Move("body slam", "normal", "physical", 85, 1, 15); //May paralyze opponent.
        Move boneClub = new Move("bone club", "ground", "physical", 65, .85, 20); //May cause flinching.
        Move boomerang = new Move("boomerang", "ground", "physical", 50, .90, 10); //Hits twice in one turn.
        Move bubble = new Move("bubble", "water", "special", 40, 1, 30); //May lower opponent's Speed.
        Move bubbleBeam = new Move("bubble beam", "water", "special", 65, 1, 20); //May lower opponent's Speed.

        Move clamp = new Move("clamp", "water", "physical", 35, .85, 15); //Traps opponent, damaging them for 4-5 turns.
        Move cometPunch = new Move("comet punch", "normal", "physical", 18, .85, 15); //Hits 2-5 times in one turn.
        Move confuseRay = new Move("confuse ray", "ghost", "status", 0, 10, 10); //Confuses opponent.
        Move confusion = new Move("confusion", "psychic", "special", 50, 1, 25); //May confuse opponent.
        Move constrict = new Move("constrict", "normal", "physical", 10, 1, 35); //May lower opponent's Speed by one stage.
        Move conversion = new Move("conversion", "normal", "status", 0, 10, 30); //Changes user's type to that of its first move.
        Move counter = new Move("counter", "fighting", "physical", 0, 1, 20); //When hit by a Physical Attack, user strikes back with 2x power.
        Move crabHammer = new Move("crab hammer", "water", "physical", 100, .90, 10); //High critical hit ratio.
        Move cut = new Move("cut", "normal", "physical", 50, .95, 30);

        Move defenceCurl = new Move("defence curl", "normal", "status", 0, 10, 40); //Raises user's Defense.
        Move dig = new Move("dig", "ground", "physical", 80, 1, 10); //Digs underground on first turn, attacks on second. Can also escape from caves.
        Move disable = new Move("disable", "normal", "status", 0, 1, 20); //Opponent can't use its last attack for a few turns.
        Move dizzyPunch = new Move("dizzy punch", "normal", "physical", 70, 1, 10); //May confuse opponent.
        Move doubleKick = new Move("double kick", "fighting", "physical", 30, 1, 30); //Hits twice in one turn.
        Move doubleSlap = new Move("double slap", "normal", "physical", 15, .85, 10); //Hits 2-5 times in one turn.
        Move doubleTeam = new Move("double team", "normal", "status", 0, 10, 15); //Raises user's Evasiveness.
        Move doubleEdge = new Move("double-edge", "normal", "physical", 120, 1, 15); //User receives recoil damage.
        Move dragonRage = new Move("dragon rage", "dragon", "special", 0, 1, 10); //Always inflicts 40 HP.
        Move dreamEater = new Move("dream eater", "psychic", "special", 100, 1, 15); //User recovers half the HP inflicted on a sleeping opponent.
        Move drillPeck = new Move("drill peck", "flying", "physical", 80, 1, 20);

        Move earthquake = new Move("earthquake", "ground", "physical", 100, 1, 10); //Power is doubled if opponent is underground from using Dig.
        Move eggBomb = new Move("egg bomb", "normal", "physical", 100, .75, 10); //
        Move ember = new Move("ember", "fire", "special", 40, 1, 25); //May burn opponent.
        Move explosion = new Move("explosion", "normal", "physical", 250, 1, 5); //User faints.

        Move fireBlast = new Move("fire blast", "fire", "special", 110, .85, 5); //May burn opponent.
        Move firePunch = new Move("fire punch", "fire", "physical", 75, 1, 15); //May burn opponent.
        Move fireSpin = new Move("fire spin", "fire", "special", 35, .85, 15); //Traps opponent, damaging them for 4-5 turns.
        Move fissure = new Move("fissure", "ground", "physical", 0, .30, 5); //One-Hit-KO, if it hits.
        Move flamethrower = new Move("flamethrower", "fire", "special", 90, 1, 15); //May burn opponent.
        Move flash = new Move("flash", "normal", "status", 0, 1, 20); //Lowers opponent's Accuracy.
        Move fly = new Move("fly", "flying", "physical", 90, .95, 15); //Flies up on first turn, attacks on second turn.
        Move focusEnergy = new Move("focus energy", "normal", "status", 0, 10, 30); //Increases critical hit ratio.
        Move furyAttack = new Move("fury attack", "normal", "physical", 15, .85, 20); //Hits 2-5 times in one turn.
        Move furySwipes = new Move("fury swipes", "normal", "physical", 18, .80, 15); //Hits 2-5 times in one turn.

        Move glare = new Move("glare", "normal", "status", 0, 1, 30); //Paralyzes opponent.
        Move growl = new Move("growl", "normal", "status", 0, 1, 40); //Lowers opponent's Attack.
        Move growth = new Move("growth", "normal", "status", 0, 10, 20); //Raises user's Attack and Special Attack.
        Move guillotine = new Move("guillotine", "normal", "physical", 0, .30, 5); //One-Hit-KO, if it hits.
        Move gust = new Move("gust", "flying", "physical", 40, 1, 35); //Hits Pokémon using Fly/Bounce with double power.

        Move harden = new Move("harden", "normal", "status", 0, 10, 30); //Raises user's Defense.
        Move haze = new Move("haze", "ice", "status", 0, 10, 30); //Resets all stat changes.
        Move headbutt = new Move("headbutt", "normal", "physical", 70, 1, 15); //May cause flinching.
        Move highJumpKick = new Move("high jump kick", "fighting", "physical", 130, .90, 10); //If it misses, the user loses half their HP.
        Move hornAttack = new Move("horn attack", "normal", "physical", 65, 1, 25);
        Move hornDrill = new Move("horn drill", "normal", "physical", 0, .30, 5); //One-Hit-KO, if it hits.
        Move hydroPump = new Move("hydro pump", "water", "special", 110, .80, 5);
        Move hyperBeam = new Move("hyper beam", "normal", "special", 150, .90, 5); //User must recharge next turn.
        Move hyperFang = new Move("hyper fang", "normal", "physical", 80, .90, 15); //May cause flinching.
        Move hypnosis = new Move("hypnosis", "psychic", "status", 0, .60, 20); //Puts opponent to sleep.

        Move iceBeam = new Move("ice beam", "ice", "special", 90, 1, 10); //May freeze opponent.
        Move icePunch = new Move("ice punch", "ice", "physical", 75, 1, 15); //May freeze opponent.

        Move jumpKick = new Move("jump kick", "fighting", "physical", 100, .95, 10); //If it misses, the user loses half their HP.

        Move karateChop = new Move("karate chop", "fighting", "physical", 50, 1, 25); //High critical hit ratio.
        Move kinesis = new Move("kinesis", "psychic", "status", 0, .80, 15); //Lowers opponent's Accuracy.

        Move leechLife = new Move("leech life", "bug", "physical", 80, 1, 10); //User recovers half the HP inflicted on opponent.
        Move leechSeed = new Move("leech seed", "grass", "status", 0, .90, 10); //Drains HP from opponent each turn.
        Move leer = new Move("leer", "normal", "status", 0, 1, 30); //Lowers opponent's Defense.
        Move lick = new Move("lick", "ghost", "physical", 30, 1, 30); //May paralyze opponent.
        Move lightScreen = new Move("light screen", "psychic", "status", 0, 10, 30); //Halves damage from Special attacks for 5 turns.
        Move lovelyKiss = new Move("lovely kiss", "normal", "status", 0, .75, 10); //Puts opponent to sleep.
        Move lowKick = new Move("low kick", "fighting", "physical", 0, 1, 20); //The heavier the opponent, the stronger the attack.

        Move meditate = new Move("meditate", "psychic", "status", 0, 10, 40); //Raises user's Attack.
        Move megaDrain = new Move("mega drain", "grass", "special", 40, 1, 15); //User recovers half the HP inflicted on opponent.
        Move megaKick = new Move("mega kick", "normal", "physical", 120, .75, 5);
        Move megaPunch = new Move("mega punch", "normal", "physical", 80, .85, 20);
        Move metronome = new Move("metronome", "normal", "status", 0, 10, 10); //User performs almost any move in the game at random.
        Move mimic = new Move("mimic", "normal", "status", 0, 10, 10); //Copies the opponent's last move.
        Move minimize = new Move("minimize", "normal", "status", 0, 10, 10); //Sharply raises user's Evasiveness.
        Move mirrorMove = new Move("mirror move", "flying", "status", 0, 10, 20); //User performs the opponent's last move.
        Move mist = new Move("mist", "ice", "status", 0, 10, 30); //User's stats cannot be changed for a period of time.

        Move nightShade = new Move("night shade", "ghost", "special", 0, 1, 15); //Inflicts damage equal to user's level.

        Move payDay = new Move("pay day", "normal", "physical", 40, 1, 20); //A small amount of money is gained after the battle resolves.
        Move peck = new Move("peck", "flying", "physical", 35, 1, 35);
        Move petalDance = new Move("petal dance", "grass", "special", 120, 1, 10); //User attacks for 2-3 turns but then becomes confused.
        Move pinMissile = new Move("pin missile", "bug", "physical", 25, .95, 20); //Hits 2-5 times in one turn.
        Move poisonGas = new Move("poison gas", "poison", "status", 0, .90, 40); //Poisons opponent.
        Move poisonPowder = new Move("poison powder", "poison", "status", 0, .75, 35); //Poisons opponent.
        Move poisonSting = new Move("poison sting", "poison", "physical", 15, 1, 35); //May poison the opponent.
        Move pound = new Move("pound", "normal", "physical", 40, 1, 35);
        Move psybeam = new Move("psybeam", "psychic", "special", 65, 1, 20); //May confuse opponent.
        Move psychic = new Move("psychic", "psychic", "special", 90, 1, 10); //May lower opponent's Special Defense.
        Move psywave = new Move("psywave", "psychic", "special", 0, 1, 15); //Inflicts damage 50-150% of user's level.

        Move quickAttack = new Move("quick attack", "normal", "physical", 40, 1, 30); //User attacks first.

        Move rage = new Move("rage", "normal", "physical", 20, 1, 20); //Raises user's Attack when hit.
        Move razorLeaf = new Move("razor leaf", "grass", "physical", 55, .95, 25); //High critical hit ratio.
        Move razorWind = new Move("razor wind", "normal", "special", 80, 1, 10); //Charges on first turn, attacks on second. High critical hit ratio.
        Move recover = new Move("recover", "normal", "status", 0, 10, 10); //User recovers half its max HP.
        Move reflect = new Move("reflect", "psychic", "status", 0, 10, 20); //Halves damage from Physical attacks for 5 turns.
        Move rest = new Move("rest", "psychic", "status", 0, 10, 10); //User sleeps for 2 turns, but user is fully healed.
        Move roar = new Move("roar", "normal", "status", 0, 10, 20); //In battles, the opponent switches. In the wild, the Pokémon runs.
        Move rockSlide = new Move("rock slide", "rock", "physical", 75, .90, 10); //May cause flinching.
        Move rockThrow = new Move("rock throw", "rock", "physical", 50, .90, 15);
        Move rollingKick = new Move("rolling kick", "fighting", "physical", 60, .85, 15); //May cause flinching.

        Move sandAttack = new Move("sand attack", "ground", "status", 0, 1, 15); //Lowers opponent's Accuracy.
        Move scratch = new Move("scratch", "normal", "physical", 40, 1, 35);
        Move screech = new Move("screech", "normal", "status", 0, .85, 40); //Sharply lowers opponent's Defense.
        Move seismicToss = new Move("seismic toss", "fighting", "physical", 0, 1, 20); //Inflicts damage equal to user's level.
        Move selfDestruct = new Move("self-destruct", "normal", "physical", 200, 1, 5); //User faints.
        Move sharpen = new Move("sharpen", "normal", "status", 0, 10, 30); //Raises user's Attack.
        Move sing = new Move("sing", "normal", "status", 0, .55, 15); //Puts opponent to sleep.
        Move skullBash = new Move("skull bash", "normal", "physical", 130, 1, 10); //Raises Defense on first turn, attacks on second.
        Move skyAttack = new Move("sky attack", "flying", "physical", 140, .90,5); //Charges on first turn, attacks on second. May cause flinching. High critical hit ratio.
        Move slam = new Move("slam", "normal", "physical", 80, .75, 20);
        Move slash = new Move("slash", "normal", "physical", 70, 1, 20); //High critical hit ratio.
        Move sleepPowder = new Move("sleep powder", "grass", "status", 0, .75, 15); //Puts opponent to sleep.
        Move sludge = new Move("sludge", "poison", "special", 65, 1, 20); //May poison opponent.
        Move smog = new Move("smog", "poison", "special", 30, .70, 20); //May poison opponent.
        Move smokeScreen = new Move("smoke screen", "normal", "status", 0, 1, 20); //Lowers opponent's Accuracy.
        Move softBoiled = new Move("soft-boiled", "normal", "status", 0, 10, 10); //User recovers half its max HP.
        Move solarBeam = new Move("solar beam", "grass", "special", 120, 1, 10); //Charges on first turn, attacks on second.
        Move sonicBoom = new Move("sonic boom", "normal","special", 0, .90, 20 ); //Always inflicts 20 HP.
        Move spikeCannon = new Move("spike cannon", "normal", "physical", 20, 1, 15); //Hits 2-5 times in one turn.
        Move splash = new Move("splash", "normal", "status", 0, 10, 40); //Doesn't do ANYTHING.
        Move spore = new Move("spore", "grass", "status", 0, 1, 15); //Puts opponent to sleep.
        Move stomp = new Move("stomp", "normal", "physical", 65, 1, 20); //May cause flinching.
        Move strength = new Move("strength", "normal", "physical", 80, 1, 15);
        Move stringShot = new Move("string shot", "bug", "status", 0, .95, 40); //Sharply lowers opponent's Speed.
        Move struggle = new Move("struggle","normal", "physical", 50, 10, 100); //Only usable when all PP are gone. Hurts the user.
        Move stunSpore = new Move("stun spore", "grass", "status", 0, .75, 30); //Paralyzes opponent.
        Move submission = new Move("submission", "fighting", "physical", 80, .80, 20); //User receives recoil damage.
        Move substitute = new Move("substitute", "normal", "status", 0, 10, 10); //Uses HP to creates a decoy that takes hits.
        Move superFang = new Move("super fang", "normal", "physical", 0, .90, 10); //Always takes off half of the opponent's HP.
        Move supersonic = new Move("supersonic", "normal", "status", 0, .55, 20); //Confuses opponent.
        Move surf = new Move("surf", "water", "special", 90, 1, 15); //Hits all adjacent Pokémon.
        Move swift = new Move("swift", "normal", "special", 60, 10, 20); //Ignores Accuracy and Evasiveness.
        Move swordDance = new Move("sword dance", "normal", "status", 0, 10, 20); //Sharply raises user's Attack.

        Move tackle = new Move("tackle", "normal", "physical", 40, 1, 35);
        Move tailWhip = new Move("tail whip", "normal", "status", 0, 1, 30); //Lowers opponent's Defense.
        Move takeDown = new Move("take down", "normal", "physical", 90, .85, 20); //User receives recoil damage.
        Move teleport = new Move("teleport", "psychic", "status", 0, 10, 20); //Allows user to flee wild battles; also warps player to last PokéCenter.
        Move thrash = new Move("thrash", "normal", "physical", 120, 1, 10); //User attacks for 2-3 turns but then becomes confused.
        Move thunder = new Move("thunder", "electric", "special", 110, .70, 10); //May paralyze opponent.
        Move thunderPunch = new Move("thunder punch", "electric", "physical", 75, 1, 15); //May paralyze opponent.
        Move thunderShock = new Move("thunder shock", "electric", "special", 40, 1, 30); //May paralyze opponent.
        Move thunderWave = new Move("thunder wave", "electric", "status", 0, .90, 10); //Paralyzes opponent.
        Move thunderbolt = new Move("thunderbolt", "electric", "special", 90, 1, 15); //May paralyze opponent.
        Move toxic = new Move("toxic", "poison", "status", 0, .90, 10); //Badly poisons opponent.
        Move transform = new Move("transform", "normal", "status", 0, 10, 10); //User takes on the form and attacks of the opponent.
        Move triAttack = new Move("tri attack", "normal", "special", 80, 1, 10); //May paralyze, burn or freeze opponent.
        Move twineedle = new Move("twineedle", "bug", "physical", 25, 1, 20); //Hits twice in one turn. May poison opponent.

        Move vineWhip = new Move("vine whip", "grass", "physical", 45, 1, 25);
        Move viceGrip = new Move("vice grip", "normal", "physical", 55, 1, 30);

        Move waterGun = new Move("water gun", "water", "special", 40, 1, 25);
        Move waterfall = new Move("waterfall", "water", "physical", 80, 1, 15); //May cause flinching.
        Move whirlwind = new Move("whirlwind", "normal", "status", 0, 10, 20); //In battles, the opponent switches. In the wild, the Pokémon runs.
        Move wingAttack = new Move("wing attack", "flying", "physical", 60, 1, 35);
        Move withdraw = new Move("withdraw", "water", "status", 0, 10, 40);
        Move wrap = new Move("wrap", "normal", "physical", 15, .90, 20); //Traps opponent, damaging them for 4-5 turns.


        //Turtwig example moves
        Move leafage = new Move("leafage", "grass", "physical", 40, 1, 40);
        //Move growth = new Move("growth", "normal", "status", 0, 10, 20);

        //look most of a gen 1 pokedex:
        Pokemon Bulbasaur = new Pokemon("Bulbasaur", "grass",  11.9, 45, 49, 49, 65, 65, 45);
        Bulbasaur.advancement[0] = tackle;
        Bulbasaur.advancement[1] = growl;
        Bulbasaur.advancement[7] = leechSeed;
        Bulbasaur.advancement[13] = vineWhip;
        Bulbasaur.advancement[20] = poisonPowder;
        Bulbasaur.advancement[27] = razorLeaf;
        Bulbasaur.advancement[34] = growth;
        Bulbasaur.advancement[41] = sleepPowder;
        Bulbasaur.advancement[48] = solarBeam;

        Pokemon Ivysaur = new Pokemon("Ivysaur", "grass", 11.9, 60, 62, 63, 80, 80, 60);
        Ivysaur.advancement[0] = tackle;
        Ivysaur.advancement[1] = growl;
        Ivysaur.advancement[2] = leechSeed;
        Ivysaur.advancement[13] = vineWhip;
        Ivysaur.advancement[22] = poisonPowder;
        Ivysaur.advancement[30] = razorLeaf;
        Ivysaur.advancement[38] = growth;
        Ivysaur.advancement[46] = sleepPowder;
        Ivysaur.advancement[54] = solarBeam;

        Pokemon Venusaur = new Pokemon("Venusaur", "grass", 11.9, 80, 82, 83, 100, 100, 80);
        Venusaur.advancement[0] = tackle;
        Venusaur.advancement[1] = growl;
        Venusaur.advancement[2] = leechSeed;
        Venusaur.advancement[3] = vineWhip;
        Venusaur.advancement[22] = poisonPowder;
        Venusaur.advancement[30] = razorLeaf;
        Venusaur.advancement[43] = growth;
        Venusaur.advancement[55] = sleepPowder;
        Venusaur.advancement[65] = solarBeam;

        Pokemon Charmander = new Pokemon("Charmander", "fire", 11.9, 39, 52, 43, 60, 50, 65);
        Charmander.advancement[0] = scratch;
        Charmander.advancement[1] = growl;
        Charmander.advancement[9] = ember;
        Charmander.advancement[15] = leer;
        Charmander.advancement[22] = rage;
        Charmander.advancement[30] = slash;
        Charmander.advancement[38] = flamethrower;
        Charmander.advancement[46] = fireSpin;

        Pokemon Charmeleon = new Pokemon("Charmeleon", "fire", 11.9, 58, 64, 58, 80, 65, 80);
        Charmeleon.advancement[0] = scratch;
        Charmeleon.advancement[1] = growl;
        Charmeleon.advancement[2] = ember;
        Charmeleon.advancement[15] = leer;
        Charmeleon.advancement[24] = rage;
        Charmeleon.advancement[33] = slash;
        Charmeleon.advancement[42] = flamethrower;
        Charmeleon.advancement[56] = fireSpin;

        Pokemon Charizard = new Pokemon("Charizard", "fire", 11.9, 78, 84, 78, 109, 85, 100);
        Charizard.advancement[0] = scratch;
        Charizard.advancement[1] = growl;
        Charizard.advancement[2] = ember;
        Charizard.advancement[3] = leer;
        Charizard.advancement[24] = rage;
        Charizard.advancement[36] = slash;
        Charizard.advancement[46] = flamethrower;
        Charizard.advancement[55] = fireSpin;

        Pokemon Squirtle = new Pokemon("Squirtle", "water", 11.9, 44, 48, 65, 50, 64, 43);
        Squirtle.advancement[0] = tackle;
        Squirtle.advancement[1] = tailWhip;
        Squirtle.advancement[8] = bubble;
        Squirtle.advancement[15] = waterGun;
        Squirtle.advancement[22] = bite;
        Squirtle.advancement[28] = withdraw;
        Squirtle.advancement[35] = skullBash;
        Squirtle.advancement[42] = hydroPump;

        Pokemon Wartortle = new Pokemon("Wartortle", "water", 11.9, 59, 63, 80, 65, 80, 58);
        Wartortle.advancement[0] = tackle;
        Wartortle.advancement[1] = tailWhip;
        Wartortle.advancement[2] = bubble;
        Wartortle.advancement[15] = waterGun;
        Wartortle.advancement[24] = bite;
        Wartortle.advancement[31] = withdraw;
        Wartortle.advancement[39] = skullBash;
        Wartortle.advancement[47] = hydroPump;

        Pokemon Blastoise = new Pokemon("Blastoise", "water", 11.9, 79, 83, 100, 85, 105, 78);
        Blastoise.advancement[0] = tackle;
        Blastoise.advancement[1] = tailWhip;
        Blastoise.advancement[2] = bubble;
        Blastoise.advancement[3] = waterGun;
        Blastoise.advancement[24] = bite;
        Blastoise.advancement[31] = withdraw;
        Blastoise.advancement[42] = skullBash;
        Blastoise.advancement[52] = hydroPump;

        //example pokemon
        Pokemon Turtwig = new Pokemon("Turtwig", "grass", 11.9, 55, 68, 64, 45, 55, 31);
        Turtwig.advancement[1] = tackle; //at level 1 Turtwig knows tackle
        Turtwig.advancement[5] = withdraw;
        Turtwig.advancement[6] = leafage;
        Turtwig.advancement[10] = growth;

        //Pokemon test1 = generateWildPokemon(Charizard, 10000);
        //printPokemon(test1);
        //Note, generateWildPokemon does not properly put moves into moveSet[] rn

        Pokemon test2 = generateWildPokemon(Charizard, 10000);
        test2.moveSet[0] = tackle;
        test2.moveSet[1] = teleport;
        test2.moveSet[2] = swift;
        test2.moveSet[3] = dragonRage;
        printPokemon(test2);
        //this one will print
    }
}

public class Human {
    //Strength, stealth, and intellagence default at 3
    protected int strength = 3;
    protected int stealth = 3;
    protected int intellagence = 3;
    //Health will default at 100
    protected int healthLvl = 100; 


    //Setters
    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }

    public void setIntellagence(int intellagence){
        this.intellagence = intellagence; 
    }
    
    //Getters
    public int getStrength(){
        return this.strength;
    }

    public int getStealth(){
        return this.stealth;
    }

    public int getIntellagence(){
        return this.intellagence;
    }

    public Human(int healthLvl) {
        this.healthLvl = healthLvl;
    }
    //Human attack method will decrease health by stregth level
    public void attack(Human target) {
        System.out.println("\n");
        System.out.println("Beginning Health: " + this.healthLvl);
        target.healthLvl -= this.strength;
        System.out.println("\n----------------THIS IS AN ATTACK!--------------\n");
        System.out.println("(I've been attacked!)Heatlh Level dercread to: " + this.healthLvl);
    }


}

public class Human {
    //Strength, stealth, and intellagence default at 3
    protected int strength = 3;
    protected int stealth = 3;
    protected int intellagence = 3;
    //Health default: 100
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
        target.healthLvl -= this.strength;
        System.out.println("(I've been attacked!)Heatlh Level decreased to: " + target.healthLvl);
    }

    public int currentHealthLvl(int healthLvl) {
        this.healthLvl -= healthLvl;
        return this.healthLvl;
    }


}
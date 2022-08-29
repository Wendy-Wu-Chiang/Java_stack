public class Wizard extends Human {

    public Wizard(int healthLvl) {
        super(healthLvl);
    
    //Set intellagence level
    this.intellagence = 8;
    //Set Health level
    this.healthLvl = 50;
    }
    public int getIntellagence(){
        return this.intellagence;
    }

    public void setIntellagence(int intellagence){
        this.intellagence = intellagence;
    }
    //Create method HEAL that heals whomever it was cast on for an amount equal to the wizards intellagence
    public void heal(Human healed) {
        healed.healthLvl += intellagence;
        System.out.println("(HEALED!) Health level increased to: " + healed.healthLvl);
    }

    //Create method FIREBALL that decreases the health of whichever object it attacked by 3*wizard intellagence
    public void fireball(Human attacked) {
        attacked.healthLvl -= 3*intellagence;
        System.out.println("(Attacked!) Health level decreased to: " + attacked.healthLvl);
        System.out.println("Wizard health: " + this.healthLvl);
    }

}
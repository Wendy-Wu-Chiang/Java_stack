public class Ninja extends Human{

    public Ninja(int healthLvl) {
        super(healthLvl);
        //Set default health level
        this.healthLvl = 100;
        //Set STEALTH level
        this.stealth = 10;
    }

    //Method STEAL that takes health from another human by stealth level then gives that health back to ninja.
    public void steal(Human stolenFrom){
        stolenFrom.healthLvl -= this.stealth;
        this.healthLvl += this.stealth;
        System.out.println("(Oh man. That ninja stole from me!) Health level decreased to: " + stolenFrom.healthLvl);
        System.out.println("Ninja health level increased to: " + this.healthLvl);
    }
    //Method RUN AWAY that decreases ninja's health by 10
    public void runAway(){
        this.healthLvl -= 10;
        System.out.println("(<--Running away..Swoosh!--<) Ninja health level decreased to: "+ this.healthLvl);
    }
}
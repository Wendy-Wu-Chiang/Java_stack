public class Samurai extends Human {
    //Default health 200
    protected int healthLvl = 200;
    //Number of samurai
    protected static int numOfSamurai = 0;

    public Samurai(int healthLvl){
        super(healthLvl);
        Samurai.numOfSamurai++;
    }

    //Method deathBlow that attacks an object and decreases its health to 0, but also halves the Samurai's health.
    public void deathBlow(Human destroyed){
        destroyed.healthLvl = 0;
        this.healthLvl -= (this.healthLvl/2);
    }
    
    //Method meditate which heals the Samurai back to full health
    public void meditate(int healthLvl){
        this.healthLvl += this.healthLvl;
        System.out.println("Samurai health level has been restored to: " + this.healthLvl);
    }

    //Method howMany that returns the current number of Samurai.
    public static int howMany() {
        System.out.printf("Total number of Samurai: %d ", Samurai.numOfSamurai);
        return Samurai.numOfSamurai;
    }
}
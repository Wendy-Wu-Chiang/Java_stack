public class Bat extends Mammal {
    
    public Bat(int energyLevel) {
        super(energyLevel);
    }
    //Bat will fly, eat humans, and attack a town
    public void fly() {
        energyLevel -= 50;
        System.out.println("Bat flew!--Energy Level decreased to: " + this.energyLevel);
    }

    public void eatHumans() {
        energyLevel += 25;
        System.out.println("Bat ate human!--Energy Level increased to: " + this.energyLevel);
    }

    public void attackTown() {
        energyLevel -= 100;
        System.out.println("Bat attacked town--Energy Level decreased to: " + this.energyLevel);
    }
}
public class Gorilla extends Mammal {

    public Gorilla(int energyLevel) {
        super(energyLevel);

    }
    
    public void throwSomething() {
        energyLevel -= 5;
        System.out.println("Energy level decreased to: " + this.energyLevel);
    }

    public void eatBananas()  {
        energyLevel += 10;
        System.out.println("Energy level increased to: " + this.energyLevel);
    }

    public void climb() {
        energyLevel -= 10;
        System.out.println("Energy level decreased to: " + this.energyLevel);
    }
    //Method to show current energy level after actions
    public int currentEnergyLevel(int energyLevel) {
        System.out.println("Remaining energy: " + this.energyLevel);
        this.energyLevel -= energyLevel;
        return this.energyLevel;
    }

}

public class BatTest {
    public static void main(String[] args) {
        Bat bat = new Bat(300);
        System.out.println("Bat's energy level for now...");
        bat.displayEnergyLevel();
        System.out.println("After bat attacked towns...");

        bat.attackTown();
        bat.attackTown();
        bat.attackTown();
        System.out.println("After bat ate some humans");

        bat.eatHumans();
        bat.eatHumans();
        System.out.println("After bat flew some times");
        
        bat.fly();
        bat.fly();
    }
}
public class GorillaTest {
    public static void main(String[] args) {
        Gorilla gorilla = new Gorilla(100);
        System.out.println("------------BEGINNING ENERGY LEVEL:------------\n");
        gorilla.displayEnergyLevel();
        System.out.println("throwing stuff here");
        
        //Show loss of energy from thorwing items.
        gorilla.throwSomething();
        gorilla.throwSomething();
        gorilla.throwSomething();
        
        System.out.println("eating bananas");

        //Show banans eaten
        gorilla.eatBananas();
        gorilla.eatBananas();

        System.out.println("\n---------------------CLIMBING-------------------\n");
        
        //Show times climbed
        gorilla.climb();
        
        //Can you add in a final energy level output?
        System.out.println("\n-------------------------------------------------\n");
        gorilla.currentEnergyLevel(0);
        
    }

}
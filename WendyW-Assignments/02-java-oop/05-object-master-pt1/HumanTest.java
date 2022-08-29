public class HumanTest {
    public static void main(String[] args) {
        Human h = new Human(100);
        h.setStrength(10);
        h.attack(h);

        //Test of Human attributes
        
        // h.getStrength();
        // int strength = h.getStrength();
        // System.out.println(strength);

        // h.setIntellagence(3);
        // h.setStealth(6);
        // int intellagence = h.getIntellagence();
        // int stealth = h.getStealth();
        // System.out.println("Human Intellagence level: "+ intellagence);
        // System.out.println("Human Stealth level: "+ stealth);
    }
}

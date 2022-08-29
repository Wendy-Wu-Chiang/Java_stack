public class HumanTest {
    public static void main(String[] args) {
        Human human = new Human(100);
        Wizard wizard = new Wizard(200);
        Ninja ninja = new Ninja(100);
        Samurai samurai = new Samurai(200);
        Samurai samurai2 = new Samurai(200);
        Samurai samurai3 = new Samurai(200);
        human.getStrength();
        human.getIntellagence();
        wizard.getIntellagence();
        ninja.getStealth();
        samurai.setStrength(3);
        samurai2.setStrength(3);
        samurai.setStealth(3);
        samurai2.setStealth(3);
        

        System.out.println("Wizard VS Ninja");
        System.out.println("Ninja STEALS from Wizard!");
        ninja.steal(wizard);
        wizard.fireball(ninja);
        ninja.runAway();
        System.out.println("Ninja health: " + ninja.currentHealthLvl(0));
        System.out.println("Wizard health: " + wizard.currentHealthLvl(0));

        System.out.println(" Samurai VS Human");
        System.out.println("Human attacks Samurai!");
        human.attack(samurai);
        System.out.println("Samurai uses DEATHBLOW on Human!");
        samurai.deathBlow(human);
        System.out.println("Human health level: " + human.currentHealthLvl(0));
        System.out.println("Samurai uses MEDITATION.");
        samurai.meditate(0);

        System.out.println("Samurai VS Samurai2");
        System.out.println("Samurai1 attacks Samurai2!");
        samurai.attack(samurai2);
        System.out.println("Samurai2 uses DEATHBLOW on Samurai1!");
        samurai2.deathBlow(samurai);
        System.out.println("Samurai1 has been destroyed. Samurai2 health level has decreased to " + samurai2.healthLvl);
        System.out.println("Samurai1 health level: " + samurai.currentHealthLvl(0));

        System.out.println("Samurai3 VS Ninja");
        System.out.println("Ninja attacks Samurai3!");
        ninja.attack(samurai3);
        System.out.println("Ninja STEALS from Samurai3!");
        ninja.steal(samurai3);
        System.out.println("Samurai3 uses DEATHBLOW!");
        samurai3.deathBlow(ninja);
        System.out.println("Ninja has been destroyed. Samurai3 health level has decreased to " + samurai3.healthLvl);
        System.out.println("Ninja health level: " + samurai.currentHealthLvl(0));
        System.out.println("Samurai3 uses MEDITATION.");
        samurai3.meditate(0);
        
        System.out.println("The end...");
        Samurai.howMany();
        
        


    }
}
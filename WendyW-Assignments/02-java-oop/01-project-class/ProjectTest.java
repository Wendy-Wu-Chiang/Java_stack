import java.util.ArrayList;
public class ProjectTest {
    public static void main(String[] args) {
        double[] portCost = {100.00, 200.00};
        Project newProj1 = new Project();
        newProj1.getName();
        newProj1.setName("One Thousand Buddha Temple");
        newProj1.getDescription();
        newProj1.setDescription("To remodel the temple");
        newProj1.getCost();
        newProj1.setCost(100.00);
        String printThis = newProj1.elevatorPitch();
        System.out.println(printThis);
        
        Project newProj2 = new Project();
        newProj2.getName();
        newProj2.setName("One Thousand Buddha Temple");
        newProj2.getDescription();
        newProj2.setDescription("To add some facilities");
        newProj2.getCost();
        newProj2.setCost(200.00);
        String printOther = newProj2.elevatorPitch();
        System.out.println(printOther);

        ArrayList<Object> portfolio = new ArrayList<Object>();
        portfolio.add(printThis);
        portfolio.add(printOther);
        portfolio.add(portCost);
        System.out.println(portfolio);

        Project.portCost(portCost);

    }
}
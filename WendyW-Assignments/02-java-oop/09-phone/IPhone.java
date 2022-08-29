// import java.util.ArrayList;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getRingTone();
    }
    @Override
    public String unlock() {
        return "IPhone unlocked via facial recognition";
    }
    @Override
    public void displayInfo() {

        System.out.println("IPhone " + getVersionNumber() + " from " + getCarrier());
        
        // System.out.printf("IPhone version: %s\n" , getVersionNumber());

        // System.out.printf("IPhone battery percentage: %d\n" , getBatteryPercentage()); 

        // System.out.println("IPhone carrier: " + getCarrier());
        
        // System.out.println("IPhone ring tone: " + getRingTone());
    }
}
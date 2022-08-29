public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getRingTone();
    }

    @Override
    public String unlock() {
        return "Galaxy unlocked through password";
    }

    @Override
    public void displayInfo() {

        System.out.println("Galaxy " + getVersionNumber() + " from " + getCarrier());
        // System.out.printf("Galaxy version: %s\n" , getVersionNumber());

        // System.out.printf("Galaxy battery percentage: %d\n" , getBatteryPercentage()); 

        // System.out.println("Galaxy carrier: " + getCarrier());
        
        // System.out.println("Galaxy ring tone: " + getRingTone());
    }
}
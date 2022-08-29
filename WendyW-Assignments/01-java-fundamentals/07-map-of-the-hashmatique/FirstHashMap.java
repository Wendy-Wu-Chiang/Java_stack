
import java.util.HashMap;
import java.util.Set;

public class FirstHashMap{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();//Create a trackList of type HashMap
        trackList.put("Take Me Home, Country Roads", "Almost heaven, West Virginia Blue Ridge Mountains...");
        trackList.put("I'm Yours", "Well, you done done me and you bet I felt it I tried to be chil...");
        trackList.put("Wagon Wheel", "Headin' down south to the land of the pines I'm thumbin' my way into North Caroline...");
        trackList.put("If I Die Young", "If I die young bury me in satin Lay me down on a bed of roses...");//Add in at least 4 songs that are stored by title

        String oneSong = trackList.get("Take Me Home, Country Roads");
        System.out.println(oneSong);//Pull out one of the songs by its track title

        
        // System.out.println(trackList.containsKey("Be kind, kinda")); // Returns boolean value.
        // System.out.println(trackList.containsValue("Most of the day is spent with you")); //Returns boolean value.
        // System.out.println(trackList.size());
        // System.out.println(trackList.values());

        //Use keySet to get keys.
        Set<String> keys = trackList.keySet(); // "keySet()" refers to the HashMap that was created
        for(String key: keys) {
            System.out.println(key + ": "+trackList.get(key));
        }
    }
}
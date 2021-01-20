package wraith.coloredcraftingstations;

import java.util.HashMap;
import java.util.HashSet;

public class StationsInfo {

    public static final HashSet<String> COLORS = new HashSet<String>(){{
        add("red");
        add("white");
        add("gray");
        add("light_gray");
        add("black");
        add("brown");
        add("orange");
        add("lime");
        add("green");
        add("cyan");
        add("magenta");
        add("purple");
        add("light_blue");
        add("yellow");
        add("pink");
        add("blue");
    }};

    public static final HashMap<String, String> PLANKS = new HashMap<String, String>(){{
        put("oak", "minecraft");
        put("dark_oak", "minecraft");
        put("spruce", "minecraft");
        put("acacia", "minecraft");
        put("jungle", "minecraft");
        put("birch", "minecraft");
        put("warped", "minecraft");
        put("crimson", "minecraft");
    }};

    public static void loadBYGSupport() {
        PLANKS.put("aspen", "byg");
        PLANKS.put("baobab", "byg");
        PLANKS.put("blue_enchanted", "byg");
        PLANKS.put("bulbis", "byg");
        PLANKS.put("cherry", "byg");
        PLANKS.put("cika", "byg");
        PLANKS.put("cypress", "byg");
        PLANKS.put("ebony", "byg");
        PLANKS.put("embur", "byg");
        PLANKS.put("ether", "byg");
        PLANKS.put("fir", "byg");
        //PLANKS.put("glacial_oak", "byg");
        PLANKS.put("green_enchanted", "byg");
        PLANKS.put("holly", "byg");
        PLANKS.put("jacaranda", "byg");
        PLANKS.put("lament", "byg");
        PLANKS.put("mahogany", "byg");
        PLANKS.put("mangrove", "byg");
        PLANKS.put("maple", "byg");
        PLANKS.put("nightshade", "byg");
        PLANKS.put("palm", "byg");
        PLANKS.put("pine", "byg");
        PLANKS.put("rainbow_eucalyptus", "byg");
        PLANKS.put("redwood", "byg");
        PLANKS.put("skyris", "byg");
        PLANKS.put("sythian", "byg");
        PLANKS.put("willow", "byg");
        PLANKS.put("witch_hazel", "byg");
        PLANKS.put("zelkova", "byg");
    }

}

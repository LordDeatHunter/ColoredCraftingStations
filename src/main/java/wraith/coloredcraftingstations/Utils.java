package wraith.coloredcraftingstations;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.util.Identifier;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static String createBlockStateJson(String id) {
        return "{\n" +
                "  \"variants\": {\n" +
                "    \"\": {\n" +
                "      \"model\": \"coloredcraftingstations:block/" + id + "\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

    public static String createBlockModelJson(String id) {
        String[] segments = id.split("_");
        String color = "";
        String wood = "";
        int i = 0;
        while (!StationsInfo.COLORS.contains(color)) {
            if (i > 0) {
                color += "_";
            }
            color += segments[i++];
        }
        int start = i;
        while (!StationsInfo.PLANKS.containsKey(wood)) {
            if (i > start) {
                wood += "_";
            }
            wood += segments[i++];
        }
        String woodMod = StationsInfo.PLANKS.get(wood);
        return "{\n" +
                "  \"parent\": \"coloredcraftingstations:block/base_crafting_station\",\n" +
                "  \"textures\": {\n" +
                "    \"top\": \"coloredcraftingstations:block/" + color + "_crafting_station\",\n" +
                "    \"legs\": \"" + woodMod + ":block/" + wood + "_planks\",\n" +
                "    \"particle\": \"block/" + color + "_wool\"\n" +
                "  }\n" +
                "}";
    }

    public static InputStream stringToInputStream(String s) {
        return new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String createBlockItemModelJson(String id) {
        return "{\n" +
                "  \"parent\": \"coloredcraftingstations:block/" + id + "\"\n" +
                "}";
    }

    public static Identifier ID(String id) {
        return new Identifier(ColoredCraftingStations.MOD_ID, id);
    }

    public static JsonObject createRecipeJson(String id) {
        String[] segments = id.split("_");
        String color = "";
        String wood = "";
        int i = 0;
        while (!StationsInfo.COLORS.contains(color)) {
            if (i > 0) {
                color += "_";
            }
            color += segments[i++];
        }
        int start = i;
        while (!StationsInfo.PLANKS.containsKey(wood)) {
            if (i > start) {
                wood += "_";
            }
            wood += segments[i++];
        }
        String woodMod = StationsInfo.PLANKS.get(wood);
        String recipe =
                "{\n" +
                "  \"type\": \"minecraft:crafting_shaped\",\n" +
                "  \"pattern\": [\n" +
                "    \" C \",\n" +
                "    \"PPP\",\n" +
                "    \"P P\"\n" +
                "  ],\n" +
                "  \"key\": {\n" +
                "    \"C\": {\n" +
                "      \"item\": \"minecraft:" + color + "_carpet\"\n" +
                "    },\n" +
                "    \"P\": {\n" +
                "      \"item\": \"" + woodMod + ":" + wood + "_planks\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"result\": {\n" +
                "    \"item\": \"coloredcraftingstations:" + id + "\",\n" +
                "    \"count\": 1\n" +
                "  }\n" +
                "}\n" +
                "\n";
        return getJsonObject(recipe);
    }

    public static JsonObject getJsonObject(String json) {
        try {
            return new JsonParser().parse(json).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            ColoredCraftingStations.LOGGER.error("Error while parsing following json:\n\n" + json);
            return null;
        }
    }

}

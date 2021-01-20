package wraith.coloredcraftingstations.registries;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.CustomItemGroup;
import wraith.coloredcraftingstations.StationsInfo;
import wraith.coloredcraftingstations.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ItemRegistry {
    public static final HashMap<String, Item> ITEMS = new HashMap<>();

    public static void loadItems() {
        for (String color : StationsInfo.COLORS) {
            for (String plank : StationsInfo.PLANKS.keySet()) {
                ITEMS.put(color + "_" + plank + "_crafting_station", new BlockItem(BlockRegistry.BLOCKS.get(color + "_" + plank + "_crafting_station"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
            }
        }
    }

    public static void registerItems(){
        ArrayList<String> items = new ArrayList<>(ITEMS.keySet());
        Collections.sort(items);
        for (String itemID : items){
            Registry.register(Registry.ITEM, Utils.ID(itemID), ITEMS.get(itemID));
        }
    }

}

package wraith.coloredcraftingstations.registries;

import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.*;

import java.util.HashMap;

public class ItemRegistry {
    public static final HashMap<String, Item> COLORED_CRAFTING_STATIONS_ITEMS = new HashMap<String, Item>(){{
        put("crafting_station_red", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_red"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_white", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_white"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_gray", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_gray"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_light_gray", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_light_gray"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_black", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_black"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_brown", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_brown"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_orange", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_orange"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_lime", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_lime"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_green", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_green"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_cyan", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_cyan"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_magenta", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_magenta"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_purple", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_purple"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_light_blue", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_light_blue"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_yellow", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_yellow"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_pink", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_pink"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
        put("crafting_station_blue", new BlockItem(BlockRegistry.COLORED_CRAFTING_STATIONS_BLOCKS.get("crafting_station_blue"), new Item.Settings().group(CustomItemGroup.COLORED_CRAFTING_STATIONS_GROUP)));
    }};

    public static void registerItems(){
        for (String itemID : COLORED_CRAFTING_STATIONS_ITEMS.keySet()){
            Registry.register(Registry.ITEM, new Identifier(ColoredCraftingStations.MOD_ID, itemID), COLORED_CRAFTING_STATIONS_ITEMS.get(itemID));
        }
    }

}

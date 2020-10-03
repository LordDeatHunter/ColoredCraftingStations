package wraith.coloredcraftingstations.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.block.*;

import java.util.HashMap;

public class BlockRegistry {

    public static final HashMap<String, Block> COLORED_CRAFTING_STATIONS_BLOCKS = new HashMap<String, Block>(){{
        put("crafting_station_red", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_white", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_gray", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_light_gray", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_black", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_brown", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_orange", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_lime", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_green", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_cyan", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_magenta", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_purple", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_light_blue", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_yellow", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_pink", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
        put("crafting_station_blue", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
    }};

    public static void registerBlocks(){
        for (String blockID : COLORED_CRAFTING_STATIONS_BLOCKS.keySet()){
            Registry.register(Registry.BLOCK, new Identifier(ColoredCraftingStations.MOD_ID, blockID), COLORED_CRAFTING_STATIONS_BLOCKS.get(blockID));
        }
    }

}

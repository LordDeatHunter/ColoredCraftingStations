package wraith.coloredcraftingstations.registries;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.StationsInfo;
import wraith.coloredcraftingstations.block.*;

import java.util.HashMap;

public class BlockRegistry {

    public static final HashMap<String, Block> BLOCKS = new HashMap<>();

    public static void loadBlocks() {
        for (String color : StationsInfo.COLORS) {
            for (String plank : StationsInfo.PLANKS.keySet()) {
                BLOCKS.put(color + "_" + plank + "_crafting_station", new CraftingStationBlock(FabricBlockSettings.of(Material.WOOD).strength(2.5f).sounds(BlockSoundGroup.WOOD)));
            }
        }
    }

    public static void registerBlocks(){
        for (String blockID : BLOCKS.keySet()){
            Registry.register(Registry.BLOCK, new Identifier(ColoredCraftingStations.MOD_ID, blockID), BLOCKS.get(blockID));
        }
    }

}

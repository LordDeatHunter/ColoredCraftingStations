package wraith.coloredcraftingstations.registries;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import wraith.coloredcraftingstations.ColoredCraftingStations;
import wraith.coloredcraftingstations.StationsInfo;
import wraith.coloredcraftingstations.block.*;

import java.util.HashSet;

public class BlockEntityRegistry {

    public static BlockEntityType<CraftingStationBlockEntity> CRAFTING_STATION_BLOCK_ENTITY;

    public static void loadBlockEntities() {
        Block[] blocks = new Block[StationsInfo.COLORS.size() * StationsInfo.PLANKS.size()];
        int i = 0;
        for (String color : StationsInfo.COLORS) {
            for (String plank : StationsInfo.PLANKS.keySet()) {
                blocks[i++] = BlockRegistry.BLOCKS.get(color + "_" + plank + "_crafting_station");
            }
        }
        CRAFTING_STATION_BLOCK_ENTITY = BlockEntityType.Builder.create(CraftingStationBlockEntity::new, blocks).build(null);
    }

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ColoredCraftingStations.MOD_ID, "crafting_station"), CRAFTING_STATION_BLOCK_ENTITY);
    }

}
